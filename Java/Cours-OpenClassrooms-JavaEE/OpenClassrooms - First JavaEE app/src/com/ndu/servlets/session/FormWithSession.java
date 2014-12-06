package com.ndu.servlets.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ndu.servlets.Parameters;

/**
 * Servlet implementation class FormWithSession
 */
@WebServlet("/FormWithSession")
public class FormWithSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormWithSession() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		String firstName = (String) httpSession.getAttribute(Parameters.PARAMETER_FIRST_NAME);

		// Close the session (with a disconnect button for example)
		httpSession.invalidate();

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/session/formWithSession.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String firstName = request.getParameter(Parameters.PARAMETER_FIRST_NAME);
		String lastName = request.getParameter(Parameters.PARAMETER_LAST_NAME);

		HttpSession httpSession = request.getSession();
		httpSession.setAttribute(Parameters.PARAMETER_FIRST_NAME, firstName);
		httpSession.setAttribute(Parameters.PARAMETER_LAST_NAME, lastName);

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/session/formWithSession.jsp")
				.forward(request, response);
	}
}