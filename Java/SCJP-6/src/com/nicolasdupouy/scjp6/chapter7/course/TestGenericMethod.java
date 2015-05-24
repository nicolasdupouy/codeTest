package com.nicolasdupouy.scjp6.chapter7.course;

import java.util.ArrayList;
import java.util.List;

public class TestGenericMethod {
	public <T> void makeArrayList(T t) { 
		// take an object of an unknown type and use a "T" to represent the type
		List<T> list = new ArrayList<T>(); 
		// now we can create the list using "T"
		list.add(t);
	}
	
	public <T> List<T> makeAndReturnArrayList(T t) {
		List<T> list = new ArrayList<T>();
		list.add(t);
		return list;
	}
}
