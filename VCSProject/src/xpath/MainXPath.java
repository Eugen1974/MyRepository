package xpath;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

//http://www.vogella.com/tutorials/JavaXML/article.html#javaxpath
public class MainXPath {

	public static void main(String[] args)
			throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		QueryXML.query();
	}
}
