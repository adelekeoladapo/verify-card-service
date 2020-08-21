package com.bankwithmint.verifycard;

import com.bankwithmint.verifycard.dto.CardDto;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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
