package com.bankwithmint.verifycard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@SpringBootApplication
public class VerifyCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerifyCardApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/card-scheme/**"))
				.apis(RequestHandlerSelectors.basePackage("com.bankwithmint.verifycard"))
				.build()
				.apiInfo(this.apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Verify Card Service",
				"API for Card Verification",
				"1.0",
				"",
				new springfox.documentation.service.Contact("Dapo Adeleke", "https://dapoadeleke.me", "adelekeoldadapo@gmail.com"),
				"API License",
				"https://dapoadeleke.me",
				Collections.emptyList()
		);
	}

}
