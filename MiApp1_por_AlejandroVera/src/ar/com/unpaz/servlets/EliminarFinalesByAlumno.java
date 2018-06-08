package ar.com.unpaz.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.unpaz.app.modelo.Alumno;
import ar.com.unpaz.app.servicios.AlumnoService;
import ar.com.unpaz.app.servicios.FinalesService;

/**
 * Servlet implementation class EliminarFinalesByAlumno
 */
@WebServlet("/EliminarFinalesByAlumno")
public class EliminarFinalesByAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarFinalesByAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ok = request.getParameter("ok");
		if (ok != null) {
			request.setAttribute("ok", "Los finales se han eliminado correctamente!");
		} else {
			request.setAttribute("ok", "");
		}
	
		AlumnoService alumnoService = new AlumnoService();
		request.setAttribute("alumnos", alumnoService.getAlumnos());
			
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/EliminarFinalesAlumno.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_alumno = request.getParameter("id_alumno");
		AlumnoService alumnoService = new AlumnoService();
		Alumno alumno = alumnoService.getAlumno(Integer.parseInt(id_alumno));
		FinalesService finalesService = new FinalesService();
		finalesService.borrarFinalesDelAlumno(alumno);
		
		response.sendRedirect("./EliminarFinalesByAlumno?ok=1");
		
		
	}

}
