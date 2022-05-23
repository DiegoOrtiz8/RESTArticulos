package com.ibm.academia.restapi.articulos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RestArticulosApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestArticulosApplication.class, args);
    }

}
