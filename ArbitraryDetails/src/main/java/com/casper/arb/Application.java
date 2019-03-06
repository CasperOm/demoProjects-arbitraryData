package com.casper.arb;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Application {

	private static final Logger logger = Logger.getLogger(Application.class.getName());
	
	public static void main(String[] args) {
		logger.info("Main application started");
		SpringApplication.run(Application.class, args);
	}

}
