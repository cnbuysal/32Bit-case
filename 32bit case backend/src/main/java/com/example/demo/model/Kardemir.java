package com.example.demo.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Kardemir {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length=10, nullable=false)
	private Long id;
	
	@Column(length=1)
	private int active;
	
	@Column(length = 255)
	private String createdUser;
	
	private Instant createdDate;
	
	@Column(length = 255)
	private String kardemir1;
	
	@Column(length=255)
	private int kardemir2;
	
	@Column(length=255)
	private float kardemir3;
	
	@Column(length = 255)
	private String updatedUser;
	
	private Instant updatedDate;
	
	@Column(length = 255)
	private String customerId;
	
	@Column(length = 255)
	private String dop;
	
	@Column(length = 255)
	private String heatNo;
	
	@Column(length = 255)
	private String labelNo;
	
	@Column(length = 255)
	private String length;
	
	@Column(length = 255)
	private String product;
	
	@Column(length = 255)
	private String quality;
	
	@Column(length = 255)
	private String quantity;
	
	@Column(length = 255)
	private String weight;
	
	@Column(length = 255)
	private String buMessageTimePB;
	
}
