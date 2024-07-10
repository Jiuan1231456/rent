package com.example.rent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "photo")
public class Photo {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ai")
	private int ai;

	@Column(name = "photo")
	private byte[] photo;

	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Photo(int ai, byte[] photo) {
		super();
		this.ai = ai;
		this.photo = photo;
	}

	public int getAi() {
		return ai;
	}

	public void setAi(int ai) {
		this.ai = ai;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
