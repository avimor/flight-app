package com.bluerbn.flight.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * @author avim
 * @since 22/10/2018
 * @version $Id$
 */
@Repository
public class SimpleTicketRepository implements TicketRepository {

	private final Map<Long, Boolean> tickets;

	public SimpleTicketRepository() {
		tickets = new HashMap<>();
		tickets.put(2L, true);
		tickets.put(4L, true);
		tickets.put(6L, true);
		tickets.put(8L, true);
	}

	@Override
	public boolean isAvailable(long id) {
		return tickets.containsKey(id);
	}

}
