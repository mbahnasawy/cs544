package cs544.exercise19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookDao implements IBookDao {
	private static int idCount = 1;
	private Map<Integer, Book> books = new HashMap<>();
	
	public BookDao() throws ParseException {
		add(new Book("Clean Code", "1122334", "John", 12.5, new SimpleDateFormat("dd/MM/yyyy").parse("15/05/20219")));
		add(new Book("Chracking the Code Interview", "1122555534", "Makeda", 133.5, new SimpleDateFormat("dd/MM/yyyy").parse("15/05/20219")));
	}
	
	@Override
	public List<Book> getAll() {
		return new ArrayList<Book>(books.values());
	}
	
	@Override
	public void add(Book book) {
		book.setId(idCount);
		books.put(idCount, book);
		idCount++;
	}
	
	@Override
	public Book get(int id) {
		Book result = books.get(id);
		
		if (result == null) {
			throw new NoSuchResourceException("Book", id);
		}
		
		return result;
	}
	
	@Override
	public void update(int bookId, Book book) {
		books.put(bookId, book);
	}
	
	@Override
	public void delete(int bookId) {
		Book removed = books.remove(bookId);
		if (removed == null) {
			throw new NoSuchResourceException("Book", bookId);
		}
	}
}
