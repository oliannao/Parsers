package by.htp.parsbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMBookParserTwo {

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
		File xmlFile = new File("D:\\Разное\\Java\\ParserBooks\\Resources\\library.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(xmlFile);

		List<Book> library = new ArrayList<Book>();
		Book book = null;
		ISBN ISBN = null;
		Author author = null;
		List<Author> authors = null;
		NodeList books = document.getElementsByTagName("book");
		NodeList auts = document.getElementsByTagName("author");

		for (int i = 0; i < books.getLength(); i++) {

			book = new Book();
			ISBN = new ISBN();
			author = new Author();
			ISBN = new ISBN();
			authors = new ArrayList<Author>();

			Element booklement = (Element) books.item(i);

			Element authorlement = (Element) auts.item(i);

			book.setId(Integer.parseInt(booklement.getAttribute("id")));
			book.setTitle(getSingleChild(booklement, "title").getTextContent().trim());
			book.setPages(Integer.parseInt(getSingleChild(booklement, "pages").getTextContent().trim()));
			author.setName(getSingleChild(authorlement, "name").getTextContent().trim());
			author.setDateOfBirth(getSingleChild(authorlement, "date-of-birth").getTextContent().trim());

			// book.setIsbn((getSingleChild(booklement, "ISBN").getAttribute("number"));
			authors.add(author);
			book.setAuthors(authors);
			library.add(book);
		}

		for (Book b : library) {
			System.out.println(b);
		}
	}

	private static Element getSingleChild(Element element, String childName) {
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}

}
