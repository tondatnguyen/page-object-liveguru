package com.bankguru.customer;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetCustomerDataJson {

public static GetCustomerDataJson getCustomerData(String filename) throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper mapper = new ObjectMapper();
	return mapper.readValue(new File(filename), GetCustomerDataJson.class);
}
	
	@JsonProperty("customerNameValue")
	String customerNameValue;
	
	@JsonProperty("genderMaleValue")
	String genderMaleValue;

	@JsonProperty("dateOFBirthValue")
	String dateOFBirthValue;
	
	@JsonProperty("addressValue")
	String addressValue;
	
	@JsonProperty("cityValue")
	String cityValue;
	
	@JsonProperty("stateValue")
	String stateValue;
	
	@JsonProperty("pinValue")
	String pinValue;
	
	@JsonProperty("phoneValue")
	String phoneValue;
	
	@JsonProperty("emailValue")
	String emailValue;
	
	@JsonProperty("passwordValue")
	String passwordValue;

	public String getCustomerNameValue() {
		return customerNameValue;
	}

	public String getGenderMaleValue() {
		return genderMaleValue;
	}

	public String getDateOFBirthValue() {
		return dateOFBirthValue;
	}

	public String getAddressValue() {
		return addressValue;
	}

	public String getCityValue() {
		return cityValue;
	}

	public String getStateValue() {
		return stateValue;
	}

	public String getPinValue() {
		return pinValue;
	}

	public String getPhoneValue() {
		return phoneValue;
	}

	public String getEmailValue() {
		return emailValue;
	}

	public String getPasswordValue() {
		return passwordValue;
	}
	
	
}
