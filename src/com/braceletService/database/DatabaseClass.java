package com.braceletService.database;

import java.util.HashMap;
import java.util.Map;

import com.braceletService.model.Bracelet;

public class DatabaseClass {
	
	private static Map<Long, Bracelet> bracelets = new HashMap<>();

	public static Map<Long, Bracelet> getBracelets(){
		return bracelets;
	}
}
