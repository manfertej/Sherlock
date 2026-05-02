package dev.manfertej.sherlock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SherlockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SherlockApplication.class, args);
	}

}
