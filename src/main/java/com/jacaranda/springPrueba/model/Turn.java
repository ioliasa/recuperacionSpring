package com.jacaranda.springPrueba.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(TurnId.class)
public class Turn {
	@Id
	@ManyToOne
	@JoinColumn(name="id_student")
	private Jacarandenno jacarandenno;
	
	@Id
	@ManyToOne
	@JoinColumn(name="initials_module ")
	private Signature signature;
	
	@Id
	private LocalDateTime time;
	
	private Boolean done;

	public Turn() {
		super();
	}

	

	public Turn(Jacarandenno jacarandenno, Signature signature, LocalDateTime time, Boolean done) {
		super();
		this.jacarandenno = jacarandenno;
		this.signature = signature;
		this.time = time;
		this.done = done;
	}



	public Jacarandenno getJacarandenno() {
		return jacarandenno;
	}

	public void setJacarandenno(Jacarandenno jacarandenno) {
		this.jacarandenno = jacarandenno;
	}

	
	public Signature getSignature() {
		return signature;
	}



	public void setSignature(Signature signature) {
		this.signature = signature;
	}



	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	@Override
	public int hashCode() {
		return Objects.hash(done, jacarandenno, signature);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turn other = (Turn) obj;
		return Objects.equals(done, other.done) && Objects.equals(jacarandenno, other.jacarandenno)
				&& Objects.equals(signature, other.signature);
	}
	
	
	
	
	
}
