package com.bluerbn.flight.rest;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bluerbn.flight.svc.TicketService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author avim
 * @since 22/10/2018
 * @version $Id$
 */
@RestController
public class TicketController {

	private static final Logger log = LoggerFactory.getLogger(TicketController.class);
	protected static final String TICKET_PATH = "/ticket";

	@Resource
	private TicketService ticketService;

	@GetMapping("/")
	@SuppressWarnings("static-method")
	public String welcome() {
		return "Hello World";
	}

	@GetMapping("/ticket/{id}")
	public boolean isAvailable(@PathVariable long id) {
		log.info("Got request: {}", id);
		return ticketService.isAvailable(id);
	}

}
