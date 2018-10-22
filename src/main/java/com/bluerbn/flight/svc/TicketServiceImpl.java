package com.bluerbn.flight.svc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bluerbn.flight.repo.TicketRepository;

/**
 * @author avim
 * @since 22/10/2018
 * @version $Id$
 */
@Service
public class TicketServiceImpl implements TicketService {

	@Resource
	private TicketRepository ticketRepository;

	@Override
	public boolean isAvailable(long id) {
		return ticketRepository.isAvailable(id);
	}

}
