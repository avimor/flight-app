package com.bluerbn.flight.repo;

/**
 * @author avim
 * @since 22/10/2018
 * @version $Id$
 */
public interface TicketRepository {

	boolean isAvailable(long id);

}
