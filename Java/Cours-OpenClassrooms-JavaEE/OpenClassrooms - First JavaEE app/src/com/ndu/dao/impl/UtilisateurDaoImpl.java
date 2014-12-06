package com.ndu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ndu.dao.DaoException;
import com.ndu.dao.DaoFactory;
import com.ndu.dao.UtilisateurDao;
import com.ndu.model.BeanException;
import com.ndu.model.Utilisateur;
import com.ndu.servlets.Parameters;

public class UtilisateurDaoImpl implements UtilisateurDao {

	private DaoFactory daoFactory;

	public UtilisateurDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Utilisateur utilisateur) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO noms(nom, prenom) VALUES(?, ?);");
			preparedStatement.setString(1, utilisateur.getLastName());
			preparedStatement.setString(2, utilisateur.getFirstName());

			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e1) {
			e1.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e2) {
					throw new DaoException(Parameters.ERROR_MESSAGE_DATABASE_NOT_ACCESSIBLE);
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new DaoException(Parameters.ERROR_MESSAGE_DATABASE_NOT_ACCESSIBLE);
				}
			}
		}
	}

	@Override
	public List<Utilisateur> lister() throws DaoException {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			resultat = statement.executeQuery("SELECT nom, prenom FROM noms;");

			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");

				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setLastName(nom);
				utilisateur.setFirstName(prenom);

				utilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BeanException e) {
			throw new DaoException(Parameters.ERROR_MESSAGE_DATABASE_DATA_PROBLEMS);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new DaoException(Parameters.ERROR_MESSAGE_DATABASE_NOT_ACCESSIBLE);
				}
			}
		}
		return utilisateurs;
	}
}
