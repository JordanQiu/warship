package org.sevenup.service.book;

import java.util.List;

import org.sevenup.domain.book.Book;
import org.sevenup.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class BookServiceHandler implements BookService {
	private BookRepository bookRepository;
	@Autowired
	public BookServiceHandler(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
		bookRepository.createCollection();
	}

	@Override
	public List<Book> findBook() throws DataAccessException {
		List<Book> bookList = Lists.newArrayList(bookRepository.findAll());
		return bookList;
	}

	@Override
	public List<Book> saveBooks(List<Book> books) throws DataAccessException{
	
		return Lists.newArrayList(bookRepository.save(books));
	
	}

}
