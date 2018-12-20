package com.qaprosoft.yakubovichAlexander.jaxb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.yakubovichAlexander.employee.techstaff.TechStaff;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.Automation;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.Development;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.MobileDev;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.dev.WebDev;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.qa.BetaQA;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.qa.ManualQA;
import com.qaprosoft.yakubovichAlexander.employee.techstaff.qa.QA;
import com.qaprosoft.yakubovichAlexander.main.java.employee.Employee;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.Accountant;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.CEO;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.Cleaner;
import com.qaprosoft.yakubovichAlexander.main.java.employee.administrative.Lawyer;
import com.qaprosoft.yakubovichAlexander.main.java.exception.IncorrectSalaryException;
import com.qaprosoft.yakubovichAlexander.main.java.exception.IncorrectYearException;
import com.qaprosoft.yakubovichAlexander.main.java.positionEnum.PositionEnum;

public class StAX {
	private final static Logger LOGGER = LogManager.getLogger(StAX.class);

	public static void main(String[] args)
			throws NumberFormatException, IncorrectYearException, IncorrectSalaryException, ParseException {

		String pathInput = "src/com/qaprosoft/yakubovichAlexander/main/resources/parsers/XML.xml";
		List<Employee> empList = parseXML(pathInput);
		for (Employee emp : empList) {
			LOGGER.info(emp.toString());
		}
	}

	private static List<Employee> parseXML(String fileName)
			throws NumberFormatException, IncorrectYearException, IncorrectSalaryException, ParseException {

		List<Employee> empList = new ArrayList<>();
		Employee emp = null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
			while (xmlEventReader.hasNext()) {
				XMLEvent xmlEvent = xmlEventReader.nextEvent();

//				ACCOUNTANT START
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("Accountant")) {
						emp = new Accountant();
						exctractId(emp, startElement);
					} else
						xmlEvent = extractBasicFields(emp, xmlEventReader, xmlEvent, startElement);
				}
				// END ELEMENT
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("Accountant")) {
						empList.add(emp);
					}
				}
//					CEO START
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("CEO")) {
						emp = new CEO();
						exctractId(emp, startElement);
					} else
						xmlEvent = extractBasicFields(emp, xmlEventReader, xmlEvent, startElement);
				}
				// END ELEMENT
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("CEO")) {
						empList.add(emp);
					}
				}
//				LAWYER START
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("Lawyer")) {
						emp = new Lawyer();
						exctractId(emp, startElement);
					} else
						xmlEvent = extractBasicFields(emp, xmlEventReader, xmlEvent, startElement);
				}
				// END ELEMENT
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("Lawyer")) {
						empList.add(emp);
					}
				}
				// CLEANER START
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("Cleaner")) {
						emp = new Cleaner();
						exctractId(emp, startElement);
					} else
						xmlEvent = extractBasicFields(emp, xmlEventReader, xmlEvent, startElement);
				}
				// END ELEMENT
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("Cleaner")) {
						empList.add(emp);
					}
				}
//				MOBILEDEV START
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("MobileDev")) {
						emp = new MobileDev();
						exctractId(emp, startElement);
					} else
						xmlEvent = extractBasicFields(emp, xmlEventReader, xmlEvent, startElement);
				}
				// END ELEMENT
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("MobileDev")) {
						empList.add(emp);
					}
				}
//					WEBDEV START
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("WebDev")) {
						emp = new WebDev();
						exctractId(emp, startElement);
					} else
						xmlEvent = extractBasicFields(emp, xmlEventReader, xmlEvent, startElement);
				}
//					END ELEMENT
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("WebDev")) {
						empList.add(emp);
					}
				}
//				AUTOMATION START
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("Automation")) {
						emp = new Automation();
						exctractId(emp, startElement);
					} else
						xmlEvent = extractBasicFields(emp, xmlEventReader, xmlEvent, startElement);
				}
				// END ELEMENT
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("Automation")) {
						empList.add(emp);
					}
				}
//					MANUALQA START
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("ManualQA")) {
						emp = new ManualQA();
						exctractId(emp, startElement);
					} else
						xmlEvent = extractBasicFields(emp, xmlEventReader, xmlEvent, startElement);
				}
				// END ELEMENT
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("ManualQA")) {
						empList.add(emp);
					}
				}
