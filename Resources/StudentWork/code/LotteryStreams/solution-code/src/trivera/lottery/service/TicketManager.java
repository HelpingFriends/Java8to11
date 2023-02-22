package trivera.lottery.service;

import java.util.function.Predicate;
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
		return getLotteryTickets().dropWhile(ticket -> !ticket.getLetters().equals(fromLetters))
				.takeWhile(ticket -> !ticket.getLetters().equals(untilLetters));
	}

	public Stream<LotteryTicket> getLotteryTickets(String untilLetters) {
		return getLotteryTickets().takeWhile(ticket -> !ticket.getLetters().equals(untilLetters));
	}

	public Stream<LotteryTicket> getLotteryTickets() {
		LotteryTicket firstTicket = LotteryTicketUtil.getFirstTicket();
		Predicate<LotteryTicket> predicate = ticket -> !ticket.getLetters().equals("??");
		return Stream.iterate(firstTicket, predicate, LotteryTicketUtil::getNextLotteryTicket);
	}
}
