package com.protalento.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.protalento.entidades.Usuario;
import com.protalento.main.Alertas;
import com.protalento.jdbc.implementaciones.UsuarioImp;

/**
 * Servlet implementation class ValidarSesion
 */
@WebServlet("/ValSesion")
public class ValidarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioImp usuarioImp;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidarSesion() {
		super();
		usuarioImp = new UsuarioImp();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		String pagina = "login.jsp";

		HttpSession sesion = null;
		RequestDispatcher requestDispatcher;

		Usuario usuario = usuarioImp.buscarPorCorreoClave(correo, clave);

		if (usuario != null) {
			if (!usuario.getClave().equals(clave)) {
				// alerta Credenciales incorrectas
				pagina = "validacionIncorrecta.jsp";
				request.setAttribute("alerta", Alertas.CREDENCIALES_INCORRECTAS);
				// logger.warn(usuario + " " + Alertas.CREDENCIALES_INCORRECTAS);

			} else {
				sesion = request.getSession();
				sesion.setAttribute("usuario", usuario);
				pagina = "validacionCorrecta.jsp";
			}
		} else {
			// alerta Credenciales incorrectas
			pagina = "validacionIncorrecta.jsp";
			request.setAttribute("alerta", Alertas.CREDENCIALES_INCORRECTAS);
			// logger.warn(correo + " " + Alertas.CREDENCIALES_INCORRECTAS);
		}
		requestDispatcher = request.getRequestDispatcher(pagina);
		requestDispatcher.forward(request, response);
	}

}
