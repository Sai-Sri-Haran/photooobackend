package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nu.pattern.OpenCV;

@SpringBootApplication
public class Image123Application {

	public static void main(String[] args) {
		SpringApplication.run(Image123Application.class, args);
//		System.out.printf("java.library.path: %s%n",
//		System.getProperty("java.library.path"));
//        System.loadLibrary("opencv_java3420");
		//OpenCV.loadShared();

	}

	@Configuration
	public class WebConfiguration implements WebMvcConfigurer {

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedMethods("*");
	    }
	}

}
