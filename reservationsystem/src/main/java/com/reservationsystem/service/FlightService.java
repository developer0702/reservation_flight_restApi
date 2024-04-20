package com.reservationsystem.service;

import com.reservationsystem.dto.FlightUpdateRequestDto;
import com.reservationsystem.entity.Flight;

import java.util.List;

public interface FlightService {
	List<Flight> getAllFlights();

	Flight getFlightById(Long id);

	Flight createFlight(Flight flight);


	void deleteFlight(Long id);

	Flight updateFlight(FlightUpdateRequestDto flightdto);
}
