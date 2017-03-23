package com.braceletService.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Premium {
	
	private String unit;
	
	public Premium(){
		
	}
	
	public Premium(String unit){
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
