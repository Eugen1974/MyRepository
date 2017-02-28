package stax.write;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class MyStAXWriter {

	public static final File FILE = new File("resources/data1.xml");

	public static void writeXML() throws Exception {
		// create an XMLOutputFactory
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		// create XMLEventWriter
		XMLEventWriter eventWriter = outputFactory
				.createXMLEventWriter(new BufferedOutputStream(new FileOutputStream(FILE)));
		// create an EventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		// create and write Start Tag
		StartDocument startDocument = eventFactory.createStartDocument();
		eventWriter.add(startDocument);

		// create config open tag
		StartElement configStartElement = eventFactory.createStartElement("", "", "item");
		eventWriter.add(configStartElement);
		eventWriter.add(end);
		// Write the different nodes
		createNode(eventWriter, "mode", "1");
		createNode(eventWriter, "unit", "901");
		createNode(eventWriter, "current", "0");
		createNode(eventWriter, "interactive", "0");

		eventWriter.add(eventFactory.createEndElement("", "", "item"));
		eventWriter.add(end);
		eventWriter.add(eventFactory.createEndDocument());
		eventWriter.close();
	}

	private static void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// create Start node
		StartElement sElement = eventFactory.createStartElement("", "", name);
		eventWriter.add(tab);
		eventWriter.add(sElement);
		// create Content
		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);
		// create End node
		EndElement eElement = eventFactory.createEndElement("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);
	}
}