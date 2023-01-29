package com.jacaranda.springPrueba.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Jacarandenno implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private String password;
	private String name;
	private String role;
	@OneToMany(mappedBy="jacarandenno")
	private List<Turn> turnos;
	
	
	

	public Jacarandenno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jacarandenno(String username, String password, String name, String role) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.role = role;
		turnos = new ArrayList<Turn>();
	}
	
	
	

	public List<Turn> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turn> turnos) {
		this.turnos = turnos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = this.getRole();
	    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	    authorities.add(new SimpleGrantedAuthority(role));
	    return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jacarandenno other = (Jacarandenno) obj;
		return Objects.equals(username, other.username);
	}

	
}
