package com.nancybohane.TimeReporting.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected boolean isPaid;
	protected Date startTime;
	protected Date endTime;
	protected String description;
	protected int owner;
	
	public Task() {
		
	}
	
	public Task(int id, String description, int owner) {
		this.id = id;
		this.description = description;
		this.owner = owner;
		this.isPaid = false;
	}
	
	public Task(int id, boolean isPaid, Date startTime, Date endTime, String description, int owner) {
		this.id = id;
		this.isPaid = isPaid;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.owner = owner;
	}

	public boolean isComplete() {
		return endTime != null;
	}
	
	public void complete() {
		this.endTime = new Date();
	}
	
	public long getDuration() {
		try {
			return this.endTime.getTime() - this.startTime.getTime();
		}catch (Exception e) {
			//missing start or end time
		}
		return 0;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	
}
