package org.sevenup.domain.memo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;
@XmlRootElement(name="memoBoard")
@XmlAccessorType(XmlAccessType.FIELD)
public class MemoBoard extends ResourceSupport implements Serializable{
	private Date dateTimeOfSubmission;
	private UUID key;
	@XmlElement(name="memo")
	private List<Memo> items;
	public Date getDateTimeOfSubmission() {
		return dateTimeOfSubmission;
	}
	public void setDateTimeOfSubmission(Date dateTimeOfSubmission) {
		this.dateTimeOfSubmission = dateTimeOfSubmission;
	}
	public UUID getKey() {
		return key;
	}
	public void setKey(UUID key) {
		this.key = key;
	}
	public List<Memo> getItems() {
		return items;
	}
	public void setItems(List<Memo> items) {
		this.items = items;
	}
}
