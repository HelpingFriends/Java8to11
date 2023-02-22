package flight.file.repository.data;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import flight.service.model.Flight;

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
public class FlightDataSource {

	public static List<Flight> getAllFlights() {
		try (InputStream is = FlightDataSource.class.getResourceAsStream("flightdata.csv");
				Stream<String> lines = new BufferedReader(new InputStreamReader(is, "UTF-8")).lines()) {

			return lines.map(FlightDataSource::createFlight).collect(toList());

		} catch (IOException e1) {
			throw new RuntimeException("could not locate data file", e1);
		}
	}

	private static Flight createFlight(String dataLine) {
		Flight flight = new Flight();
		String[] split = dataLine.split(";");
		flight.setAirlineCode(split[0]);
		flight.setFlightNumber(Integer.parseInt(split[1]));
		flight.setAirlineName(split[2]);
		flight.setDestinationCode(split[3]);
		flight.setDestinationName(split[4]);
		flight.setDepartureTime(split[5]);
		flight.setCodeShare(Boolean.parseBoolean(split[6]));
		return flight;
	}
}
