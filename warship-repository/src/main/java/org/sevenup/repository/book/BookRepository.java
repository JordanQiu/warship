package org.sevenup.repository.book;

import org.sevenup.domain.book.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book,String> {
	public void createCollection();
	
	public void dropCollection();
}
