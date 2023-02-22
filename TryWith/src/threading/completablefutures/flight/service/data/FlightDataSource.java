package threading.completablefutures.flight.service.data;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class FlightDataSource {

	public List<Flight> getFlightInformation(String departureLocation, LocalDate date) {
		List<Flight> flights;
		Path path;
		try {
			URI uri = FlightDataSource.class.getResource("flightdata.csv").toURI();
			path = Paths.get(uri);
		} catch (URISyntaxException e1) {
			throw new RuntimeException("could not locate data file", e1);
		}

		try (Stream<String> lines = Files.lines(path);) {
			flights = lines.map(line -> createFlight(line)).map(flight -> {
				flight.setDepartureDate(date);
				return flight;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			throw new RuntimeException("Error reading data file", e);
		}

		// simulate slow service
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return flights;
	}

	/**
	 * Convert ; separated line into Flight object
	 *
	 * @param line the line to parse
	 * @return Flight instance
	 */
	private Flight createFlight(String line) {
		String[] split = line.split(";");
		Flight data = new Flight();

		data.setAirlineCode(split[0]);
		data.setFlightNumber(Integer.parseInt(split[1]));
		data.setAirlineName(split[2]);
		data.setDestinationCode(split[3]);
		data.setDestinationName(split[4]);
		data.setDepartureTime(LocalTime.parse(split[5], Flight.DEPARTURETIME_FORMATTER));
		data.setCodeShare(Boolean.parseBoolean(split[6]));

		return data;
	}

}
