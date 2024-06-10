package com.serverapp.ServerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class ServerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerAppApplication.class, args);
	}

}
