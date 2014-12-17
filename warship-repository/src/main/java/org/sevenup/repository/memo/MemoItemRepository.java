package org.sevenup.repository.memo;

import org.sevenup.domain.memo.MemoItem;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface MemoItemRepository extends PagingAndSortingRepository<MemoItem, String>{
	public void createCollection();
	
	public void dropCollection();
}
