package ar.com.unpaz.app.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.dbgrid.database.Conexion;
import ar.com.unpaz.app.modelo.Alumno;
import ar.com.unpaz.app.modelo.ObservacionAlumno;


public class ObservacionService {
	
	
	public ObservacionAlumno getObservacionByAlumno(Alumno alumno){
		
		Connection con = Conexion.getConnection();
		
		ObservacionAlumno resultado = new ObservacionAlumno();
		
		String queryStr = "select obs_id, avatar_id, "
				+ "descripcion, alu_id, objetivo, "
				+ "observaciones from observacion_alumno "
				+ "where alu_id = ?";
		
		
		try{
			   PreparedStatement ps = con.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			   ps.setInt(1, alumno.getId_alumno());
			   ResultSet rs = ps.executeQuery();
			   
			   ObservacionAlumno f=null;
			   while (rs.next()){
				   f = new ObservacionAlumno();
				   f.setObs_id(rs.getInt(1));
				   f.setAvatar_id(rs.getInt(2));
				   f.setDescripcion(rs.getString(3));
				   f.setAlu_id(rs.getInt(4));
				   f.setObjetivo(rs.getString(5));
				   f.setObservaciones(rs.getString(6));
				   
			   }
			   resultado = f;
			   rs.close();
			   ps.close();

		}catch(Exception e){
			System.out.println("Error en la ejecución de la sentencia SQL:\n" + e.getMessage());
		}	
		finally{
			if (con != null){
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("login: Error al cerrar la conexion: " + e.getMessage());
					e.printStackTrace();
					
				}
			}
					
		}
		return resultado;
		
		
	}
	
	public int borrarObservacion(ObservacionAlumno f){//*****************************************
		Connection con = Conexion.getConnection();
		String sql = "delete from observacion_alumno where obs_id = ?";

		int r = 0;
        try
        {
        	PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, f.getObs_id());
            
            
            r = s.executeUpdate();
        } catch (Exception e)
        {
        	r = 0;
            e.printStackTrace();
        } finally {
        	try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
        }
        return r;
       
	}
	
	public int crearObservacion(ObservacionAlumno f){//*******************************************
		Connection con = Conexion.getConnection();
		String sql = "INSERT INTO OBSERVACION_ALUMNO (obs_id, avatar_id, descripcion, alu_id, objetivo, observaciones) VALUES " 
				    + "(?, ?, ?, ?, ?, ?, ?)";
		
		int r;
		
		try{
			
			/*String query_max_id = "select MAX (obs_id) from observacion_alumno";
		PreparedStatement max_id = con.prepareStatement(query_max_id);
		ResultSet rss = max_id.executeQuery();

		int id_to_int = 0;

		while (rss.next()) {

			id_to_int = rss.getInt(1);

		}*/

		 r = 0;
		
        
        	PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, f.getAlu_id());
            s.setInt(2, f.getAvatar_id());
            s.setString(3, f.getDescripcion());
            s.setInt(4, f.getAlu_id());
            s.setString(5, f.getObjetivo());
            s.setString(6, f.getObservaciones());
            
            r = s.executeUpdate();
        } catch (Exception e)
        {
        	 r = 0;
            e.printStackTrace();
        } finally {
        	try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
        }
        return r; 
	}
	
	public int updateObservacion(ObservacionAlumno ob){
		
		Connection cn = Conexion.getConnection();
		 int r = 0;
		
		try {
			 String query = "update OBSERVACION_ALUMNO set obs_id = "+ob.getObs_id()+", "
			 		+ "avatar_id = "+ob.getAvatar_id()+","
			 		+ " alu_id = "+ob.getAlu_id()+", descripcion ='"+ob.getDescripcion()+"',"
			 				+ " objetivo = '"+ob.getObjetivo()+"', observaciones = '"+ob.getObservaciones()+"' "
			 		+ "where obs_id = "+ob.getObs_id()+" and alu_id = "+ob.getAlu_id();
			 
			 PreparedStatement p = cn.prepareStatement(query);
	
			 
			  r=p.executeUpdate();
			  
			  if(r>0){ System.out.println("insert exitoso");
			  
				  
			  }
			  cn.close();
			 } catch (SQLException e) {

				 System.out.println("Algo ha fallado!!!");
			
				 
				e.printStackTrace();
			}finally{
				
				try{
					
					cn.close();
					
				}catch(SQLException e){
					
					e.printStackTrace();
					
				}
				
			}
		
		return r;
		
	}
	
}
