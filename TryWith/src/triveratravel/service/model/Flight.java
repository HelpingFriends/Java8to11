package triveratravel.service.model;

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

public class Flight {
	private String airlineCode;
	private Integer flightNumber;
	private String airlineName;
	private String destinationCode;
	private String destinationName;
	private String departureTime;

	public Flight() {
		super();
	}

	public Flight(String airlineCode, Integer flightNumber, String airlineName, String destinationCode,
			String destinationName, String departureTime) {
		super();
		this.airlineCode = airlineCode;
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.destinationCode = destinationCode;
		this.destinationName = destinationName;
		this.departureTime = departureTime;
	}

	public String getFlightDescription() {
		return String.format("%s - %s %s", flightNumber, destinationName, departureTime);
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public Integer getNumber() {
		return flightNumber;
	}

	public String getFlightNumber() {
		return airlineCode + flightNumber;
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

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airlineCode == null) ? 0 : airlineCode.hashCode());
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
		if ((flightNumber == null && other.flightNumber != null) || !flightNumber.equals(other.flightNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlightInformation [airlineCode=" + airlineCode + ", flightNumber=" + flightNumber + ", airlineName="
				+ airlineName + ", destinationCode=" + destinationCode + ", destinationName=" + destinationName
				+ ", departureTime=" + departureTime + "]";
	}

}
