package com.bluerbn.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.bluerbn.flight.rest.EchoHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author avim
 * @since 22/10/2018
 * @version $Id$
 */
@SpringBootApplication
public class FlightServer {

	public static void main(String[] args) {
		SpringApplication.run(FlightServer.class);
	}

	@Bean
	@SuppressWarnings("static-method")
	public RouterFunction<ServerResponse> monoRouterFunction(EchoHandler echoHandler) {
		return route(POST("/echo"), echoHandler::echo);
	}

}
