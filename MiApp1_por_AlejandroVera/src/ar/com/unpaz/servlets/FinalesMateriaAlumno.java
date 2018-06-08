package ar.com.unpaz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.unpaz.app.modelo.Alumno;
import ar.com.unpaz.app.modelo.Final;
import ar.com.unpaz.app.servicios.AlumnoService;
import ar.com.unpaz.app.servicios.FinalesService;

/**
 * Servlet implementation class FinalesMateriaAlumno
 */
@WebServlet("/FMatAlumno")
public class FinalesMateriaAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_alumno;
		String id_materia;
		
		id_alumno = request.getParameter("id_alumno");
		id_materia = request.getParameter("id_materia");
		
		FinalesService finalesService = new FinalesService();
		AlumnoService alumnoService = new AlumnoService();
		Alumno alumno = new Alumno();
		alumno = alumnoService.getAlumno(Integer.parseInt(id_alumno));
		
		ArrayList<Final> finales = finalesService.getFinalesByAlumnoAndMateria(Integer.parseInt(id_alumno), Integer.parseInt(id_materia));
		request.setAttribute("finales2", finales);
		request.setAttribute("alumno", alumno);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/Finales.jsp").forward(request, response);
		
		//response.getWriter().println("id_alumno: " + id_alumno + " id_materia:" + id_materia);
		
		
	}

}
