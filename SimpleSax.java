package by.htp.parsbook;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleSax extends DefaultHandler {

	private List<Book> books = new ArrayList<Book>();
	private Book book;
	private Author author;
	private StringBuilder text;
	private List<Author> authors = new ArrayList<Author>();
	private ISBN ISBN;

	public List<Book> getBookList() {
		return books;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void startDocument() throws SAXException {
		System.out.println("Parsing started.");
	}

	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("startElement -> " + "uri: " + uri + ", localName:" + localName + ", qName: " + qName);

		text = new StringBuilder();
		if (qName.equals("book")) {
			book = new Book();
			book.setId((Integer.parseInt(attributes.getValue("id"))));
		} else if (qName.equals("author")) {
			author = new Author();
			book.setAuthors(authors);

		} else if (qName.equals("ISBN")) {
			ISBN = new ISBN();
			ISBN.setNumber((attributes.getValue("number")));
			book.setIsbn(ISBN);
		}

	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		TagName tagName = TagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch (tagName) {
		case NAME:
			author.setName(text.toString());
			break;
		case DATE_OF_BIRTH:
			author.setDateOfBirth(text.toString());
			break;
		case TITLE:
			book.setTitle(text.toString());
			break;
		case PAGES:
			book.setPages(Integer.parseInt(text.toString()));
			break;
		case AUTHOR:
			authors.add(author);
			break;
		case BOOK:
			books.add(book);
			book = null;
			break;
		}
	}
}
