package flight.client;

import java.util.List;

import flight.service.FlightService;

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
public class Client {
	public static void main(String[] args) {
		System.out.println("Searching flights times for flights to LAX");
		FlightService service = new FlightService();
		List<String> flightsForDestination = service.getDepartureTimesForDestination("LAX");
		System.out.printf("Found %d departure times:%n", flightsForDestination.size());
		flightsForDestination.forEach(System.out::println);
	}

}
