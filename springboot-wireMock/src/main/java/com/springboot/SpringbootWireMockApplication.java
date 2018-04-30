package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.stubbing.Scenario;

@SpringBootApplication
public class SpringbootWireMockApplication extends WireMock implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWireMockApplication.class, args);
	}

	@Autowired
	private WireMockServer wireMockServer;

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		wireMockServer.start();

		stubFor(post(urlEqualTo("/wireMock")).inScenario("Post Wire Mock Services")
				.whenScenarioStateIs(Scenario.STARTED).withRequestBody(matchingJsonPath("$[?(@.name == 'john')]"))
				.withRequestBody(matchingJsonPath("$.address[?(@.city == 'london')]"))
				.willReturn(aResponse().withBodyFile("wire-mock-services-post.json")));

		stubFor(get(urlEqualTo("/wireMock")).inScenario("Get Wire Mock Services").whenScenarioStateIs(Scenario.STARTED)
				.willReturn(aResponse().withBodyFile("wire-mock-services-get.json")));
	}
}
