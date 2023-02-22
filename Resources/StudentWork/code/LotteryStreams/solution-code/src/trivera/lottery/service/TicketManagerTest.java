package trivera.lottery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import trivera.lottery.LotteryTicket;

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
class TicketManagerTest {

	private TicketManager ticketManager = new TicketManager();

	@Test
	void test() {
		Stream<LotteryTicket> lotteryTickets = ticketManager.getLotteryTickets("AC");
		long numberOfTickets = lotteryTickets.count();
		assertEquals(20000L, numberOfTickets);
	}

	@Test
	void test2() {
		Stream<LotteryTicket> lotteryTickets = ticketManager.getSubSetOfLotteryTickets("BA", "BC");
		long numberOfTickets = lotteryTickets.count();
		assertEquals(20000L, numberOfTickets);
	}

	@Test
	void test3() {
		Stream<LotteryTicket> lotteryTickets = ticketManager.getSubSetOfLotteryTickets("ZZ", "ZZZ");
		long numberOfTickets = lotteryTickets.count();
		assertEquals(10000L, numberOfTickets);

	}
}
