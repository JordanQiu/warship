package org.sevenup.service.user;

import java.util.List;

import org.sevenup.domain.user.User;
import org.sevenup.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class UserServiceHandler implements UserService{

	private UserRepository userRepository;
	@Autowired
	public UserServiceHandler(UserRepository userRepository) {
		this.userRepository = userRepository;
		//create the repository
		userRepository.createCollection();
	}
	@Override
	public List<User> findUsers() throws DataAccessException {
		List<User> userList = Lists.newArrayList(userRepository.findAll());
		return userList;
	}

	@Override
	public User findUserById(String id) throws DataAccessException {
		return userRepository.findOne(id);
	}

	@Override
	public User saveUser(User user) throws DataAccessException {
		return userRepository.save(user);
	}
	
	@Override
	public List<User> saveUsers(List<User> users) throws DataAccessException {
		return Lists.newArrayList(userRepository.save(users));
	}

	@Override
	public void deleteUser(String id) throws DataAccessException {
		userRepository.delete(id);
	}
	
}
