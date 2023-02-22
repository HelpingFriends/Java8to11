package threading.completablefutures.flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
public class Flight implements Comparable<Flight> {
	public static final DateTimeFormatter DEPARTURETIME_FORMATTER = DateTimeFormatter.ofPattern("h:mm a");

	private String airlineCode;
	private Integer flightNumber;
	private String airlineName;
	private String destinationCode;
	private String destinationName;
	private LocalDate departureDate;
	private LocalTime departureTime;
	private boolean codeShare;

	@Override
	public int compareTo(Flight other) {
		if (other == null) {
			return 1;
		}

		Integer otherFlightNumber = other.getFlightNumber();
		if (otherFlightNumber == null)
			return 1;

		if (this.flightNumber == null)
			return -1;

		int compareTo = this.flightNumber.compareTo(otherFlightNumber);
		return compareTo;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDestinationCode() {
		return destinationCode;
	}

	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public boolean isCodeShare() {
		return codeShare;
	}

	public void setCodeShare(boolean codeShare) {
		this.codeShare = codeShare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airlineCode == null) ? 0 : airlineCode.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Flight other = (Flight) obj;
		if ((airlineCode == null && other.airlineCode != null) || !airlineCode.equals(other.airlineCode))
			return false;
		if ((departureDate == null && other.departureDate != null) || !departureDate.equals(other.departureDate))
			return false;
		if ((flightNumber == null && other.flightNumber != null) || !flightNumber.equals(other.flightNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlightInformation [airlineCode=" + airlineCode + ", flightNumber=" + flightNumber + ", airlineName="
				+ airlineName + ", destinationCode=" + destinationCode + ", destinationName=" + destinationName
				+ ", departureDate=" + departureDate + ", departureTime=" + departureTime + ", codeShare=" + codeShare
				+ "]";
	}

}
