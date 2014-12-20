package org.sevenup.service.book;

import java.util.List;

import org.sevenup.domain.book.Book;
import org.springframework.dao.DataAccessException;

public interface BookService {
	List<Book> findBook() throws DataAccessException;
}
