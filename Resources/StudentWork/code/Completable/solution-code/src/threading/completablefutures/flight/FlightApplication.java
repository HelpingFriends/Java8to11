package threading.completablefutures.flight;

import threading.completablefutures.flight.service.EWRFlightService;
import threading.completablefutures.flight.service.FlightCompletable;
import threading.completablefutures.flight.service.FlightService;
import threading.completablefutures.flight.service.JFKFlightService;

import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera
 * Technologies
 * <p>
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Group, Inc.
 * <p>
 * Copyright (c) 2023 Trivera Technologies, LLC. http://www.triveratech.com
 *
 * </p>
 *
 * 
 */
public class FlightApplication {

	private FlightService nerwarkFlightService = new EWRFlightService();
	private FlightService jfkFlightService = new JFKFlightService();

	public CompletableFuture<List<Flight>> findFlights(String destinationCode) {

		Supplier<List<Flight>> ewrCallable = () -> nerwarkFlightService.getFlightsByDestination(destinationCode);

		Supplier<List<Flight>> jfkCallable = () -> jfkFlightService.getFlightsByDestination(destinationCode);

		FlightCompletable ewrFuture = new FlightCompletable();
		ewrFuture.completeAsync(ewrCallable);

		FlightCompletable jfkFuture = new FlightCompletable();
		jfkFuture.completeAsync(jfkCallable);

		CompletableFuture<List<Flight>> results = ewrFuture.thenCombine(jfkFuture,
				(list1, list2) -> combineResults(list1, list2));
		System.out.println(results.getClass());
		return results;

	}

	@SafeVarargs
	private <T> List<T> combineResults(List<T>... lists) {
		return Stream.of(lists).flatMap(List::stream).collect(toList());
	}

	public static void main(String[] args) {
		FlightApplication application = new FlightApplication();
		String destinationCode = "LAS"; // Las Vegas
		System.out.printf("Searching flights to detination code %s%n", destinationCode);
		long start = System.currentTimeMillis();
		CompletableFuture<List<Flight>> results = application.findFlights("LAS");
		results.thenAccept(flights -> {
			System.out.printf("Found %d flights to %s%n", flights.size(), destinationCode);

		});

		long end = System.currentTimeMillis();

		System.out.printf("Call returned in approx. %d ms%n", (end - start));
	}
}
