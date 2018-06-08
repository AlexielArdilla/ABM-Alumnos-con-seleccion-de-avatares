package ar.com.unpaz.app.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ar.com.dbgrid.database.Conexion;
import ar.com.unpaz.app.modelo.Alumno;
import ar.com.unpaz.app.modelo.Final;



public class FinalesService {

		public ArrayList<Final> getFinalesByAlumno(Alumno alumno){
			
			Connection con = Conexion.getConnection();
			
			ArrayList<Final> resultado = new ArrayList<Final>();
			
			String queryStr = "SELECT " 
							  + "   A.ID AS ID_ALUMNO "
					          + ",	F.ID as ID "
					          + ", 	A.APEL_NOMBRE "
					          + ",   M.ID AS ID_MATERIA"
					          + ", 	M.DESCRIPCION AS DESCRIPCION_MATERIA"
					          + ",	F.NOTA "
					          + "FROM "  
					          + "	ALUMNO A, FINALES F, MATERIA M "
					          + "WHERE"
					          
					          + "	A.ID = F.ID_ALUMNO "
					          + "	AND F.ID_MATERIA=M.ID "
					          +	"	AND F.ID_ALUMNO = ? "
					          + "ORDER BY " 
					          + "	M.DESCRIPCION" 
					          +	"	, F.NOTA";
			
			
			try{
				   PreparedStatement ps = con.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				   ps.setInt(1, alumno.getId_alumno());
				   ResultSet rs = ps.executeQuery();
				   
				   Final f=null;
				   while (rs.next()){
					   f = new Final();
					   f.setId(rs.getInt("ID"));
					   f.setApel_nombre(rs.getString("APEL_NOMBRE"));
					   f.setId_materia(rs.getInt("ID_MATERIA"));
					   f.setDescripcion_materia(rs.getString("DESCRIPCION_MATERIA"));
					   f.setNota(rs.getFloat("NOTA"));
					   f.setDeleteURL("./borrarFinal?id_final=" +  rs.getInt("ID") + "&id_alumno=" + rs.getInt("ID_ALUMNO"));
					   resultado.add(f);
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
		
		public ArrayList<Final> getFinales(){
			
			Connection con = Conexion.getConnection();
			
			ArrayList<Final> resultado = new ArrayList<Final>();
			
			String queryStr = "SELECT " 
					 		  + "   A.ID AS ID_ALUMNO "
					          + ",	F.ID as ID "
					          + ",  A.APEL_NOMBRE "
					          + ",   M.ID AS ID_MATERIA"
					          + ", 	M.DESCRIPCION AS DESCRIPCION_MATERIA"
					          + ",	F.NOTA "
					          + "FROM "  
					          + "	ALUMNO A, FINALES F, MATERIA M "
					          + "WHERE"					          
					          + "	A.ID = F.ID_ALUMNO "
					          + "	AND F.ID_MATERIA=M.ID "
					          + "ORDER BY " 
					          + "   A.APEL_NOMBRE"
					          + ",	M.DESCRIPCION" 
					          +	"	, F.NOTA";
			
			
			try{
				   PreparedStatement ps = con.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				   
				   ResultSet rs = ps.executeQuery();
				   
				   Final f=null;
				   while (rs.next()){
					   f = new Final();
					   f.setId(rs.getInt("ID"));
					   f.setApel_nombre(rs.getString("APEL_NOMBRE"));
					   f.setId_materia(rs.getInt("ID_MATERIA"));
					   f.setDescripcion_materia(rs.getString("DESCRIPCION_MATERIA"));
					   f.setNota(rs.getFloat("NOTA"));
					   f.setDeleteURL("./borrarFinal?id_final=" +  rs.getInt("ID") + "&id_alumno=" + rs.getInt("ID_ALUMNO"));
					   resultado.add(f);
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

		
		public ArrayList<Final> getFinalesByAlumnoAndMateria(int id_alumno, int id_materia){
			
			Connection con = Conexion.getConnection();
			
			ArrayList<Final> resultado = new ArrayList<Final>();
			
			String queryStr = "SELECT "
					 		  + "   A.ID AS ID_ALUMNO "
					          + ",	F.ID as ID "
					          + ", 	A.APEL_NOMBRE "
					          + ",   M.ID AS ID_MATERIA"
					          + ", 	M.DESCRIPCION AS DESCRIPCION_MATERIA"
					          + ",	F.NOTA "
					          + "FROM "  
					          + "	ALUMNO A, FINALES F, MATERIA M "
					          + "WHERE"
					          
					          + "	A.ID = F.ID_ALUMNO "
					          + "	AND F.ID_MATERIA=M.ID "
					          +	"	AND F.ID_ALUMNO = ? "
					          + "   AND F.ID_MATERIA= ? "
					          + "ORDER BY " 
					          + "	M.DESCRIPCION" 
					          +	"	, F.NOTA";
			
			
			try{
				   PreparedStatement ps = con.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				   ps.setInt(1, id_alumno);
				   ps.setInt(2, id_materia);
				   ResultSet rs = ps.executeQuery();
				   
				   Final f=null;
				   while (rs.next()){
					   f = new Final();
					   f.setId(rs.getInt("ID"));
					   f.setApel_nombre(rs.getString("APEL_NOMBRE"));
					   f.setId_materia(rs.getInt("ID_MATERIA"));
					   f.setDescripcion_materia(rs.getString("DESCRIPCION_MATERIA"));
					   f.setNota(rs.getFloat("NOTA"));
					   f.setDeleteURL("./borrarFinal?id_final=" +  rs.getInt("ID") + "&id_alumno=" + rs.getInt("ID_ALUMNO"));
					   resultado.add(f);
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
		
		
		public int borrarFinal(Final f){
			Connection con = Conexion.getConnection();
			String sql = "DELETE FROM FINALES " 
					    + "WHERE ID=? ";

			int r = 0;
	        try
	        {
	        	PreparedStatement s = con.prepareStatement(sql);
	            s.setInt(1, f.getId());
	            
	            
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
		
		public int crearFinal(Final f){
			Connection con = Conexion.getConnection();
			String sql = "INSERT INTO FINALES (ID_ALUMNO, ID_MATERIA, NOTA, ID) VALUES " 
					    + "(?, ?, ?, ?) ";
			
			int r;
			
			try{
				
				String query_max_id = "select MAX (ID) from FINALES";
			PreparedStatement max_id = con.prepareStatement(query_max_id);
			ResultSet rss = max_id.executeQuery();

			int id_to_int = 0;

			while (rss.next()) {

				id_to_int = rss.getInt(1);

			}

			 r = 0;
			
	        
	        	PreparedStatement s = con.prepareStatement(sql);
	            s.setInt(1, f.getId_alumno());
	            s.setInt(2, f.getId_materia());
	            s.setFloat(3, f.getNota());
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
		
		public void borrarFinalesDelAlumno(Alumno a){
			Connection con = Conexion.getConnection();
			
			//Obtengo una lista de finales del alumno
			ArrayList<Final> finales = getFinalesByAlumno(a);
			
			try {
				
				con.setAutoCommit(false);  // Desactivar la confirmación automática
				
				for(Final f : finales) {
					this.borrarFinal(f);
				}
				
				con.commit();              // Confirmar la transacción
				
			} catch (Exception e)
	        {
				try {
					con.rollback();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
	            e.printStackTrace();
	        } finally {
	        	try {
	        		con.setAutoCommit(true);  // Desactivar la confirmación automática
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        }
			
		}
}
