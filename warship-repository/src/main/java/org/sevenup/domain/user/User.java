package org.sevenup.domain.user;


import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User extends ResourceSupport implements Serializable{
	@Id
	private String uid;
	private String name;
	private String avatar;
	private String alt;
	private String relation;
	private Date createdTime;
	private String locactionId;
	private String locactionName;
	private String description;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getLocactionId() {
		return locactionId;
	}
	public void setLocactionId(String locactionId) {
		this.locactionId = locactionId;
	}
	public String getLocactionName() {
		return locactionName;
	}
	public void setLocactionName(String locactionName) {
		this.locactionName = locactionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
