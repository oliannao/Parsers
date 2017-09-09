package by.htp.parsbook;

import java.util.Date;

public class Author {
	private String name;	
	private String dateOfBirth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Author [name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
