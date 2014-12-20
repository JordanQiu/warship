package org.sevenup.domain.memo;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;
@XmlRootElement(name="memoItem")
@XmlAccessorType(XmlAccessType.FIELD)
public class MemoItem extends ResourceSupport implements Serializable{
	private UUID key;
	private String memoItemId;
	private String title;
	private String content;
	private Date createdTime;
	private Date deadlineTime;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getDeadlineTime() {
		return deadlineTime;
	}
	public void setDeadlineTime(Date deadlineTime) {
		this.deadlineTime = deadlineTime;
	}
	public UUID getKey() {
		return key;
	}
	public void setKey(UUID key) {
		this.key = key;
	}
	public String getMemoItemId() {
		return memoItemId;
	}
	public void setMemoItemId(String memoItemId) {
		this.memoItemId = memoItemId;
	}
}
