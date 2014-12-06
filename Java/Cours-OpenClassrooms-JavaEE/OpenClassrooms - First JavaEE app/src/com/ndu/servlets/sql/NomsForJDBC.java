package com.ndu.servlets.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ndu.model.Utilisateur;

public class NomsForJDBC {
	private Connection connection;

	private void loadDatabase() {
		// Chargement du driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OpenClassrooms_JavaEE", "root",
					"");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Utilisateur> recupererUtilisateur() {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Statement statement = null;
		ResultSet resultSet = null;

		loadDatabase();

		try {
			statement = connection.createStatement();

			// Exécution de la requête
			resultSet = statement.executeQuery("SELECT nom, prenom FROM noms;");

			// Récupération des données
			while (resultSet.next()) {
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");

				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setLastNameClassic(nom);
				utilisateur.setFirstName(prenom);

				utilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
		} finally {
			// Fermeture de la connexion
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException ignore) {
			}
		}
		return utilisateurs;
	}

	public void ajouterUtilisateur(Utilisateur utilisateur) {
		loadDatabase();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO noms(nom, prenom) VALUES(?, ?);");
			preparedStatement.setString(1, utilisateur.getLastName());
			preparedStatement.setString(2, utilisateur.getFirstName());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
