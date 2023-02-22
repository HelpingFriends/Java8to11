package triveratravel.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import triveratravel.service.model.FlightRepository;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC., Worldwide
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Technologies, LLC.
 *
 * Copyright (c) 2023 Trivera Technologies, LLC. http://www.triveratech.com
 * </p>
 * 
 * 
 */

public class RepositoryClient {

	public void listFlights(String... destinationCodes) {
		var repository = FlightRepository.getDefaultInstance();

		var flights = repository.getFlightsForDestination(destinationCodes);


		for (var i = 0; i < flights.length; i++) {
			var flight = flights[i];
			var description = flight.getFlightDescription();

			var flightString = String.format("%d) %s", i, description);
			System.out.println(flightString);
		
		}
		
	}

	public static void main(String[] args) {
		RepositoryClient client = new RepositoryClient();
		 client.listFlights("ORD","LAX", "LAS", "SFO");
	}

}
