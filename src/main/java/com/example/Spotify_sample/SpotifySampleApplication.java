package com.example.Spotify_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.Spotify_sample")
public class SpotifySampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotifySampleApplication.class, args);
	}

}
