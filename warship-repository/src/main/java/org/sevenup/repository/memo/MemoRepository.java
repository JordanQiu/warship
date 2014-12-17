package org.sevenup.repository.memo;

import org.sevenup.domain.memo.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface MemoRepository extends PagingAndSortingRepository<Memo, String>{
	public void createCollection();
	
	public void dropCollection();
	
	public Page<Memo> findAll(Pageable pageable,Sort sort);
}
