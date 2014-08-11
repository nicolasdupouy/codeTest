package com.nicolasdupouy.utilities.args.marshaler;

import java.util.Iterator;

import com.nicolasdupouy.utilities.args.exception.ArgsException;

public interface ArgumentMarshaler {
	void set(Iterator<String> currentArgument) throws ArgsException;
}
