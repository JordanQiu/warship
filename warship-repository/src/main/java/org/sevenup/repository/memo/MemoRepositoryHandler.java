package org.sevenup.repository.memo;

import java.util.List;

import org.sevenup.domain.memo.Memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
@Repository
public class MemoRepositoryHandler implements MemoRepository{

	@Autowired
	@Qualifier("mongoTemplate")
	MongoTemplate mongoTemplate;

	@Override
	public List<Memo> findAll() {
		return mongoTemplate.findAll(Memo.class);
	}

	@Override
	public List<Memo> findAll(Sort sort) {
		Query query = new Query();
		query.with(sort);
		return mongoTemplate.find(query, Memo.class);
	}

	@Override
	public <S extends Memo> List<S> save(Iterable<S> memos) {
		List memoList = Lists.newArrayList(memos);
		mongoTemplate.insertAll(memoList);
		memoList = mongoTemplate.findAll(Memo.class);
		return memoList;
	}

	@Override
	public Page<Memo> findAll(Pageable pageable) {
		Query query = new Query();
		query.with(pageable);
		Page<Memo> page = new PageImpl<Memo>(mongoTemplate.find(query, Memo.class));
		return page;
	}
	@Override
	public Page<Memo> findAll(Pageable pageable, Sort sort) {
		Query query = new Query();
		query.with(pageable);
		query.with(sort);
		Page<Memo> page = new PageImpl<Memo>(mongoTemplate.find(query, Memo.class));
		return page;
	}
	@Override
	public <S extends Memo> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Memo findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Memo> findAll(Iterable<String> ids) {
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
	public void delete(Memo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Memo> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createCollection() {
		if(!mongoTemplate.collectionExists(Memo.class)){
			mongoTemplate.createCollection(Memo.class);
		}
	}

	@Override
	public void dropCollection() {
		if(mongoTemplate.collectionExists(Memo.class)){
			mongoTemplate.dropCollection(Memo.class);
		}
	}

}
