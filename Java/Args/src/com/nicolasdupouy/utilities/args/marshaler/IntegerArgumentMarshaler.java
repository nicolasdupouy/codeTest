package com.nicolasdupouy.utilities.args.marshaler;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.nicolasdupouy.utilities.args.exception.ArgsException;
import com.nicolasdupouy.utilities.args.exception.ErrorCode;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {

	private int intValue = 0;

	@Override
	public void set(Iterator<String> currentArgument) throws ArgsException {
		String parameter = null;
		try {
			parameter = currentArgument.next();
			intValue = Integer.parseInt(parameter);
		} catch (NoSuchElementException e) {
			throw new ArgsException(ErrorCode.MISSING_INTEGER);
		} catch (NumberFormatException e) {
			throw new ArgsException(ErrorCode.INVALID_INTEGER, parameter);
		}
	}

	public static int getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof BooleanArgumentMarshaler) {
			return ((IntegerArgumentMarshaler) am).intValue;
		}
		else {
			return 0;
		}
	}
}
