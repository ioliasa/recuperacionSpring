package com.jacaranda.springPrueba.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="module")
public class Signature {
	
	@Id
	private String initials;
	private String name;
	private int hour;
	@OneToMany(mappedBy="signature")
	private List<Turn> turnos;
	
	public Signature(String initials, String name, int hour) {
		super();
		this.initials = initials;
		this.name = name;
		this.hour = hour;
		this.turnos = new ArrayList<Turn>();
	}

	public Signature() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public List<Turn> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turn> turnos) {
		this.turnos = turnos;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public int hashCode() {
		return Objects.hash(initials);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Signature other = (Signature) obj;
		return Objects.equals(initials, other.initials);
	}
	
	
	
}
