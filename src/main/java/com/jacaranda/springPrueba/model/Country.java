package com.jacaranda.springPrueba.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="country")
public class Country {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer countryId;
	private String country;
	private LocalDate lastUpdate;
	public Country(Integer countryId, String country, LocalDate lastUpdate) {
		super();
		this.countryId = countryId;
		this.country = country;
		this.lastUpdate = lastUpdate;
	}
	public Country(String country, LocalDate lastUpdate) {
		super();
		this.country = country;
		this.lastUpdate = lastUpdate;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LocalDate getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(countryId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(countryId, other.countryId);
	}
	
	

}
