package com.reservationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.reservationsystem.entity.Flight;
import com.reservationsystem.entity.Reservation;
import com.reservationsystem.entity.User;
import com.reservationsystem.exceptions.ResourceNotFoundException;
import com.reservationsystem.repository.FlightRepository;
import com.reservationsystem.repository.ReservationRepository;
import com.reservationsystem.repository.UserRepo;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepo userRepository;

    @PostMapping("/flights/{flightId}/reservations")
    public Reservation addReservationToFlight(@PathVariable Long flightId, @RequestBody Reservation reservation) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new ResourceNotFoundException("Flight", "FlightNumber", flightId));
        
        User user = userRepository.findById(reservation.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        reservation.setFlight(flight);
        reservation.setUser(user);
        return reservationRepository.save(reservation);
    }
    
    @GetMapping("/reservations")
    public List<Reservation> getAllReservation() {
    	
    	return reservationRepository.findAll();
    	
    }
}
