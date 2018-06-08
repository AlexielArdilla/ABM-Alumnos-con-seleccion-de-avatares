package ar.com.unpaz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inicio
 */
@WebServlet({ "/Inicio", "/inicio" })
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user;
		String pass;
		String tipo;
		
		user = request.getParameter("usuario");
		pass = request.getParameter("pass");
		tipo = request.getParameter("tipo");
		

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		
		out.print("<title>Inicio</title>");
		
		out.println("</head>");

		out.println("<body>");
		out.println("<h1>Servlet Inicio</h1>");
		out.println("<p>Usuario: " + user + " Password: " + pass + " Tipo: " + tipo +  "</p>");
		
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<td>USUARIO</td><td>PASSORD</td><td>tipo</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + user + "</td><td>" + pass + "</td><td>" + tipo + "</td>");
		out.println("</tr>");
		out.println("</table>");
		
		out.println("<a href=./index.html>Ir a la página de Inicio</a>");
		
		out.println("</body>");
		out.println("</htm>");
		
	}

}
 