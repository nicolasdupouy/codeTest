package com.ndu.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndu.beans.Auteur;

/**
 * Servlet implementation class TestServler
 */
@WebServlet("/Bonjour")
public class Bonjour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PARAMETER_NAME = "name";
	private static final String PARAMETER_NAMES = "names";
	private static final String PARAMETER_AUTEUR = "auteur";
	private static final String PARAMETER_TITRES = "titres";

	public Bonjour() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String name = request.getParameter(PARAMETER_NAME);
		request.setAttribute(PARAMETER_NAME, name);
		String[] names = { "nicolas", "Hanounti", "Alain", "Joëlle" };
		request.setAttribute(PARAMETER_NAMES, names);*/

		Auteur auteur = new Auteur();
		auteur.setFirstName("nicolas");
		auteur.setLastName("Dupouy");
		auteur.setActif(true);
		request.setAttribute(PARAMETER_AUTEUR, auteur);

		String[] titres = { "Premier titre", "Second titre", "Troisième titre" };
		request.setAttribute(PARAMETER_TITRES, titres);

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/bonjour.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

	}

}
