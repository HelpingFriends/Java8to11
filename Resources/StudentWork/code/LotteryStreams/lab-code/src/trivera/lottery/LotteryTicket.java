package trivera.lottery;

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
public class LotteryTicket {

	protected String letters;
	protected int number;

	public LotteryTicket(String letters, int number) {
		super();
		this.letters = letters;
		this.number = number;
	}

	public String getLetters() {
		return letters;
	}

	public String getNumber() {
		return String.format("%04d", number);
	}

	public String getTicketNumber() {
		return String.format("%s%04d", letters, number);
	}

	public String toString() {
		return getTicketNumber();
	}
}
