package threading.completablefutures.flight.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import threading.completablefutures.flight.service.data.FlightDataSource;
import threading.completablefutures.flight.Flight;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera
 * Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Group, Inc.
 *
 * Copyright (c) 2023 Trivera Technologies, LLC. http://www.triveratech.com
 * 
 * </p>
 * 
 * 
 */
public class EWRFlightService implements FlightService{

	private FlightDataSource datasource = new FlightDataSource();

	public List<Flight> getFlightsByDestination(String destination) {
		return datasource.getFlightInformation("BOS", LocalDate.now()).stream()
				.filter(flight -> destination.equalsIgnoreCase(flight.getDestinationCode()))
				.collect(Collectors.toList());
	}

}
