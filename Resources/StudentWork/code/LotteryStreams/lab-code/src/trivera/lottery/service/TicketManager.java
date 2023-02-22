package trivera.lottery.service;

import java.util.stream.Stream;

import trivera.lottery.LotteryTicket;
import trivera.lottery.LotteryTicketUtil;

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
public class TicketManager {

	public Stream<LotteryTicket> getSubSetOfLotteryTickets(String fromLetters, String untilLetters) {
		return Stream.empty();
	}

	public Stream<LotteryTicket> getLotteryTickets(String untilLetters) {
		return Stream.empty();
	}

	public Stream<LotteryTicket> getLotteryTickets() {
		LotteryTicket firstTicket = LotteryTicketUtil.getFirstTicket();
		return Stream.empty();
	}
}
