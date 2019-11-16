package com.emmanuel.ejeds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class EmmaEjedegba {

	public static void main(String[] args) {
		SpringApplication.run(EmmaEjedegba.class, args);
	}

}
