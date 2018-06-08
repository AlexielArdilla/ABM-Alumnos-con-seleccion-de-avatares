package ar.com.unpaz.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ar.com.unpaz.app.modelo.Final;
import ar.com.unpaz.app.servicios.FinalesService;

/**
 * Servlet implementation class Finales
 */
@WebServlet("/Finales")
public class Finales extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		FinalesService finalesService = new FinalesService();		
		ArrayList<Final> finales = finalesService.getFinales();
		request.setAttribute("finales2", finales);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/Finales.jsp").forward(request, response);
	}

}
