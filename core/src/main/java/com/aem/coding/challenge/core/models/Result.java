package com.aem.coding.challenge.core.models;

import java.util.List;

public class Result {

	private List<String> femaleOwnedPets;
	private List<String> maleOwnedPets;
	
	public Result(List<String> femaleOwnedPets, List<String> maleOwnedPets) {
		super();
		this.femaleOwnedPets = femaleOwnedPets;
		this.maleOwnedPets = maleOwnedPets;
	}
	public List<String> getFemaleOwnedPets() {
		return femaleOwnedPets;
	}
	public void setFemaleOwnedPets(List<String> femaleOwnedPets) {
		this.femaleOwnedPets = femaleOwnedPets;
	}
	public List<String> getMaleOwnedPets() {
		return maleOwnedPets;
	}
	public void setMaleOwnedPets(List<String> maleOwnedPets) {
		this.maleOwnedPets = maleOwnedPets;
	}

}
