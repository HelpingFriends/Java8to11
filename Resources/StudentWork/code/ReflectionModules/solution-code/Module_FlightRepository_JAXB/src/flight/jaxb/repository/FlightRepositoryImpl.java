package flight.jaxb.repository;

import java.util.List;
import java.util.stream.Collectors;

import flight.jaxb.repository.data.FlightDataSource;
import flight.service.model.Flight;
import flight.service.model.FlightRepository;

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
public class FlightRepositoryImpl implements FlightRepository {

	@Override
	public List<Flight> getFlightsForDestination(String destinationCode) {
		List<Flight> allFlights = FlightDataSource.getAllFlights();
		return allFlights.stream().filter(flight -> flight.getDestinationCode().equals(destinationCode))
				.collect(Collectors.toList());

	}

}
