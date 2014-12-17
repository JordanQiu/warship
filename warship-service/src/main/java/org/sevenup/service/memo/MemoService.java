package org.sevenup.service.memo;

import java.util.List;

import org.sevenup.domain.memo.Memo;
import org.sevenup.domain.memo.MemoItem;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface MemoService {
	public Page<Memo> findMemos(Pageable pageable) throws DataAccessException;
	
	public Page<Memo> findMemos(Pageable pageable,Sort sort) throws DataAccessException;
	
	public List<Memo> findMemos(Sort sort) throws DataAccessException;

	public List<Memo> findMemos() throws DataAccessException;

	public List<MemoItem> findMemoItems() throws DataAccessException;

	public List<Memo> saveMemos(List<Memo> memos) throws DataAccessException;

	public Memo saveMemo(Memo memo) throws DataAccessException;
}
