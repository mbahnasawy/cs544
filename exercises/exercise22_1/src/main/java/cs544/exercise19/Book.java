package cs544.exercise19;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Book {
	private int id;
	@NotBlank
	private String title;
	@Pattern(regexp = "\\d{3}-\\d{10}")
	private String ISBN;
	@NotBlank
	private String author;
	@Min(value = (long) 0.1)
	private double price;
	@Past
	private Date publishedDate ; 

	public Book() {
		super();
	}

	public Book(String title, String iSBN, String author, double price, Date date) {
		super();
		this.title = title;
		this.ISBN = iSBN;
		this.author = author;
		this.price = price;
		this.publishedDate = date;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

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

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
