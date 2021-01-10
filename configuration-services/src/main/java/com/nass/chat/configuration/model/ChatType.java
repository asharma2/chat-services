package com.nass.chat.configuration.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChatType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String type;
	@Column(name = "is_active")
	Boolean active;
	@Column(name = "created_at")
	LocalDate createdAt;
	@Column(name = "updated_at")
	LocalDate updatedAt;
}
