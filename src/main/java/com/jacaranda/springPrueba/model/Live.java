package com.jacaranda.springPrueba.model;




import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="live")
@IdClass(LiveId.class)
public class Live {
	
	@Id
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@Id
	@ManyToOne
	@JoinColumn(name="actor_id")
	private Actor actor;
	private int career;
	public Live(City city, Actor actor, int career) {
		super();
		this.city = city;
		this.actor = actor;
		this.career = career;
	}
	public Live() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public int getCareer() {
		return career;
	}
	public void setCareer(int career) {
		this.career = career;
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
		Live other = (Live) obj;
		return Objects.equals(actor, other.actor) && Objects.equals(city, other.city);
	}
	
	


}
