package org.sevenup.domain.book;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

public class Tag extends ResourceSupport implements Serializable {
	private long count;
	private String title;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
