package com.msvc.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaServer
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
