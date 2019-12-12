package com.swap.ImportJarTwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"com.swap.ImportJarTwo.integration.repository","com.swap.ImportJarOne.integration.repository"})
//@EntityScan(basePackages = {"com.swap.ImportJarTwo.integration.domain","com.swap.ImportJarOne.integration.domain"})
@ComponentScan(basePackages = {"com.swap.ImportJarTwo.**","com.swap.ImportJarOne.**"})
public class Application {
	
	public static void main(String args[]) {
	    SpringApplication.run(Application.class);
	}

}
