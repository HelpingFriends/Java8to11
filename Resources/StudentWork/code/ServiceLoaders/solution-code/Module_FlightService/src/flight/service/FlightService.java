package flight.service;

import java.util.Collection;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

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
public class FlightService {

	public List<String> getDepartureTimesForDestination(String destination) {

		ServiceLoader<FlightRepository> serviceLoader = ServiceLoader.load(FlightRepository.class);

		List<String> result = serviceLoader.stream()
				.map(provider -> provider.get())
				.map(dataSource -> dataSource.getFlightsForDestination(destination))
				.flatMap(Collection::stream)
				.map(Flight::getDepartureTime)
				.distinct()
				.collect(Collectors.toList());

		return result;
	}
}
