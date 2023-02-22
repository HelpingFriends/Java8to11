package trivera.exceptions.messaging.mock;

import java.time.LocalDateTime;

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
@SuppressWarnings("unused")
public class MessagingSessionImpl implements MessagingSession {
	private boolean transacted = false;
	private int acknowledgeMode = MessagingConnection.AUTO_ACKNOWLEDGE;
	private String username;
	private Integer sessionID;

	public MessagingSessionImpl(String username, boolean transacted, int acknowledgeMode, int connectionID)
			throws InvalidCredentialsException {
		this.username = username;
		this.sessionID = connectionID;
		if (username.length() < 4) {
			throw new InvalidCredentialsException("Could not create Session (insufficient security permissions)", username);
		}
		registerShutdownHook();
	}

	private void registerShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				if (sessionID != null) {
					System.err.printf("Possible resource leak, Session #%d still open!%n", sessionID);
				}
			}
		});
	}

	public void setTransacted(boolean transacted) {
		this.transacted = transacted;
	}

	public void setAcknowledgeMode(int acknowledgeMode) throws MessagingException {
		this.acknowledgeMode = acknowledgeMode;
	}

	@Override
	public void close() throws MessagingException {
		sessionID = null;
	}

	@Override
	public void sendMessage(String message) throws MessagingException {
		if (message == null || message.length() < 12) {
			throw new MessagingException("Could not send message (invalid message format)");
		}
		System.out.printf("%1$s (%2$tD %2$tR) : %3$s%n", username, LocalDateTime.now(), message);

	}

}
