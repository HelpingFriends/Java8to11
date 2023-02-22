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
public class LotteryTicketUtil {

	public static LotteryTicket getFirstTicket() {
		return getNextLotteryTicket(null);
	}

	public static LotteryTicket getNextLotteryTicket(LotteryTicket currentTicket) {
		if (currentTicket == null) {
			return new LotteryTicket("AA", 0);
		}
		int nextNumber = currentTicket.number + 1;
		if (nextNumber <= 9999) {
			return new LotteryTicket(currentTicket.letters, nextNumber);
		}
		nextNumber = 0;
		char[] letters = currentTicket.letters.toCharArray();
		letters[1] = ++letters[1];
		if (letters[0] == '?') {
			return new LotteryTicket(currentTicket.letters, nextNumber);
		}
		if (letters[1] > 'Z') {
			letters[1] = 'A';
			letters[0] = ++letters[0];
			if (letters[0] > 'Z') {
				letters[1] = '?';
				letters[0] = '?';
			}
		}
		return new LotteryTicket(new String(letters), nextNumber);
	}

}
