package org.sevenup.service.user;

import java.util.List;

import org.sevenup.domain.user.User;
import org.springframework.dao.DataAccessException;


public interface UserService {
    List<User> findUsers() throws DataAccessException;

    User findUserById(String id) throws DataAccessException;

    User saveUser(User user) throws DataAccessException;

    List<User> saveUsers(List<User> users) throws DataAccessException;
    
    void deleteUser(String id) throws DataAccessException;

}
