package fr.ea.abj.eattestationback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
public class EAttestationBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EAttestationBackApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**")
						.allowedMethods(HttpMethod.PUT.name(),
								HttpMethod.POST.name(),
								HttpMethod.GET.name(),
								HttpMethod.DELETE.name())
						.allowedOrigins("http://localhost:8080", "http://localhost:4200", "http://localhost:3000/");

			}
		};
	}
}
