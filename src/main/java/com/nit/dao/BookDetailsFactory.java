package com.nit.dao;

public class BookDetailsFactory {
	public static BookDetailsDAO getInstance() {
		return  new BookDetailsDAOImpl();
	}

}
