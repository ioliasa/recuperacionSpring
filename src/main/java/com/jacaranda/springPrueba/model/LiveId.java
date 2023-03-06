package com.jacaranda.springPrueba.model;

import java.io.Serializable;
import java.util.Objects;

public class LiveId implements Serializable{
	private Integer actor;
	private Integer city;
	public LiveId(Integer actor, Integer ciudad) {
		super();
		this.actor = actor;
		this.city = ciudad;
	}
	public LiveId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getActor() {
		return actor;
	}
	public void setActor(Integer actor) {
		this.actor = actor;
	}
	
	
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	@Override
	public int hashCode() {
		return Objects.hash(actor, city);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LiveId other = (LiveId) obj;
		return Objects.equals(actor, other.actor) && Objects.equals(city, other.city);
	}
	
	
	
	

}
