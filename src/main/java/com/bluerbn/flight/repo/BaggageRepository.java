package com.bluerbn.flight.repo;

/**
 * @author avim
 * @since 22/10/2018
 * @version $Id$
 */
public interface BaggageRepository {

	boolean checkIn(String baggageId, long destinationId);

}
