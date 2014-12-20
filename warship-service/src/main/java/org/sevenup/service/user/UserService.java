package org.sevenup.service.user;

import java.util.List;

import org.sevenup.domain.user.Book;
import org.springframework.dao.DataAccessException;


public interface UserService {
    List<Book> findUsers() throws DataAccessException;

    Book findUserById(String id) throws DataAccessException;

    Book saveUser(Book user) throws DataAccessException;

    List<Book> saveUsers(List<Book> users) throws DataAccessException;
    
    void deleteUser(String id) throws DataAccessException;

}
