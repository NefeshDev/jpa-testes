package io.github.testesspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TestesspringApplication {

	public static void main(String[] args) {

		SpringApplicationBuilder sb = new SpringApplicationBuilder(TestesspringApplication.class);
		sb.bannerMode(Mode.OFF);
		sb.run(args);
	}

}
