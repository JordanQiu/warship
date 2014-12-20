package org.sevenup.repository.user;

import org.sevenup.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,String>{
	
	public void createCollection();
	
	public void dropCollection();
	
}
