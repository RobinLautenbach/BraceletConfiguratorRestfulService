package com.braceletService.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Price {
	
	private String unit;
	
	public Price(){
		
	}
	
	public Price(String unit){
		this.unit = unit;
	}

	@XmlAttribute(name="unit")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
