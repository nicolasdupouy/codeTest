package com.nicolasdupouy.utilities.args.marshaler;

import java.util.Iterator;

import com.nicolasdupouy.utilities.args.exception.ArgsException;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {

	private boolean booleanValue = false;

	@Override
	public void set(Iterator<String> currentArgument) throws ArgsException {
		booleanValue = true;
	}

	public static boolean getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof BooleanArgumentMarshaler) {
			return ((BooleanArgumentMarshaler) am).booleanValue;
		}
		else {
			return false;
		}
	}
}
