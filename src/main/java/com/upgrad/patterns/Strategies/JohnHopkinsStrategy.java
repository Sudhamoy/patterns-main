package com.upgrad.patterns.Strategies;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upgrad.patterns.Config.RestServiceGenerator;
import com.upgrad.patterns.Entity.JohnHopkinResponse;
import com.upgrad.patterns.Interfaces.IndianDiseaseStat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JohnHopkinsStrategy implements IndianDiseaseStat {

	private Logger logger = LoggerFactory.getLogger(JohnHopkinsStrategy.class);

	private RestTemplate restTemplate;

	@Value("${config.john-hopkins-url}")
	private String baseUrl;

	public JohnHopkinsStrategy() {
		restTemplate = RestServiceGenerator.GetInstance();
	}

	@Override
	public String GetActiveCount() {
		//try block
			//get response from the getJohnHopkinResponses method
			//filter the data based such that country equals India (use getCountry() to get the country value)
			//Map the data to "confirmed" value (use getStats() and getConfirmed() to get stats value and confirmed value)
			//Reduce the data to get a sum of all the "confirmed" values
			//return the response after rounding it up to 0 decimal places
		//catch block
			//log the error
			//return null

		try {
			JohnHopkinResponse[] responses = getJohnHopkinResponses();
			if (responses != null && responses.length > 0) {
				int sumConfirmed = Arrays.stream(responses)
						.filter(response -> "India".equals(response.getCountry()))
						.mapToInt(response -> Math.round(response.getStats().getConfirmed()))
						.sum();
				return String.valueOf(sumConfirmed); // Return sum as String
			}
		} catch (Exception e) {
			logger.error("Error fetching disease count from John Hopkins source: " + e.getMessage());
		}
		return null;
	}

	private JohnHopkinResponse[] getJohnHopkinResponses() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ClassPathResource resource = new ClassPathResource("JohnHopkins.json");
		return new JohnHopkinResponse[]{objectMapper.readValue(resource.getFile(), JohnHopkinResponse.class)};
	}
}
