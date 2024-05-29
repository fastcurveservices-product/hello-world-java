package com.fastcurveservices.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        // DataSourceAutoConfiguration.class,
		// DataSourceTransactionManagerAutoConfiguration.class,
		// HibernateJpaAutoConfiguration.class
})
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

}
