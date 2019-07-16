package com.nit.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nit.model.BookDetails;

public class MyRowMapper implements RowMapper<BookDetails> {

	@Override
	public BookDetails mapRow(ResultSet rs, int index) throws SQLException {
		System.out.println("MyRowMapper.mapRow() is caled");
		BookDetails b=new BookDetails();
		b.setBookId(rs.getInt("BOOK_ID"));
		b.setBookName(rs.getString("BOOK_NAME"));
		b.setAuthorName(rs.getString("AUTHOR_NAME"));
		b.setBookPrice(rs.getDouble("BOOK_PRICE"));
		return b;
	}
	
	}

