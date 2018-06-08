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
 * Servlet implementation class ObservacionesByAlumno
 */
@WebServlet("/ObservacionesByAlumno")
public class ObservacionesByAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObservacionesByAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AlumnoService alumnoService = new AlumnoService();
		request.setAttribute("alumnos", alumnoService.getAlumnos());
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/ObservacionesAlumno.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_alumno = Integer.parseInt(request.getParameter("id_alumno"));
		AlumnoService alumnoService = new AlumnoService();
		Alumno alumno = alumnoService.getAlumno(id_alumno);
		ObservacionService miObService = new ObservacionService();
		ObservacionAlumno miObservacion = new ObservacionAlumno();
		miObservacion = miObService.getObservacionByAlumno(alumno);
		
		request.setAttribute("obs_id", miObservacion.getObs_id());
		request.setAttribute("descripcion", miObservacion.getDescripcion());
		request.setAttribute("alu_id", miObservacion.getAlu_id());
		request.setAttribute("objetivo", miObservacion.getObjetivo());
		request.setAttribute("observaciones", miObservacion.getObservaciones());
		request.setAttribute("nombre", alumno.getApel_nombre());
		request.setAttribute("alu_id", alumno.getId_alumno());
		String avatar = "images/avatar"+miObservacion.getAvatar_id()+".jpg";
		request.setAttribute("avatar", avatar);
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/ObservacionConcreta.jsp").forward(request, response);
		
		
	}

}
