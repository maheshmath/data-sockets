package com.codebytes.datadive.datasockets;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DataSocketsApplication {

	public static void main(String[] args) {
		System.out.println("Inside SpringBoot Main");
		new SpringApplicationBuilder(DataSocketsApplication.class).profiles("dev")
		.run(args);
	}

	@Component
	class MyRunner implements CommandLineRunner {

		@Autowired
		private Environment environment;

		@Override
		public void run(String... args) throws Exception {

			System.out.println("Active profiles: " +
					Arrays.toString(environment.getActiveProfiles()));
		}
	}

	@Component
	@Profile(value="dev")
	class MyRunner2 implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {

			System.out.println("In development");
		}
	}

	@Component
	@Profile(value="prod")
	class MyRunner3 implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {

			System.out.println("In production");
		}
	}

	@Bean
    public Docket productApi() {
      return new Docket(DocumentationType.SWAGGER_2).select()
         .apis(RequestHandlerSelectors.basePackage("com.tutorialspoint.swaggerdemo")).build();
   }
}
