package com.example.demo.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KardemirDto {

	private Long id;
	private int active;
	private Instant createdDate;
	private String createdUser;
	private Instant updatedDate;
	private String updatedUser;
	private String kardemir1;
	private int kardemir2;
	private float kardemir3;
	private String customerId;
	private String dop;
	private String heatNo;
	private String labelNo;
	private String length;
	private String product;
	private String quality;
	private String quantity;
	private String weight;
	private String buMessageTimePB;
}
