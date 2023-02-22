package trivera.exceptions;

import trivera.exceptions.messaging.MessagingException;

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
public class MessagingClient {

	public static void main(String[] args) {
		MessagingService service = new MessagingService();
		try {
			service.sendMessage("Diego", "ogeiD", "Valid Credentials, Valid message");
		} catch (MessagingException e) {
			System.err.printf("Error sending message for Diego -> %s%n", e.getMessage());
		}
		try {
			service.sendMessage("Manfred", "123", "This is an invalid password, unable to make a connection");
		} catch (MessagingException e) {
			System.err.printf("Error sending message for Manfred -> %s%n", e.getMessage());
		}
		try {
			service.sendMessage("Scratt", "ttarcS", "Invalid msg");
		} catch (MessagingException e) {
			System.err.printf("Error sending message for Scratt -> %s%n", e.getMessage());
		}
		try {
			service.sendMessage("Sid", "diS", "insufficient security permissions");
		} catch (MessagingException e) {
			System.err.printf("Error sending message for Sid -> %s%n", e.getMessage());
		}
	}

}
