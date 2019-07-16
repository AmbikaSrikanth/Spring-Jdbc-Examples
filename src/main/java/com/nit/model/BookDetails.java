package com.nit.model;

public class BookDetails {
	public BookDetails() {
	System.out.println("BookDetails.BookDetails()::constructor");
	}
	public Integer bookId;
	public Integer getBookId() {
		return bookId;
	}
	public BookDetails(Integer bookId, String bookName, String authorName, Double bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName
				+ ", bookPrice=" + bookPrice + "]";
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String bookName;
	public String authorName;
	public Double bookPrice;
	

}
