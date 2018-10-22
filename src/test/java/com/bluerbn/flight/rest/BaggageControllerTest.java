package com.bluerbn.flight.rest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Mono;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.TEXT_PLAIN;

/**
 * @author avim
 * @since 22/10/2018
 * @version $Id$
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class BaggageControllerTest {

	@Resource
	private WebTestClient webClient;

	@Test
	public void testCheckIn() {
		this.webClient.put().uri("/baggage/1").body(Mono.just(1L), Long.class).exchange().expectStatus().isOk().expectBody(Boolean.class)
			.isEqualTo(true);
	}

}
