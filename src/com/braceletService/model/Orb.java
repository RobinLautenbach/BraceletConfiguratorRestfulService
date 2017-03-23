package com.braceletService.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Orb {
	
	private String size;
	private String style;
	
	public Orb(){
		
	}
	
	public Orb(String size, String style){
		this.size = size;
		this.style = style;
	}

	@XmlAttribute(name="size")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@XmlAttribute(name="style")
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
