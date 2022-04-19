package com.bits.dbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.bits.dbms"})
public class CourierApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourierApplication.class, args);
	}

}
