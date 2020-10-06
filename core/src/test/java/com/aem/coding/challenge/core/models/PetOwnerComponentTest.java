package com.aem.coding.challenge.core.models;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import com.aem.coding.challenge.core.service.PetOwnerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class PetOwnerComponentTest {

	@InjectMocks
	private PetOwnerComponent petOwnerComponent;

	@Mock
	private PetOwnerService service;

	@Before
	public void setUp() throws JsonProcessingException, Exception {
		when(service.getPetOwnerDetails()).thenReturn(getResult());
	}

	private List<Owner> getResult() throws Exception, JsonProcessingException {
		String jsonResult = "[{\"name\":\"Bob\",\"gender\":\"Male\",\"age\":23,\"pets\":[{\"name\":\"Garfield\",\"type\":\"Cat\"},{\"name\":\"Fido\",\"type\":\"Dog\"}]},{\"name\":\"Jennifer\",\"gender\":\"Female\",\"age\":18,\"pets\":[{\"name\":\"Garfield\",\"type\":\"Cat\"}]},{\"name\":\"Steve\",\"gender\":\"Male\",\"age\":45,\"pets\":null},{\"name\":\"Fred\",\"gender\":\"Male\",\"age\":40,\"pets\":[{\"name\":\"Tom\",\"type\":\"Cat\"},{\"name\":\"Max\",\"type\":\"Cat\"},{\"name\":\"Sam\",\"type\":\"Dog\"},{\"name\":\"Jim\",\"type\":\"Cat\"}]},{\"name\":\"Samantha\",\"gender\":\"Female\",\"age\":40,\"pets\":[{\"name\":\"Tabby\",\"type\":\"Cat\"}]},{\"name\":\"Alice\",\"gender\":\"Female\",\"age\":64,\"pets\":[{\"name\":\"Simba\",\"type\":\"Cat\"},{\"name\":\"Nemo\",\"type\":\"Fish\"}]}]";
		ObjectMapper mapper = new ObjectMapper();
		List<Owner> owners = mapper.readValue(jsonResult, new TypeReference<List<Owner>>() {
		});
		return owners;
	}

	@Test
	public void test_init_callWebService_filteredAndSortedListOfCats() {
		petOwnerComponent.init();
		assertEquals(petOwnerComponent.getResult().getFemaleOwnedPets().size(), 3);
		assertEquals(petOwnerComponent.getResult().getMaleOwnedPets().size(), 4);
		assertEquals(petOwnerComponent.getResult().getFemaleOwnedPets().get(0), "Garfield");
		assertEquals(petOwnerComponent.getResult().getFemaleOwnedPets().get(1), "Simba");
		assertEquals(petOwnerComponent.getResult().getFemaleOwnedPets().get(2), "Tabby");

		assertEquals(petOwnerComponent.getResult().getMaleOwnedPets().get(0), "Garfield");
		assertEquals(petOwnerComponent.getResult().getMaleOwnedPets().get(1), "Jim");
		assertEquals(petOwnerComponent.getResult().getMaleOwnedPets().get(2), "Max");
		assertEquals(petOwnerComponent.getResult().getMaleOwnedPets().get(3), "Tom");

	}
}
