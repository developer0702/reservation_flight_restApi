package com.reservationsystem.service;

import java.util.List;

import com.reservationsystem.dto.FlightUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservationsystem.entity.Flight;
import com.reservationsystem.exceptions.ResourceNotFoundException;
import com.reservationsystem.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;


	@Override
	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	@Override
	public Flight getFlightById(Long id) {
		return flightRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Flight", "FlightNumber", id));
	}

	@Override
	public Flight createFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public Flight updateFlight( FlightUpdateRequestDto flightdto) {
		Flight existingFlight = flightRepository.findById(flightdto.getFlightNumber())
				.orElseThrow(() -> new ResourceNotFoundException("Flight", "FlightNumber", flightdto.getFlightNumber()));

		existingFlight.setFlightNumber(flightdto.getFlightNumber());
		existingFlight.setOperatingAirlines(flightdto.getOperatingAirlines());
		existingFlight.setDepartureCity(flightdto.getDepartureCity());
		existingFlight.setArrivalCity(flightdto.getArrivalCity());
		existingFlight.setDateOfDeparture(flightdto.getDateOfDeparture());
		existingFlight.setEstimatedDepartureTime(flightdto.getEstimatedDepartureTime());
		return flightRepository.save(existingFlight);
	}

	@Override
	public void deleteFlight(Long id) {
		Flight flight = this.flightRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Flight", "FlightId", id));
		this.flightRepository.delete(flight);
	}
}
