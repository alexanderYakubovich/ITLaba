package com.qaprosoft.yakubovichAlexander.json;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonParser {
	private final static Logger LOGGER = LogManager.getLogger(JacksonParser.class);

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		File reader = new File("src/com/qaprosoft/yakubovichAlexander/main/resources/parsers/JSON.json");

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		ITCompanyJSON jackson = mapper.readValue(reader, ITCompanyJSON.class);

		Map<String, Object> hashMapJSON = new HashMap<>();
		hashMapJSON.put("Accountant", jackson.getAccountantList());
		hashMapJSON.put("CEO", jackson.getCeoList());
		hashMapJSON.put("Lawyer", jackson.getLawyerList());
		hashMapJSON.put("Cleaner", jackson.getCleanerList());
		hashMapJSON.put("MobileDev", jackson.getMobileDevList());
		hashMapJSON.put("WebDev", jackson.getWebDevList());
		hashMapJSON.put("AutomationONE", jackson.getAutomatList());
		hashMapJSON.put("AutomationTwo", jackson.getAutomatList());
		hashMapJSON.put("ManualQA", jackson.getManualQAList());
		hashMapJSON.put("BetaQA", jackson.getBetaQAList());

		LOGGER.info(hashMapJSON);

		mapper.writeValue(new File("src/com/qaprosoft/yakubovichAlexander/main/resources/parsers/ConvertToJson.json"),
				jackson);

	}
}