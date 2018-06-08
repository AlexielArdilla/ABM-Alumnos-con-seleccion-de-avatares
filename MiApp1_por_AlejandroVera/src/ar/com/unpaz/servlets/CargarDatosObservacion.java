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
 * Servlet implementation class CargarDatosObservacion
 */
@WebServlet("/CargarDatosObservacion")
public class CargarDatosObservacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarDatosObservacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id_alumno = request.getParameter("alu_id");
		request.getSession(true).setAttribute("alu_id", id_alumno);
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/CargarDatosObservacion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		ObservacionAlumno miObservacionAlumno = new ObservacionAlumno();
		ObservacionService miObservacionService = new ObservacionService();
		int avatar_num = Integer.parseInt(request.getParameter("avatar"));
		String descripcion = request.getParameter("desc");
		String objetivo = request.getParameter("obj");
		String observaciones = request.getParameter("obs");
		
		int id_alu = Integer.parseInt(request.getParameter("id_alu"));
		miObservacionAlumno.setAlu_id(id_alu);
		miObservacionAlumno.setObs_id(id_alu);
		miObservacionAlumno.setAvatar_id(avatar_num);
		miObservacionAlumno.setDescripcion(descripcion);
		miObservacionAlumno.setObjetivo(objetivo);
		miObservacionAlumno.setObservaciones(observaciones);
		
		miObservacionService.updateObservacion(miObservacionAlumno);//hace el update y tiene que recargar la pagina CargarDatosDeObservacionjsp
		AlumnoService miAlService = new AlumnoService();
		Alumno miAlumno = miAlService.getAlumno(id_alu);
		
		request.setAttribute("obs_id", miObservacionAlumno.getObs_id());
		request.setAttribute("descripcion", miObservacionAlumno.getDescripcion());
		request.setAttribute("alu_id", miObservacionAlumno.getAlu_id());
		request.setAttribute("objetivo", miObservacionAlumno.getObjetivo());
		request.setAttribute("observaciones", miObservacionAlumno.getObservaciones());
		request.setAttribute("nombre", miAlumno.getApel_nombre());
		request.setAttribute("alu_id", miAlumno.getId_alumno());
		String avatar = "images/avatar"+miObservacionAlumno.getAvatar_id()+".jpg";
		request.setAttribute("avatar", avatar);
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/ObservacionConcreta.jsp").forward(request, response);
	}

}
