package com.braceletService.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Price {
	
	private String unit;
	private float value;
	
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

	@XmlValue
	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}
