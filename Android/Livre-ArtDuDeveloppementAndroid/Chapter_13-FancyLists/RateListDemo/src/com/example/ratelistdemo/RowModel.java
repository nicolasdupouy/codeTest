package com.example.ratelistdemo;

public class RowModel {
	String label;
	float rating = 2.0f;
	
	public RowModel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		if (rating >= 3.0) {
			return label.toUpperCase();
		}
		return label;
	}
	
	
}
