package com.nit.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nit.model.BookDetails;
import com.nit.util.MyRowMapper;

/**this class is used to perform CURD operations
 * @author Srikanth
 *
 */
public class BookDetailsDAOImpl implements BookDetailsDAO {
	private static final String INSERT_BOOKDTLS_SQL="INSERT INTO BOOK_DTLS(BOOK_ID,AUTHOR_NAME,BOOK_NAME,BOOK_PRICE) VALUES(?,?,?,?)";
	private static final String DELETE_BY_BOOK_ID="DELETE FROM BOOK_DTLS WHERE BOOK_ID=?";
	private static final String UPDATE_BY_AUTOR_NAME="UPDATE BOOK_DTLS SET AUTHOR_NAME='cathie' WHERE BOOK_ID=? ";
	private static final String LOAD_BY_BOOKID="SELECT * FROM BOOK_DTLS WHERE BOOK_ID=?";
	//private static final String LOAD_BY_AUTHOR_NAME="SELECT * FROM BOOK_DTLS WHERE AUTHOR_NAME=?"; 
	private static final String LOAD_BY_AUTHOR_NAME="SELECT * FROM BOOK_DTLS WHERE AUTHOR_NAME=?"; 
	private static final String LOAD_ALL_RECORDS="SELECT * FROM BOOK_DTLS";
	//injecting predefine dependent object
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
     /* 
	 * thism,ethodis used to insert A record into table
	 */
	public int saveData(BookDetails book) {
		int cnt=template.update(INSERT_BOOKDTLS_SQL, 
				book.getBookId(),
				book.getBookName(),
				book.getAuthorName(),
				book.getBookPrice());
		
		return cnt;
	}
	public int deleteById(Integer bookId) {
		return template.update(DELETE_BY_BOOK_ID, bookId);
		
		 
	}
	public int updateByAuthorName(Integer bookId) {
		
		return template.update(UPDATE_BY_AUTOR_NAME, bookId);
	}
	public Map<String, Object> loadById(Integer bookId) {
		
		return template.queryForMap(LOAD_BY_BOOKID,bookId);
	}
	/*public Map<String, Object> loadByAuthorName(String authorName) {
		return template.queryForMap(LOAD_BY_AUTHOR_NAME,authorName);
	}*/
	public void loadMultipleData(String authorName) {
		System.out.println("BookDetailsDAOImpl.loadMultipleData()");
	List<Map<String,Object>> bookList=template.queryForList(LOAD_BY_AUTHOR_NAME, authorName);
		bookList.forEach(map->{
			System.out.println(map);
		});
	}
	@Override
	public void loadAllRecords() {
		System.out.println("BookDetailsDAOImpl.loadAllRecords()");
		List<Map<String,Object>> bookList=template.queryForList(LOAD_ALL_RECORDS);
		for(Map list:bookList) {
			System.out.println(list);
		}
		
	}
	@Override
	public BookDetails loadAllById(Integer bookId) {
		BookDetails b=template.queryForObject(LOAD_BY_BOOKID,new Object[] {bookId},new MyRowMapper() );
		//System.out.println(b);
		return b;
		
	}
	@Override
	public List<BookDetails> loadAll() {
		return template.query(LOAD_ALL_RECORDS, new MyRowMapper());
		
	}
	@Override
	public void batchInsertion(List<BookDetails> books) {
		template.batchUpdate(INSERT_BOOKDTLS_SQL, new  BatchPreparedStatementSetter() {

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return books.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				System.out.println(
						"setValues() is called");
				BookDetails b=books.get(index);
				ps.setInt(1, b.getBookId());
				ps.setString(2, b.getBookName());
				ps.setString(3, b.getAuthorName());
				ps.setDouble(4, b.getBookPrice());
			}
			
		});
	
		
	}

}
