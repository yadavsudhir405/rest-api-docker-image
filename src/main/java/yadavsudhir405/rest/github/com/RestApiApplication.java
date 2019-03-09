package yadavsudhir405.rest.github.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class RestApiApplication  {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
		LOGGER.info("Application Started");
	}


}

