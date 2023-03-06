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
@Table(name="city")
public class City {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;
	private String city;
	private LocalDate lastUpdate;
	@OneToMany(mappedBy="city")
	private List<Live> lives = new ArrayList<Live>();
	
	
	
	public City(Integer cityId, String city, LocalDate lastUpdate) {
		super();
		this.cityId = cityId;
		this.city = city;
		this.lastUpdate = lastUpdate;
	}
	public City(String city, LocalDate lastUpdate) {
		super();
		this.city = city;
		this.lastUpdate = lastUpdate;
	}
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
		return Objects.hash(cityId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(cityId, other.cityId);
	}
	
	

}
