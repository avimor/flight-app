package com.bluerbn.flight.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * @author avim
 * @since 22/10/2018
 * @version $Id$
 */
@Component
public class EchoHandler {

	@SuppressWarnings("static-method")
	public Mono<ServerResponse> echo(ServerRequest request) {
		return ServerResponse.ok().body(request.bodyToMono(String.class), String.class);
	}

}
