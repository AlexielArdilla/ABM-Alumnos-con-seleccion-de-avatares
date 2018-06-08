package ar.com.unpaz.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.unpaz.app.modelo.Alumno;
import ar.com.unpaz.app.modelo.ObservacionAlumno;
import ar.com.unpaz.app.servicios.AlumnoService;
import ar.com.unpaz.app.servicios.ObservacionService;

/**
 * Servlet implementation class CrearAlumno
 */
@WebServlet("/CrearAlumno")
public class CrearAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String apel_nombre = request.getParameter("apel_nombre");
		AlumnoService miAlService = new AlumnoService();
		Alumno miAlumno = new Alumno();
		miAlumno.setId_alumno(0);//despues lo pisa
		miAlumno.setApel_nombre(apel_nombre);
		
		
		miAlService.crearAlumno(miAlumno);
		
		response.sendRedirect("home.html");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
