package ar.com.unpaz.servlets;

import java.io.IOException;
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
import ar.com.unpaz.app.servicios.MateriaService;

/**
 * Servlet implementation class CargarFinal
 */
@WebServlet("/CargarFinal")
public class CargarFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ok = request.getParameter("ok");
		if (ok != null) {
			request.setAttribute("ok", "El final se ha creado correctamente!");
		} else {
			request.setAttribute("ok", "");
		}
		
		//Obtener las materias
		MateriaService ms = new MateriaService();
		request.setAttribute("materias", ms.getMaterias());
		
		//Obtener los alumnos
		AlumnoService as = new AlumnoService();
		request.setAttribute("alumnos", as.getAlumnos());
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/CargarFinal.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_materia = request.getParameter("materias");
		String id_alumno = request.getParameter("alumno");
		String nota = request.getParameter("nota");
		
		FinalesService finalService = new FinalesService();
		Final f = new Final();
		f.setId_materia(Integer.parseInt(id_materia));
		f.setId_alumno(Integer.parseInt(id_alumno));
		f.setNota(Float.parseFloat(nota));
		finalService.crearFinal(f);
		
		response.sendRedirect("./CargarFinal?ok=1");
	}

}
