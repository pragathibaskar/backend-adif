package com.cg.adif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages="com.cg.adif.*")
@SpringBootApplication
public class AdifApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdifApplication.class, args);
	}

}
