package trivera.exceptions.messaging;

import trivera.exceptions.messaging.mock.MessagingConnectionImpl;

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
public interface MessagingConnection extends AutoCloseable {

	public static final int AUTO_ACKNOWLEDGE = 1;
	public static final int CLIENT_ACKNOWLEDGE = 2;
	public static final int DUPS_OK_ACKNOWLEDGE = 3;

	/**
	 * Factory method for obtaining implementation of this interface
	 * 
	 * @return instance of MessagingConnection interface
	 */
	static MessagingConnection createMessagingConnection(String username, String password) throws MessagingException {
		return new MessagingConnectionImpl(username, password);
	}

	/**
	 * Defines whether or not the message should be send within a transaction
	 * 
	 * @param transacted
	 *            boolean value
	 */
	void setTransacted(boolean transacted);

	/**
	 * Set the messaging acknowledgement mode
	 * 
	 * @param acknowledgeMode
	 *            The acknowledge mode
	 * @throws MessagingException
	 *             Thrown when an invalid acknowledgement mode is defined
	 */
	void setAcknowledgeMode(int acknowledgeMode) throws MessagingException;

	/**
	 * Obtain a messaging exception
	 * 
	 * @return a MessagingConnection implementation
	 * @throws MessagingException
	 *             thrown when the connection cannot be established
	 */
	MessagingSession createSession() throws MessagingException;

	/**
	 * Close the connection
	 * 
	 * @throws MessagingException
	 *             thrown when connection can not be closed
	 */
	void close() throws MessagingException;

}
