package com.nit.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.dao.BookDetailsDAO;
import com.nit.model.BookDetails;

public class BookDetailsTest {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/nit/cfg/Beans.xml");
		BookDetailsDAO bdao= context.getBean("dao", BookDetailsDAO.class);
		
		//inserting a record into table
		/* BookDetails b=new BookDetails();
	 b.setBookId(105);
	 b.setBookName("WebServs");
	 b.setAuthorName("RoyField");
	 b.setBookPrice(120.00);
	
	int cnt=bdao.saveData(b);
	System.out.println("rows inserted::"+cnt);*/
		//deleting record
		/*int cnt=bdao.deleteById(105);
		System.out.println("rows deleted::"+cnt);*/
		/*//uapdating record
		int cnt=bdao.updateByAuthorName(101);
		System.out.println("row updated::"+cnt);
		*/
		/*//retrivieng single record 
		Map<String,Object> map=bdao.loadById(101);
		System.out.println(map);*/
		
		/*//retriving more than one record using queryForMap()
		
		
		Map<String,Object> map=bdao.loadByAuthorName("cathie");
	
	System.out.println(map);// we can't process thz bcz queryForMap() supports retrieve only one record*/
	
	//bdao.loadMultipleData("cathie");
		//bdao.loadAllRecords();
	//System.out.println(bdao.loadAllById(101));
	/*	List<BookDetails> list=bdao.loadAll();
	list.forEach(book ->{
		System.out.println(book);
	}
	);
		for(BookDetails book:list) {
			System.out.println(book);
		}
		//list.forEach(System.out::println);
		 
*/	
		BookDetails b1=new  BookDetails(1, "maven","ambika", 100.00);
		BookDetails b2=new  BookDetails(10, "gradle","amb", 400.00);
		BookDetails b3=new  BookDetails(7, "svn","sree", 300.00);
		BookDetails b4=new  BookDetails(8, "git","kanth", 200.00);
		
		List books=new ArrayList();
		books.add(b1);
		books.add(b2);books.add(b3);books.add(b4);
		
		bdao.batchInsertion(books);
	}

}
