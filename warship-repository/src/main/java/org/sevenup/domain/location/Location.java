package org.sevenup.domain.location;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

public class Location extends ResourceSupport implements Serializable{

	@Id
	private String id;
	private String locationName;
	private String description;
	private double[] position;

	public double[] getPosition() {
		return position;
	}

	public void setPosition(double[] position) {
		this.position = position;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}