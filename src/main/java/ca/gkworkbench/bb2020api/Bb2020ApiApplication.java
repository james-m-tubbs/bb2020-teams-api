package ca.gkworkbench.bb2020api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

import static java.util.Collections.singletonList;

@SpringBootApplication
@EnableSwagger2
public class Bb2020ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Bb2020ApiApplication.class, args);
	}

	/**
	 ******************************
	 * Swagger Config
	 ******************************
	 */
	@Bean
	public Docket bb2020api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/");
	}
}
