package fr.ea.abj.eattestationback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EAttestationBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EAttestationBackApplication.class, args);
	}

}
