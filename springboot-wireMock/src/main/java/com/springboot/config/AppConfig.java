package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@Configuration
public class AppConfig {

	@Bean
	public WireMockServer wireMockServer() {
		return new WireMockServer(options().port(8080).usingFilesUnderDirectory("src/main/resources"));
	}
}
