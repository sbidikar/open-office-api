package com.uncc.ssdi.openofficeapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Open Office API", version = "1.0", description = "Open Office Info"))
public class OpenOfficeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenOfficeApiApplication.class, args);
	}

}
