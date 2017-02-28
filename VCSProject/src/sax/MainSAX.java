package sax;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MainSAX {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(new File("resources/books.xml"), getHandler());
	}

	public static DefaultHandler getHandler() {
		return new DefaultHandler() {
			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				if (!Objects.equals(qName, "books")) {
					String value = attributes.getValue("id");
					if (Objects.isNull(value)) {
						System.out.print(qName + "=");
					} else {
						System.out.println(qName + " id=" + value);
					}
				}
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				if (Objects.equals(qName, "book")) {
					System.out.println();
				}
			}

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				String str = new String(Arrays.copyOfRange(ch, start, start + length));
				if (str.trim().length() > 0) {
					System.out.println(str);
				}
			}

			@Override
			public void warning(SAXParseException e) throws SAXException {
				e.printStackTrace();
			}

			@Override
			public void error(SAXParseException e) throws SAXException {
				e.printStackTrace();
			}

			@Override
			public void fatalError(SAXParseException e) throws SAXException {
				e.printStackTrace();
			}
		};
	}
}
