package com.ndu.servlets.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndu.servlets.Parameters;

/**
 * Servlet implementation class FormWithCookie
 */
@WebServlet("/FormWithCookie")
public class FormWithCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormWithCookie() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(Parameters.PARAMETER_FIRST_NAME)) {
				request.setAttribute(Parameters.PARAMETER_FIRST_NAME, cookie.getValue());
			}
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/session/formWithCookie.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String firstName = request.getParameter(Parameters.PARAMETER_FIRST_NAME);
		String lastName = request.getParameter(Parameters.PARAMETER_LAST_NAME);

		Cookie cookie = new Cookie(Parameters.PARAMETER_FIRST_NAME, firstName);
		cookie.setMaxAge(60); // 60 s
		response.addCookie(cookie);

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/session/formWithCookie.jsp")
				.forward(request, response);
	}

}
