package com.aem.coding.challenge.core.service;

import org.osgi.framework.Constants;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.coding.challenge.core.models.Owner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(name = "PetOwnerDetails", service = PetOwnerService.class, immediate = true, property = {
		Constants.SERVICE_DESCRIPTION + "=call external service and consume json" })
public class PetOwnerService {
	private static final  Logger logger = LoggerFactory.getLogger(PetOwnerService.class);

	public List<Owner> getPetOwnerDetails() {
		DefaultHttpClient httpClient = new DefaultHttpClient();

		HttpGet request = new HttpGet("http://agl-developer-test.azurewebsites.net/people.json");
		request.addHeader("accept", "application/json");
		HttpResponse response;
		try {
			response = httpClient.execute(request);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException(
						"Call to service failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			logger.info("Call to web service success");
			String result = EntityUtils.toString(response.getEntity());
			return parseResult(result);

		} catch (ClientProtocolException e) {
			logger.info("service call failed");
			e.printStackTrace();
		} catch (IOException e) {
			logger.info("service call failed");
			e.printStackTrace();
		}
		return null;
	}

	private List<Owner> parseResult(String result) {
		List<Owner> owners = null;
		try {
			ObjectMapper mapper = new ObjectMapper();

			owners = mapper.readValue(result, new TypeReference<List<Owner>>() {
			});
		} catch (JsonProcessingException e) {
			logger.info("exception while parsing" + e.getMessage());
			e.printStackTrace();
		}
		return owners;
	}
}
