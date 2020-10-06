/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.aem.coding.challenge.core.models;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import com.aem.coding.challenge.core.service.PetOwnerService;

@Model(adaptables = Resource.class)
public class PetOwnerComponent {
	
	@Inject @Optional
	public String petType;

	@Inject
	private PetOwnerService petOwnerService;
	
	private Result result;

	
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}


	@PostConstruct
	public void init() {
		String type = isPetTypeEmpty(petType)? "cat" : petType;
		List<Owner> ownerDetails = petOwnerService.getPetOwnerDetails();
		List<String> femaleOwnedPets = PetsFilterUtils.filter(ownerDetails, "female", type);
		List<String> maleOwnedPets = PetsFilterUtils.filter(ownerDetails, "male", type);
		result = new Result(femaleOwnedPets, maleOwnedPets);
	}
	
	boolean isPetTypeEmpty(String petType) {
	    return petType == null || petType.isEmpty();
	}

}