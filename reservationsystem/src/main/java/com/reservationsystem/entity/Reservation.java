package com.reservationsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long bookingId;
	private String reservation;

	@ManyToOne
	@JoinColumn(name = "flightNumber")
	private Flight flight;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User user;

}
