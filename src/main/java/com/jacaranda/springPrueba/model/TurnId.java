package com.jacaranda.springPrueba.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class TurnId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String jacarandenno;
	private String signature;
	private LocalDateTime time;
	
	
	
	public TurnId(String jacarandenno, String signature, LocalDateTime time) {
		super();
		this.jacarandenno = jacarandenno;
		this.signature = signature;
		this.time = time;
	}
	
	public TurnId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getJacarandenno() {
		return jacarandenno;
	}
	public void setJacarandenno(String jacarandenno) {
		this.jacarandenno = jacarandenno;
	}
	
	
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	@Override
	public int hashCode() {
		return Objects.hash(jacarandenno, signature, time);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TurnId other = (TurnId) obj;
		return Objects.equals(jacarandenno, other.jacarandenno) && Objects.equals(signature, other.signature)
				&& Objects.equals(time, other.time);
	}
	
	
	
	
	

}
