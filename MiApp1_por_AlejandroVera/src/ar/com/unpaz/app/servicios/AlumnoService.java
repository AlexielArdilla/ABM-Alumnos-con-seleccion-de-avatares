package ar.com.unpaz.app.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ar.com.dbgrid.database.Conexion;
import ar.com.unpaz.app.modelo.Alumno;
import ar.com.unpaz.app.modelo.ObservacionAlumno;


public class AlumnoService {

 
		public Alumno getAlumno(int id_alumno){
			Connection con = Conexion.getConnection();
			Alumno alumno = null;
			String queryStr = "SELECT APEL_NOMBRE FROM ALUMNO WHERE ID=?";
			try{
				   PreparedStatement ps = con.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				   ps.setInt(1, id_alumno);
				   ResultSet rs = ps.executeQuery();
				   while (rs.next()){
					   alumno = new Alumno();
					   alumno.setId_alumno(id_alumno);
					   alumno.setApel_nombre(rs.getString("APEL_NOMBRE"));
				   }

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
			return alumno;
			
		}
		
		public ArrayList<Alumno> getAlumnos(){
			
			Connection con = Conexion.getConnection();
			
			ArrayList<Alumno> resultado = new ArrayList<Alumno>();
			
			String queryStr = "SELECT ALUMNO.ID, ALUMNO.APEL_NOMBRE FROM ALUMNO ORDER BY ALUMNO.APEL_NOMBRE ASC";
			
			try{
				   PreparedStatement ps = con.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				   
				   ResultSet rs = ps.executeQuery();
				   
				   Alumno a=null;
				   while (rs.next()){
					   	a = new Alumno();
					   	a.setId_alumno(rs.getInt("ID"));
					   	a.setApel_nombre(rs.getString("APEL_NOMBRE"));
					   	resultado.add(a);
				   }
				   
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
		
		
		public int crearAlumno(Alumno al){
			
			
			Connection con = Conexion.getConnection();
			String sql = "INSERT INTO ALUMNO(ID, APEL_NOMBRE) VALUES (?, ?) "
					+ "INSERT INTO OBSERVACION_ALUMNO(obs_id, avatar_id, descripcion, "
					+ "alu_id, objetivo, observaciones) "
					+ "VALUES (?, 0, 'VACIA', ?, 'VACIA', 'VACIA')";
			
			
			int r;
			
			try{
				
				String query_max_id = "select MAX (ID) from ALUMNO ";
			PreparedStatement max_id = con.prepareStatement(query_max_id);
			ResultSet rss = max_id.executeQuery();

			int id_to_int = 1;

			while (rss.next()) {

				id_to_int = rss.getInt(1);

			}

			 r = 0;
			
			 
	        
	        	PreparedStatement s = con.prepareStatement(sql);
	            s.setInt(1, id_to_int+1);
	            s.setString(2, al.getApel_nombre());
	            s.setInt(3, id_to_int+1);
	            s.setInt(4, id_to_int+1);
	            
	           
	            
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
		
		public int borrarAlumno(Alumno al){
			Connection con = Conexion.getConnection();
			String sql = "DELETE from FINALES where ID_ALUMNO = "+al.getId_alumno()+" "
					+ "DELETE FROM ALUMNO WHERE ID = "+al.getId_alumno();

			int r = 0;
	        try
	        {
	        	PreparedStatement s = con.prepareStatement(sql);
	            
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
		
}
