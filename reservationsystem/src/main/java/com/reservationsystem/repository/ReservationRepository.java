package com.reservationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservationsystem.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
