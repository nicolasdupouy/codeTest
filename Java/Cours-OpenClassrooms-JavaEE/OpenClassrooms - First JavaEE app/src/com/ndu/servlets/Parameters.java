package com.ndu.servlets;

public final class Parameters {

	private Parameters() {
	}

	public static final String PARAMETER_CONNECTIONFORM = "ConnectionForm";
	public static final String CHEMIN_FICHIERS = "/Users/nicolasdupouy/Downloads/";
	public static final String PARAMETER_FIRST_NAME = "firstName";
	public static final String PARAMETER_LAST_NAME = "lastName";
	public static final String PARAMETER_USERS = "utilisateurs";
	public static final String PARAMETER_ERROR = "error";

	public static final String ERROR_MESSAGE_USER_LASTNAME_TOO_LONG = "Name is too long (10 caracters maximum)";
	public static final String ERROR_MESSAGE_DATABASE_NOT_ACCESSIBLE = "Database inaccessible";
	public static final String ERROR_MESSAGE_DATABASE_DATA_PROBLEMS = "Database problem with the parameters";
}
