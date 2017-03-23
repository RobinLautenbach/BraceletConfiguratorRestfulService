package com.braceletService.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Orb {
	
	private String size;
	private String style;
	private int position;
	private ArrayList<Premium> premium = new ArrayList<Premium>();
	
	public Orb(){
		
	}
	
	public Orb(String size, String style, int position){
		this.size = size;
		this.style = style;
		this.setPosition(position);
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
	
	@XmlAttribute(name="position")
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@XmlElement(name="premium")
	public ArrayList<Premium> getPremium() {
		return premium;
	}

	public void setPremium(ArrayList<Premium> premium) {
		this.premium = premium;
	}

}
