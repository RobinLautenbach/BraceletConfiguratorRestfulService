package com.braceletService.model;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"price","orbs","pendant"})
public class Bracelet {

	private long id;
	private String name;
	private String size;
	private String model;
	private Date created;
	private ArrayList<Price> price = new ArrayList<Price>();
	private ArrayList<Orb> orbs = new ArrayList<Orb>();
	private Pendant pendant;
	
	public Bracelet(){
		this.created = new Date();
	}
	
	public Bracelet(long id, String name, String size, String model){
		this.id = id;
		this.name = name;
		this.size = size;
		this.model = model;
	}

	@XmlAttribute(name="id")
	public long getId() {
		return id;
	}
	
	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlAttribute(name="size")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@XmlAttribute(name="model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@XmlAttribute(name="created")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@XmlElement(name="orb")
	@XmlElementWrapper(name="orbs")
	public ArrayList<Orb> getOrbs() {
		return orbs;
	}

	public void setOrbs(ArrayList<Orb> orbs) {
		this.orbs = orbs;
	}

	@XmlElement(name="pendant")
	public Pendant getPendant() {
		return pendant;
	}

	public void setPendant(Pendant pendant) {
		this.pendant = pendant;
	}

	@XmlElement(name="price")
	public ArrayList<Price> getPrice() {
		return price;
	}

	public void setPrice(ArrayList<Price> price) {
		this.price = price;
	}
}
