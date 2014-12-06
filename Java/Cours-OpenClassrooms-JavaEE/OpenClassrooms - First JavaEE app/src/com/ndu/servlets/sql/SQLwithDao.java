package com.ndu.servlets.sql;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndu.dao.DaoException;
import com.ndu.dao.DaoFactory;
import com.ndu.dao.UtilisateurDao;
import com.ndu.model.BeanException;
import com.ndu.model.Utilisateur;
import com.ndu.servlets.Parameters;

/**
 * Servlet implementation class SQLwithDao
 */
@WebServlet("/SQLWithDao")
public class SQLwithDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao;

	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.utilisateurDao = daoFactory.getUtilisateurDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute(Parameters.PARAMETER_USERS, utilisateurDao.lister());
		} catch (DaoException e) {
			request.setAttribute(Parameters.PARAMETER_ERROR, e.getMessage());
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/sql/sQLWithDAO.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		try {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setFirstName(request.getParameter(Parameters.PARAMETER_FIRST_NAME));
			utilisateur.setLastName(request.getParameter(Parameters.PARAMETER_LAST_NAME));
			utilisateurDao.ajouter(utilisateur);
			request.setAttribute("utilisateurs", utilisateurDao.lister());
		} catch (BeanException e) {
			request.setAttribute(Parameters.PARAMETER_ERROR, e.getMessage());
		} catch (DaoException e) {
			request.setAttribute(Parameters.PARAMETER_ERROR, e.getMessage());
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/sql/sQLWithDAO.jsp").forward(request, response);

	}
}
