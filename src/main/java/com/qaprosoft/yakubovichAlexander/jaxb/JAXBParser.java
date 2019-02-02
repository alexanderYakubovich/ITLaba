package com.qaprosoft.yakubovichAlexander.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class JAXBParser {
    private static final Logger LOGGER = LogManager.getLogger(JAXBParser.class);

    public static void main(String[] args) throws FileNotFoundException, JAXBException {
	FileReader file = new FileReader(
		"src/com/qaprosoft/yakubovichAlexander/main/resources/parsers/XML_ORIGINAL.xml");
	JAXBContext jaxbContext = JAXBContext.newInstance(ITCompany.class);
	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	ITCompany it = (ITCompany) jaxbUnmarshaller.unmarshal(file);

	Map<String, List> hashMapJAXB = new HashMap<>();
	hashMapJAXB.put("Accountants", it.getAccountantList());
	hashMapJAXB.put("CEOs", it.getCeoList());
	hashMapJAXB.put("Lawyers", it.getLawyerList());
	hashMapJAXB.put("Cleaners", it.getCleanerList());
	hashMapJAXB.put("MobileDevs", it.getMobileDevList());
	hashMapJAXB.put("WebDevs", it.getWebDevList());
	hashMapJAXB.put("Automations", it.getAutomatList());
	hashMapJAXB.put("ManualQAs", it.getManualQAList());
	hashMapJAXB.put("BetaQAs", it.getBetaQAList());
	LOGGER.info(hashMapJAXB);

	Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	jaxbMarshaller.marshal(it,
		new File("src/com/qaprosoft/yakubovichAlexander/main/resources/parsers/XmlJAXB.xml"));

    }
}