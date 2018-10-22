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
public class SimpleBaggageRepository implements BaggageRepository {

	private final Map<String, Long> baggage;

	public SimpleBaggageRepository() {
		baggage = new HashMap<>();
	}

	@Override
	public boolean checkIn(String baggageId, long destinationId) {
		baggage.put(baggageId, destinationId);
		return true;
	}

}
