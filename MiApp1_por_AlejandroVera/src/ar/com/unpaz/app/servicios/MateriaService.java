package ar.com.unpaz.app.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ar.com.dbgrid.database.Conexion;
import ar.com.unpaz.app.modelo.Materia;

public class MateriaService {
	
	public ArrayList<Materia> getMaterias(){
		
		
		Connection con = Conexion.getConnection();
		
		ArrayList<Materia> resultado = new ArrayList<Materia>();
		
		String queryStr = "SELECT " 
				 		  + "   M.ID  "
				          + ",	M.DESCRIPCION "
				          + "FROM "  
				          + "	MATERIA M ";
		
		try{
			   PreparedStatement ps = con.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			   
			   ResultSet rs = ps.executeQuery();
			   
			   Materia m=null;
			   while (rs.next()){
				   	m = new Materia();
				   	m.setId(rs.getInt("ID"));
				   	m.setDescripcion(rs.getString("DESCRIPCION"));
				   	resultado.add(m);
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

}
