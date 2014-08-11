package com.nicolasdupouy.utilities.args;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import com.nicolasdupouy.utilities.args.exception.ArgsException;
import com.nicolasdupouy.utilities.args.marshaler.ArgumentMarshaler;

public class Args {
	private Map<Character, ArgumentMarshaler> marshalers;
	private Set<Character> argsFound;
	private ListIterator<String> currentArgument;

	public Args(String schema, String[] args) throws ArgsException {
		marshalers = new HashMap<Character, ArgumentMarshaler>();
		argsFound = new HashSet<Character>();
	}

	private void parseSchema(String schema) throws ArgsException {
		for (String element : schema.split(Constants.SCHEMA_SEPARATOR)) {
			if (element.length() > 0) {
				parseSchemaElement(element);
			}
		}
	}

	private void parseSchemaElement(String element) throws ArgsException {
		char elementId = element.charAt(0);
		String elementTail = element.substring(1);
		validateSchemaElementId(elementId);

		if (elementTail.length() == 0) {

		}
	}

	private void validateSchemaElementId(char elementId) {

	}

	private void parseArgumentStrings(List<String> argsList) {

	}
}
