package com.example.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "portfoy")
public class Portfoy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "pay_adi")
	private String pay_adi;

	@Column(name = "pay_count")
	private int pay_count;

	@Column(name = "user_id")
	private int user_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPay_adi() {
		return pay_adi;
	}

	public void setPay_adi(String pay_adi) {
		this.pay_adi = pay_adi;
	}

	public int getPay_count() {
		return pay_count;
	}

	public void setPay_count(int pay_count) {
		this.pay_count = pay_count;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
