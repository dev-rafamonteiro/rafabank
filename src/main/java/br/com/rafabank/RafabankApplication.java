package br.com.rafabank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.com.rafabank"})
public class RafabankApplication {

	public static void main(String[] args) {
		SpringApplication.run(RafabankApplication.class, args);
	}

}
