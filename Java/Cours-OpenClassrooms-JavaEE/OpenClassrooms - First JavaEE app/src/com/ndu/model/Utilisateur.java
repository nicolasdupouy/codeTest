package com.ndu.model;

import com.ndu.servlets.Parameters;

public class Utilisateur {

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastNameClassic(String lastName) {
		this.lastName = lastName;
	}

	public void setLastName(String lastName) throws BeanException {
		if (lastName.length() > 10) {
			throw new BeanException(Parameters.ERROR_MESSAGE_USER_LASTNAME_TOO_LONG);
		}
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Utilisateur [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
