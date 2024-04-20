package com.reservationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservationsystem.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
