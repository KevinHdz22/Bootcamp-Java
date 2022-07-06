package com.protalento.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.protalento.entidades.Consulta;

/**
 * Servlet implementation class Validacion
 */

@WebServlet("/validacion")
public class Validacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validacion() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String texto = request.getParameter("texto");
//		String url = request.getParameter("url");
//		LocalDate fecha = LocalDate.now();
//		
//		Consulta consulta = new Consulta(texto, url, fecha);
//		System.out.println(consulta);
//		
//		request.setAttribute("consultaX", consulta);
//		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("bienvenido.jsp");
//		
//		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String texto = request.getParameter("texto");
		String url = request.getParameter("url");
		LocalDate fecha = LocalDate.now();
		
		Consulta consulta = new Consulta(texto, url, fecha);
		
		request.setAttribute("consultaX", consulta);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("realizarConsulta.jsp");
		
		requestDispatcher.forward(request, response);
	}

}
