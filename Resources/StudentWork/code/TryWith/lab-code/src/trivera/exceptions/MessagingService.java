package trivera.exceptions;

import trivera.exceptions.messaging.MessagingConnection;
import trivera.exceptions.messaging.MessagingException;
import trivera.exceptions.messaging.MessagingSession;

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
public class MessagingService {

	public void sendMessage(String username, String password, String message) throws MessagingException {
		MessagingConnection connection = MessagingConnection.createMessagingConnection(username, password);
		MessagingSession session = connection.createSession();
		session.sendMessage(message);
		session.close();
		connection.close();
	}

}
