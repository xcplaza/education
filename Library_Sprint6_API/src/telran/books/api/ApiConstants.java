package telran.books.api;

public interface ApiConstants {

	String ADD_BOOK = "/book/add";
	String ADD_READER = "/reader/add";
	String ADD_EXEMPLARS = "/exemplars/add";
	String GET_READER = "/reader";
	String GET_BOOK = "/book";
	String PICK_BOOK = "/book/pick";
	String GET_BOOKS_PICKED_READER = "/readers/books";
	String GET_READERS_PICKED_BOOK = "/book/readers";
	String GET_BOOKS_AUTHOR = "/author";
	String GET_PICKED_RECORDS_DATES = "/records/picked";
	String REMOVE_BOOK = "/book/remove";
	String REMOVE_AUTHOR = "/author/remove";
	String RETURN_BOOK = "/book/return";
	String GET_READERS_DELAYING_BOOKS = "/readers/delaying";
	String GET_READERS_DELAYED_BOOKS = "/readers/delayed";
	String GET_MOST_POPULAR_BOOKS = "/books/popular";
	String GET_MOST_POPULAR_AUTHORS = "/authors/popular";
	String GET_MOST_ACTIVE_READERS = "/readers/active";
	String GET_AUTHORS = "/authors";
}
