package org.sevenup.domain.book;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class Book extends ResourceSupport implements Serializable {
	private String isbn;
	private String title;
	private String originTitle;
	private String altTitle;
	private String subTitle;
	private String url;
	private String alt;
	private String image;
	private HashMap<String, String> images;
	private List<String> author;
	private List<String> translator;
	private String publisher;
	private Date pubdate;
	private HashMap<String, Double> rating;
	private List<Tag> tags;
	private String binding;
	private double price;
	private int pages;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOriginTitle() {
		return originTitle;
	}
	public void setOriginTitle(String originTitle) {
		this.originTitle = originTitle;
	}
	public String getAltTitle() {
		return altTitle;
	}
	public void setAltTitle(String altTitle) {
		this.altTitle = altTitle;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public HashMap<String, String> getImages() {
		return images;
	}
	public void setImages(HashMap<String, String> images) {
		this.images = images;
	}
	public List<String> getAuthor() {
		return author;
	}
	public void setAuthor(List<String> author) {
		this.author = author;
	}
	public List<String> getTranslator() {
		return translator;
	}
	public void setTranslator(List<String> translator) {
		this.translator = translator;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public HashMap<String, Double> getRating() {
		return rating;
	}
	public void setRating(HashMap<String, Double> rating) {
		this.rating = rating;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public String getBinding() {
		return binding;
	}
	public void setBinding(String binding) {
		this.binding = binding;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
}
