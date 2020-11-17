package ru.rass.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.rass.api.models.Access;

@SpringBootApplication
public class RaasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaasApiApplication.class, args);


		Access s = Access.builder()
				.setId(1L)
				.setName("Test")
				.build();

		System.out.println(s.toString());


	}

}
