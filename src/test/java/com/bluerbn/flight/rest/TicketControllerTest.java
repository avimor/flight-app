package com.bluerbn.flight.rest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Mono;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.MediaType.TEXT_PLAIN;

/**
 * @author avim
 * @since 22/10/2018
 * @version $Id$
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class TicketControllerTest {

	@Resource
	private WebTestClient webClient;

	@Test
	public void testWelcome() {
		this.webClient.get().uri("/").accept(TEXT_PLAIN).exchange().expectBody(String.class).isEqualTo("Hello World");
	}

	@Test
	public void testEcho() {
		this.webClient.post().uri("/echo").contentType(TEXT_PLAIN).accept(TEXT_PLAIN).body(Mono.just("Hello WebFlux!"), String.class).exchange().expectBody(String.class)
			.isEqualTo("Hello WebFlux!");
	}

	@Test
	public void testActuatorStatus() {
		this.webClient.get().uri("/actuator/health").accept(APPLICATION_JSON_UTF8).exchange().expectStatus().isOk().expectBody().json("{\"status\":\"UP\"}");
	}

	@Test
	public void testIsAvailable() {
		this.webClient.get().uri("/ticket/1").exchange().expectStatus().isOk().expectBody(Boolean.class).isEqualTo(false);
		this.webClient.get().uri("/ticket/2").exchange().expectStatus().isOk().expectBody(Boolean.class).isEqualTo(true);
		this.webClient.get().uri("/ticket/3").exchange().expectStatus().isOk().expectBody(Boolean.class).isEqualTo(false);
		this.webClient.get().uri("/ticket/4").exchange().expectStatus().isOk().expectBody(Boolean.class).isEqualTo(true);
	}

}
