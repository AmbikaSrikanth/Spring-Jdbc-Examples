package com.nit.dao;

import java.util.List;
import java.util.Map;

import com.nit.model.BookDetails;

// bookdetails dao
public interface BookDetailsDAO {
	public int saveData(BookDetails book);
	public int deleteById(Integer bookId);
	public int updateByAuthorName(Integer bookID);
	public Map<String,Object> loadById(Integer bookId);
	//public Map<String,Object> loadByAuthorName(String authorName);
	//above method is not possible
	public void loadMultipleData(String authorName);
	public void loadAllRecords();
	public BookDetails loadAllById(Integer bookId);
	public List<BookDetails> loadAll();
	public void batchInsertion(List<BookDetails> books);
	public void deleteBookDetails();
	//Syso................
	 

}
