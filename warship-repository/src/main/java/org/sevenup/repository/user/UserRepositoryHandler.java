package org.sevenup.repository.user;

import java.util.List;

import org.sevenup.domain.user.Book;
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
	public Iterable<Book> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Book> findAll(Pageable pageable) {
		Query query = new Query();
		query.with(pageable);
		Page<Book> page = new PageImpl<Book>(mongoTemplate.find(query, Book.class));
		return page;
	}

	@Override
	public <S extends Book> S save(S entity) {
		mongoTemplate.save(entity);   
		return entity;
	}

	@Override
	public <S extends Book> Iterable<S> save(Iterable<S> entities) {
		List users = Lists.newArrayList(entities);
		mongoTemplate.insertAll(users);
		users = mongoTemplate.findAll(Book.class);
		return users;
	}

	@Override
	public Book findOne(String id) {
		Book user = mongoTemplate.findOne(new Query(Criteria.where("uid").is(id)), Book.class);
		return user;
	}

	@Override
	public boolean exists(String id) {
		boolean exists = mongoTemplate.exists(new Query(Criteria.where("uid").is(id)), Book.class);
		return exists;
	}

	@Override
	public Iterable<Book> findAll() {
		return mongoTemplate.findAll(Book.class);
	}

	@Override
	public Iterable<Book> findAll(Iterable<String> ids) {
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
		mongoTemplate.remove(new Query(Criteria.where("uid").is(id)), Book.class);
	}

	@Override
	public void delete(Book entity) {
		mongoTemplate.remove(entity);
	}

	@Override
	public void delete(Iterable<? extends Book> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createCollection() {
		if(!mongoTemplate.collectionExists(Book.class)){
			mongoTemplate.createCollection(Book.class);
		}
	}

	@Override
	public void dropCollection() {
		if(mongoTemplate.collectionExists(Book.class)){
			mongoTemplate.dropCollection(Book.class);
		}
	}
	}
