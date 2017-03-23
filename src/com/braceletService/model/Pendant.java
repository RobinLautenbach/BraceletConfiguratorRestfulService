package com.braceletService.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Pendant {
	
	private String model;
	private String color;
	private ArrayList<Premium> premium = new ArrayList<Premium>();
	
	public Pendant(){
		
	}
	
	public Pendant(String model, String color){
		this.model = model;
		this.color = color;
	}

	@XmlAttribute(name="model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@XmlAttribute(name="color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@XmlElement(name="premium")
	public ArrayList<Premium> getPremium() {
		return premium;
	}

	public void setPremium(ArrayList<Premium> premium) {
		this.premium = premium;
	}

}
