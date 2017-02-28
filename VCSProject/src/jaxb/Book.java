package jaxb;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
	@XmlAttribute
	private int id;
	private String author;
	private String name;
	private float price;
	@XmlJavaTypeAdapter(jaxb.XmlLocalDateAdapter.class)
	private LocalDate dataPublisher;

	public Book() {
	}

	public Book(int id, String author, String name, float price, LocalDate dataPublisher) {
		this.id = id;
		this.author = author;
		this.name = name;
		this.price = price;
		this.dataPublisher = dataPublisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalDate getDataPublisher() {
		return dataPublisher;
	}

	public void setDataPublisher(LocalDate dataPublisher) {
		this.dataPublisher = dataPublisher;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", name=" + name + ", price=" + price + ", dataPublisher="
				+ dataPublisher + "]";
	}
}
