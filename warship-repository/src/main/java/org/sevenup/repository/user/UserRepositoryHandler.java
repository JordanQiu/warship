package org.sevenup.repository.user;

import java.util.List;

import org.sevenup.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
@Repository
public class UserRepositoryHandler implements UserRepository{

	@Autowired
	@Qualifier("mongoTemplate")
	MongoTemplate mongoTemplate;
	
	@Override
	public Iterable<User> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		Query query = new Query();
		query.with(pageable);
		Page<User> page = new PageImpl<User>(mongoTemplate.find(query, User.class));
		return page;
	}

	@Override
	public <S extends User> S save(S entity) {
		mongoTemplate.save(entity);   
		return entity;
	}

	@Override
	public <S extends User> Iterable<S> save(Iterable<S> entities) {
		List users = Lists.newArrayList(entities);
		mongoTemplate.insertAll(users);
		users = mongoTemplate.findAll(User.class);
		return users;
	}

	@Override
	public User findOne(String id) {
		User user = mongoTemplate.findOne(new Query(Criteria.where("uid").is(id)), User.class);
		return user;
	}

	@Override
	public boolean exists(String id) {
		boolean exists = mongoTemplate.exists(new Query(Criteria.where("uid").is(id)), User.class);
		return exists;
	}

	@Override
	public Iterable<User> findAll() {
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public Iterable<User> findAll(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		mongoTemplate.remove(new Query(Criteria.where("uid").is(id)), User.class);
	}

	@Override
	public void delete(User entity) {
		mongoTemplate.remove(entity);
	}

	@Override
	public void delete(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createCollection() {
		if(!mongoTemplate.collectionExists(User.class)){
			mongoTemplate.createCollection(User.class);
		}
	}

	@Override
	public void dropCollection() {
		if(mongoTemplate.collectionExists(User.class)){
			mongoTemplate.dropCollection(User.class);
		}
	}
	}
