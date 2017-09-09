package by.htp.parsbook;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMBookParser {

	public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();

		Element books = document.createElement("books");
		Element book = document.createElement("book");
		book.setAttribute("id", "234");
		Element ISBN = document.createElement("ISBN");
		ISBN.setAttribute("number", "0000");

		book.appendChild(ISBN);
		books.appendChild(book);
		document.appendChild(books);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new FileWriter("D:\\Разное\\Java\\ParserBooks\\Resources\\library.xml"));
		transformer.transform(source, result);
	}
}
