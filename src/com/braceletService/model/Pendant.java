package com.braceletService.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Pendant {
	
	private String model;
	private String color;
	
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

}
