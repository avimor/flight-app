package com.bluerbn.flight.rest;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluerbn.flight.svc.BaggageService;

/**
 * @author avim
 * @since 22/10/2018
 * @version $Id$
 */
@RestController
public class BaggageController {

	private static final Logger log = LoggerFactory.getLogger(BaggageController.class);

	@Resource
	private BaggageService baggageService;

	@PutMapping("/baggage/{id}")
	public boolean checkIn(@PathVariable String id, @RequestBody long dest) {
		log.info("Got request: {} to {}", id, dest);
		return baggageService.checkIn(id, dest);
	}

}
