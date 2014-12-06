package com.ndu.servlets.sql;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndu.model.Utilisateur;
import com.ndu.servlets.Parameters;

/**
 * Servlet implementation class SQLWithJDBC
 */
@WebServlet("/SQLWithJDBC")
public class SQLWithJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SQLWithJDBC() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NomsForJDBC tableNoms = new NomsForJDBC();
		request.setAttribute(Parameters.PARAMETER_USERS, tableNoms.recupererUtilisateur());
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/sql/sQLWithJDBC.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		NomsForJDBC tableNoms = new NomsForJDBC();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setFirstName(request.getParameter(Parameters.PARAMETER_FIRST_NAME));
		utilisateur.setLastNameClassic(request.getParameter(Parameters.PARAMETER_LAST_NAME));
		tableNoms.ajouterUtilisateur(utilisateur);

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/sql/sQLWithJDBC.jsp").forward(request, response);
	}

}
