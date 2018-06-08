package ar.com.unpaz.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.unpaz.app.modelo.Alumno;
import ar.com.unpaz.app.servicios.AlumnoService;

/**
 * Servlet implementation class BorrarAlumno
 */
@WebServlet("/BorrarAlumno")
public class BorrarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AlumnoService miAlService = new AlumnoService();
		List<Alumno> misAlumnos = miAlService.getAlumnos();
		request.setAttribute("alumnos", misAlumnos);
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/BorrarAlumno.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int alu_id = Integer.parseInt(request.getParameter("id_alumno"));
		AlumnoService as = new AlumnoService();
		Alumno alu = as.getAlumno(alu_id);
		as.borrarAlumno(alu);
		
		response.sendRedirect("./home.html");

		
		
	}
	
}
