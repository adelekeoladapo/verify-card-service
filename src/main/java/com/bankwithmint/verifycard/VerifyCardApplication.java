package com.bankwithmint.verifycard;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VerifyCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerifyCardApplication.class, args);
	}

	@Bean
	public EbeanServer store() {
		return Ebean.getDefaultServer();
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
