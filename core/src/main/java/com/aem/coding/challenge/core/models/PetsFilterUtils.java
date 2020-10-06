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

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * this utility class filter result from service call by owner gender and type
 * of pet
 */

public class PetsFilterUtils {

	public static List<String> filter(List<Owner> ownerDetails, String gender, String petType) {
		List<Owner> ownersByGender = filterByOwnerGender(ownerDetails, gender);

		List<String> petNames = filterByPetType(petType, ownersByGender);
		return petNames;
	}

	private static List<String> filterByPetType(String petType, List<Owner> ownersByGender) {
		List<String> petNames = ownersByGender.stream().flatMap(owner -> owner.getPets().stream())
				.filter(pet -> pet.getType().equalsIgnoreCase(petType)).map(pet -> pet.getName())
				.collect(Collectors.toList());
		Collections.sort(petNames);
		return petNames;
	}

	private static List<Owner> filterByOwnerGender(List<Owner> ownerDetails, String gender) {
		List<Owner> ownersByGender = ownerDetails.stream()
				.filter(owner -> owner.getGender().equalsIgnoreCase(gender) && owner.getPets()!=null)
				.collect(Collectors.toList());	
		return ownersByGender;
	}
}