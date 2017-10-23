package by.htp.parsbook;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resources;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SaxDemo {

	public static void main(String[] args) throws ParserConfigurationException,	SAXException, IOException {
		// TODO Auto-generated method stub
		XMLReader reader = XMLReaderFactory.createXMLReader();
		SimpleSax handler = new SimpleSax();
		reader.setContentHandler(handler);
		reader.parse(new InputSource(new FileReader("D:\\library.xml")));
		//handler.startDocument();
		List<Book> books = handler.getBookList();
		for (Book b : books) {
			System.out.println(b);
		}
	}

}
