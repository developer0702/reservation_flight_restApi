package com.reservationsystem.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data

public class FlightUpdateRequestDto {

    private Long flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    private Date dateOfDeparture;
    private Timestamp estimatedDepartureTime;
}

