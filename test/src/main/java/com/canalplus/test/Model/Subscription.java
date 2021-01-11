package com.canalplus.test.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription implements Serializable {
	
	private static final long serialVersionUID = 2284252532274015507L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "SUBSCRIPTION_ID", updatable = false, nullable = false)
	private long id;
	
	
	@Column(name = "ADRESSE", updatable = true, nullable = false)
	private String adresse;


	public Subscription() {
		super();
	}
	
	public Subscription (String adresse) {
		super();
		this.adresse = adresse;
	}


	public Subscription(long id, String adresse) {
		super();
		this.id = id;
		this.adresse = adresse;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	@Override
	public String toString() {
		return "Subscription [id=" + id + ", adresse=" + adresse + "]";
	}
	
	

}
