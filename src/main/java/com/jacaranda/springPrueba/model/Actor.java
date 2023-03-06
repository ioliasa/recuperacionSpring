package com.jacaranda.springPrueba.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="actor")
public class Actor {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer actorId;
	
	private String firstName;
	private String lastName;
	private LocalDate lastUpdate;
	
	@OneToMany(mappedBy="actor")
	private List<Live> lives = new ArrayList<Live>();
	
	
	public Actor(Integer actorId, String firstName, String lastName, LocalDate lastUpdate) {
		super();
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
	}
	public Actor(String firstName, String lastName, LocalDate lastUpdate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
	}
	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getActorId() {
		return actorId;
	}
	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
	public List<Live> getLives() {
		return lives;
	}
	public void setLives(List<Live> lives) {
		this.lives = lives;
	}
	@Override
	public int hashCode() {
		return Objects.hash(actorId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(actorId, other.actorId);
	}
	
	
		

}
