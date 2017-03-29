package com.braceletService.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.braceletService.database.DatabaseClass;
import com.braceletService.exception.DataNotFoundException;
import com.braceletService.model.Bracelet;

public class BraceletService {
	
	private Map<Long, Bracelet> bracelets = DatabaseClass.getBracelets();
	
	public List<Bracelet> getAllBracelets(){
		return new ArrayList<Bracelet>(bracelets.values());
	}
	
	public int getDBSize(){
		return bracelets.size();
	}
	
    public List<Bracelet> getAllBraceletsPaginated(int start, int size){
        ArrayList<Bracelet> list = new ArrayList<Bracelet>(bracelets.values());
        if(start + size > list.size()){
        	if(start < list.size()){
        		return list.subList(start, list.size());
        	}
        } 
        return list.subList(start, start + size);
    }
    
	public Bracelet getBracelet(long id){
		Bracelet bracelet = bracelets.get(id);
		if(bracelet == null){
			throw new DataNotFoundException("Bracelet with id " + id + " not found");
		}
		return bracelet;
	}
	
	public Bracelet addBracelet(Bracelet bracelet){
		bracelet.setId(bracelets.keySet().size() > 0 ? Collections.max(bracelets.keySet()) + 1 : 1);
		bracelets.put(bracelet.getId(), bracelet);
		return bracelet;
	}
	
	public Bracelet updateBracelet(Bracelet bracelet){
		if(bracelet.getId() <= 0){
			return null;
		}
		bracelets.put(bracelet.getId(), bracelet);
		return bracelet;
	}
	
	public Bracelet removeBracelet(long id){
		Bracelet bracelet = bracelets.get(id);
		if(bracelet == null){
			throw new DataNotFoundException("Bracelet with id " + id + " not found");
		}
		return bracelets.remove(id);
	}

}
