package flight.jaxb.repository.data;

import java.io.InputStream;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

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
		try {
			JAXBContext jc = JAXBContext.newInstance(FlightData.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			InputStream is = FlightDataSource.class.getResourceAsStream("flightdata.xml");
			FlightData flightData = (FlightData) unmarshaller.unmarshal(is);
			return flightData.getFlights();
		} catch (JAXBException e) {
			throw new RuntimeException("Error while processing flightdata.xml file", e);
		}

	}

}
