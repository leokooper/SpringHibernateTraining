package ru.leonchenko.spring.sprinthibernate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.leonchenko.spring.sprinthibernate"})
public class ServletInitializer extends SpringBootServletInitializer {

    }

