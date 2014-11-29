package com.ndu.forms;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {

	private static final String PARAMETER_LOGIN = "login";
	private static final String PARAMETER_PASSWORD = "password";

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void verifyLogin(HttpServletRequest request) {
		String login = request.getParameter(PARAMETER_LOGIN);
		String password = request.getParameter(PARAMETER_PASSWORD);

		if (password.equals(login + "123")) {
			result = "Vous êtes bien connecté !";
		}
		else {
			result = "Identifiant incorrect !";
		}
	}
}
