package telran.library.entities;

import java.util.*;

public class RemovedBookData
{
	Book book;
	List<PickRecord> records;// list of the records related to the book
	// if book isn't actually deleted the records is null

	public RemovedBookData()
	{
	}
	
	public RemovedBookData(Book book, List<PickRecord> records)
	{
		super();
		this.book = book;
		this.records = records;
	}

	public Book getBook()
	{
		return book;
	}

	public List<PickRecord> getRecords()
	{
		return records;
	}
	
	
}
