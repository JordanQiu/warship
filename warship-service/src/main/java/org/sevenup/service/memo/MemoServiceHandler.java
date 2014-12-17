package org.sevenup.service.memo;


import java.util.List;

import org.sevenup.domain.memo.Memo;
import org.sevenup.domain.memo.MemoItem;
import org.sevenup.repository.memo.MemoItemRepository;
import org.sevenup.repository.memo.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
@Service
public class MemoServiceHandler implements MemoService{
//	@Autowired
	private  MemoRepository memoRepository;
//	@Autowired
	private  MemoItemRepository memoItemRepository;
	@Autowired
	MemoServiceHandler(MemoRepository memoRepository,MemoItemRepository memoItemRepository){
		this.memoRepository = memoRepository;
		this.memoItemRepository = memoItemRepository;
		memoRepository.createCollection();
		memoItemRepository.createCollection();
	}
	@Override
	public Page<Memo> findMemos(Pageable pageable) throws DataAccessException {
		return memoRepository.findAll(pageable);
	}
	@Override
	public List<Memo> findMemos(Sort sort) throws DataAccessException {
		return Lists.newArrayList(memoRepository.findAll(sort));
	}
	@Override
	public Page<Memo> findMemos(Pageable pageable, Sort sort) throws DataAccessException {
		return memoRepository.findAll(pageable,sort);
	}
	@Override
	public List<MemoItem> findMemoItems() throws DataAccessException {
		List<MemoItem> memoItems = Lists.newArrayList(memoItemRepository.findAll());
		return memoItems;
	}

	@Override
	public Memo saveMemo(Memo memo) throws DataAccessException {
		return memoRepository.save(memo);
	}
	@Override
	public List<Memo> saveMemos(List<Memo> memos) throws DataAccessException {
		return Lists.newArrayList(memoRepository.save(memos));
	}
	@Override
	public List<Memo> findMemos() {
		return Lists.newArrayList(memoRepository.findAll());
	}

}
