package com.braceletService.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Pendant {
	
	private String model;
	private String color;
	private ArrayList<Price> price = new ArrayList<Price>();
	
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

	@XmlElement(name="premium", type=Price.class)
	public ArrayList<Price> getPremium() {
		return price;
	}

	public void setPremium(ArrayList<Price> price) {
		this.price = price;
	}

}
