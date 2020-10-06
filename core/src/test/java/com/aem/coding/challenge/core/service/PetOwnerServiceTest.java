package com.aem.coding.challenge.core.service;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import com.aem.coding.challenge.core.models.Owner;

public class PetOwnerServiceTest {

	private PetOwnerService petOwnerService;

	@Mock
	private Logger logger;

	@Before
	public void setup() throws Exception {

		petOwnerService = new PetOwnerService();
	}

	@Test
	public void test_getPetOwnerDetails() throws Exception {
		List<Owner> owners = petOwnerService.getPetOwnerDetails();
		assertEquals(owners.size(), 6);
		assertEquals(owners.get(0).getName(),"Bob");
		assertEquals(owners.get(0).getPets().size(),2);
		assertEquals(owners.get(1).getName(),"Jennifer");
		assertEquals(owners.get(1).getPets().size(),1);
		assertEquals(owners.get(2).getName(),"Steve");
		assertEquals(owners.get(1).getPets().size(),1);

	}
}
