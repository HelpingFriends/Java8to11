package trivera.exceptions.messaging.mock;

import java.util.concurrent.atomic.LongAdder;

import trivera.exceptions.messaging.InvalidCredentialsException;
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
public class MessagingConnectionImpl implements MessagingConnection {

	private boolean transacted = false;
	private int acknowledgeMode = MessagingConnection.AUTO_ACKNOWLEDGE;
	private Integer connectionID;
	private String username;

	/**
	 * @param username
	 *            The username used to make the connection
	 * @param password
	 *            The password used to make the connection
	 * 
	 * @throws MessagingException
	 */
	public MessagingConnectionImpl(String username, String password) throws MessagingException {
		MessagingConnectionImpl.messageCounter.increment();
		if (username == null || "".equals(username.trim())) {
			throw new InvalidCredentialsException("Could not create connection (invalid username)", username);
		}

		StringBuilder pwdCheck = new StringBuilder(username).reverse();

		if (!pwdCheck.toString().equals(password)) {
			throw new InvalidCredentialsException(String.format("Invalid credentials for username %s ", username),
					username);
		}
		this.username = username;

		connectionID = messageCounter.intValue();
		registerShutdownHook();
	}

	private void registerShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				if (connectionID != null) {
					System.err.printf("Possible resource leak, Connection #%d still open!%n", connectionID);
				}
			}
		});
	}

	public void setTransacted(boolean transacted) {
		this.transacted = transacted;
	}

	public void setAcknowledgeMode(int acknowledgeMode) throws MessagingException {
		if (acknowledgeMode < 0 || acknowledgeMode > 3) {
			throw new MessagingException(String.format("Invalid acknowledgement mode %d", acknowledgeMode));
		}
		this.acknowledgeMode = acknowledgeMode;
	}

	@Override
	public void close() throws MessagingException {
		connectionID = null;
	}

	/**
	 * Obtain a messaging exception
	 * 
	 * 
	 * @return a MessagingConnection implementation
	 * @throws MessagingException
	 *             thrown when the connection cannot be established
	 */
	public MessagingSession createSession() throws MessagingException {

		MessagingSessionImpl session = new MessagingSessionImpl(this.username, this.transacted, this.acknowledgeMode,
				this.connectionID);
		session.setTransacted(transacted);
		session.setAcknowledgeMode(acknowledgeMode);
		return session;
	}

	private static LongAdder messageCounter = new LongAdder();

}
