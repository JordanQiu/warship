package org.sevenup.rest.controller.book;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sevenup.domain.book.Book;
import org.sevenup.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<List<Book>> getBook() {
		List<Book> bookList = bookService.findBook();
		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}
}
