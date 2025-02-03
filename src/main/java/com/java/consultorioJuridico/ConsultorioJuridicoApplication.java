package com.java.consultorioJuridico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.java.consultorioJuridico") 
public class ConsultorioJuridicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultorioJuridicoApplication.class, args);
	}

}
