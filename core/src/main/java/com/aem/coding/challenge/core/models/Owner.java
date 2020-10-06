package com.aem.coding.challenge.core.models;

import java.util.List;

public class Owner {

	private String name;
	private String gender;
	private int age;
	private List<Pet> pets;

	public Owner(String name, String gender, int age, List<Pet> pets) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.pets = pets;
	}
	
	public Owner() {

	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

}
