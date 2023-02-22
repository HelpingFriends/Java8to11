package threading.completablefutures.flight;

import threading.completablefutures.flight.service.EWRFlightService;
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

   private FlightService newarkFlightService = new EWRFlightService();
   private FlightService jfkFlightService = new JFKFlightService();

   public List<Flight> findFlights(String destinationCode) {
      List<Flight> flights_from_newark = newarkFlightService.getFlightsByDestination(destinationCode);
      List<Flight> flights_from_jfk = jfkFlightService.getFlightsByDestination(destinationCode);
      return combineResults(flights_from_jfk, flights_from_newark);
   }

   @SafeVarargs
   private <T> List<T> combineResults(List<T>... lists) {
      return Stream.of(lists).flatMap(List::stream).collect(toList());
   }

   public static void main(String[] args) {
      FlightApplication application = new FlightApplication();
      String destinationCode = "LAS"; // Las Vegas
      System.out.printf("Searching flights to detination code %s%n",destinationCode);
      long start = System.currentTimeMillis();
      List<Flight> results = application.findFlights("LAS");
      long end = System.currentTimeMillis();

      System.out.printf("Found for %d flights to %s%n", results.size(), destinationCode);
      System.out.printf("Call returned in approx. %d ms%n", (end - start));
   }
}
