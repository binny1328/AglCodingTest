package com.aem.coding.challenge.core.models;


public class Pet {
	private String name;
	private String type;

	public Pet(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	public Pet() {

	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
