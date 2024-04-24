package com.spring.actor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int actorId;
	private String actorName;
	private String actorAddress;
	private int actorAge;
	private String nationality;
	private String industry;
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getActorAddress() {
		return actorAddress;
	}
	public void setActorAddress(String actorAddress) {
		this.actorAddress = actorAddress;
	}
	public int getActorAge() {
		return actorAge;
	}
	public void setActorAge(int actorAge) {
		this.actorAge = actorAge;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	
	
	
	
	

}
