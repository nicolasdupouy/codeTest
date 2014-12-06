package com.ndu.dao;

import java.util.List;

import com.ndu.model.Utilisateur;

public interface UtilisateurDao {
	void ajouter(Utilisateur utilisateur) throws DaoException;

	List<Utilisateur> lister() throws DaoException;
}
