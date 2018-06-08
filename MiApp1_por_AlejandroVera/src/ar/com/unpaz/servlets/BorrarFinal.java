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

/**
 * Servlet implementation class BorrarFinal
 */
@WebServlet("/borrarFinal")
public class BorrarFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarFinal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_alumno = request.getParameter("id_alumno");
		String id_final = request.getParameter("id_final");
		AlumnoService alumnoService = new AlumnoService();
		Alumno alumno = new Alumno();
		alumno = alumnoService.getAlumno(Integer.parseInt(id_alumno));
		FinalesService finalesService = new FinalesService();
		Final f = new Final();
		f.setId(Integer.parseInt(id_final));
		finalesService.borrarFinal(f);
		
		
		ArrayList<Final> finales = finalesService.getFinalesByAlumno(alumno);
		request.setAttribute("alumno", alumno);
		request.setAttribute("finales2", finales);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/Finales.jsp").forward(request, response);
	}

}
