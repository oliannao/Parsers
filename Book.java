package by.htp.parsbook;

import java.util.List;

public class Book {
	private int id;
	private String title;
	private int pages;
	private ISBN ISBN;
	private List<Author> authors;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public ISBN getIsbn() {
		return ISBN;
	}

	public void setIsbn(ISBN ISBN) {
		this.ISBN = ISBN;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", pages=" + pages + ", ISBN=" + ISBN + ", authors=" + authors
				+ "]";
	}

}
