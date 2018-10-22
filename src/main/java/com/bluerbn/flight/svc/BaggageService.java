package com.bluerbn.flight.svc;

/**
 * @author avim
 * @since 22/10/2018
 * @version $Id$
 */
public interface BaggageService {

	boolean checkIn(String baggageId, long destinationId);

}
