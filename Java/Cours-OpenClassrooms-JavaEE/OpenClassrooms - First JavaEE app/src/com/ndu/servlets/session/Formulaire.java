package com.ndu.servlets.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndu.forms.ConnectionForm;
import com.ndu.servlets.Parameters;

/**
 * Servlet implementation class Formulaire
 */
@WebServlet("/Formulaire")
public class Formulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Formulaire() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/session/formulaire.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		ConnectionForm connectionForm = new ConnectionForm();
		connectionForm.verifyLogin(request);

		request.setAttribute(Parameters.PARAMETER_CONNECTIONFORM, connectionForm);

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/session/formulaire.jsp").forward(request, response);
	}

}
