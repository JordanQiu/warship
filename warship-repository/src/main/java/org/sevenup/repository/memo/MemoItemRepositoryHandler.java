package org.sevenup.repository.memo;

import org.sevenup.domain.memo.MemoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemoItemRepositoryHandler implements MemoItemRepository{
	
	@Autowired
	@Qualifier("mongoTemplate")
	MongoTemplate mongoTemplate;
	@Override
	public Iterable<MemoItem> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<MemoItem> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends MemoItem> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends MemoItem> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemoItem findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<MemoItem> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<MemoItem> findAll(Iterable<String> ids) {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemoItem entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends MemoItem> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createCollection() {
		if(!mongoTemplate.collectionExists(MemoItem.class)){
			mongoTemplate.createCollection(MemoItem.class);
		}
	}

	@Override
	public void dropCollection() {
		if(mongoTemplate.collectionExists(MemoItem.class)){
			mongoTemplate.dropCollection(MemoItem.class);
		}
	}}
