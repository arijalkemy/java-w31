package com.bootcamp.be_java_hisp_w31_g09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BeJavaHispW31G09Application {

	public static void main(String[] args) {
		SpringApplication.run(BeJavaHispW31G09Application.class, args);
	}

}