//				BETAQA START
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("BetaQA")) {
						emp = new BetaQA();
						exctractId(emp, startElement);
					} else
						xmlEvent = extractBasicFields(emp, xmlEventReader, xmlEvent, startElement);
				}
				// END ELEMENT
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("BetaQA")) {
						empList.add(emp);
					}
				}
			}
		} catch (FileNotFoundException | XMLStreamException e) {
			((Exception) e).printStackTrace();
		}
		return empList;
	}

	public static void exctractId(Employee emp, StartElement startElement) {
		Attribute idAttr = (Attribute) startElement.getAttributeByName(new QName("ID"));
		if (idAttr != null) {
			emp.setID(Integer.parseInt((String) idAttr.getValue()));
		}
	}

	public static XMLEvent extractBasicFields(Employee emp, XMLEventReader xmlEventReader, XMLEvent xmlEvent,
			StartElement startElement)
			throws XMLStreamException, IncorrectYearException, IncorrectSalaryException, ParseException {
		if (startElement.getName().getLocalPart().equals("name")) {
			xmlEvent = xmlEventReader.nextEvent();
			emp.setName(xmlEvent.asCharacters().getData());

		} else if (startElement.getName().getLocalPart().equals("city")) {
			xmlEvent = xmlEventReader.nextEvent();
			emp.setCity(xmlEvent.asCharacters().getData());
		} else if (startElement.getName().getLocalPart().equals("year")) {
			xmlEvent = xmlEventReader.nextEvent();
			emp.setYear(Integer.parseInt(xmlEvent.asCharacters().getData()));
		} else if (startElement.getName().getLocalPart().equals("date")) {
			xmlEvent = xmlEventReader.nextEvent();
			emp.setDate(xmlEvent.asCharacters().getData());
		} else if (startElement.getName().getLocalPart().equals("projectLanguage")) {
			xmlEvent = xmlEventReader.nextEvent();
			((Development) emp).setProjectLanguage(xmlEvent.asCharacters().getData());
		} else if (startElement.getName().getLocalPart().equals("platformName")) {
			xmlEvent = xmlEventReader.nextEvent();
			((MobileDev) emp).setPlatformName(xmlEvent.asCharacters().getData());
		} else if (startElement.getName().getLocalPart().equals("project")) {
			xmlEvent = xmlEventReader.nextEvent();
			((TechStaff) emp).setProject(xmlEvent.asCharacters().getData());
		} else if (startElement.getName().getLocalPart().equals("personalStamp")) {
			xmlEvent = xmlEventReader.nextEvent();
			((Accountant) emp).setPersonalStamp(xmlEvent.asCharacters().getData());
		} else if (startElement.getName().getLocalPart().equals("lawyersLicense")) {
			xmlEvent = xmlEventReader.nextEvent();
			((Lawyer) emp).setLawyersLicense(xmlEvent.asCharacters().getData());
		} else if (startElement.getName().getLocalPart().equals("companyCar")) {
			xmlEvent = xmlEventReader.nextEvent();
			((CEO) emp).setCompanyCar(xmlEvent.asCharacters().getData());
		} else if (startElement.getName().getLocalPart().equals("сleaningEquipment")) {
			xmlEvent = xmlEventReader.nextEvent();
			((Cleaner) emp).setСleaningEquipment(xmlEvent.asCharacters().getData());
		} else if (startElement.getName().getLocalPart().equals("kindOfTest")) {
			xmlEvent = xmlEventReader.nextEvent();
			((Automation) emp).setKindOfTest(xmlEvent.asCharacters().getData());
		} else if (startElement.getName().getLocalPart().equals("device")) {
			xmlEvent = xmlEventReader.nextEvent();
			((QA) emp).setDevice(xmlEvent.asCharacters().getData());
		} else if (startElement.getName().getLocalPart().equals("position")) {
			xmlEvent = xmlEventReader.nextEvent();
			emp.setPosition(PositionEnum.valueOf(xmlEvent.asCharacters().getData()));
		} else if (startElement.getName().getLocalPart().equals("salary")) {
			xmlEvent = xmlEventReader.nextEvent();
			emp.setSalary(Integer.parseInt(xmlEvent.asCharacters().getData()));
		}
		return xmlEvent;
	}
}
