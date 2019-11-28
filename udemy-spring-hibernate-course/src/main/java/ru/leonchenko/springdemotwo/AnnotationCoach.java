package ru.leonchenko.springdemotwo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class AnnotationCoach implements Coach {

    //field injection
//    @Autowired
//    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @PostConstruct
    void doMyStartupStuff(){
        System.out.println("Method after start!");
    }

    @PreDestroy
    void doMyDestroyStuff(){
        System.out.println("Method before destruction!");
    }

    @Value("${prop.emailAddress}")
    private String email;

    @Value("${prop.name}")
    private String name;

    public AnnotationCoach(){
        System.out.println(">> Inside default constructor");
    }

    //constructor injection
    @Autowired
    public AnnotationCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println("Creating new constructor");
    }

    //setter injection
//    @Autowired
//    public void setFortuneService(FortuneService fortuneService){
//        this.fortuneService = fortuneService;
//    }

    //any method injection
//    @Autowired
//    public void anyMethodNameInjection(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//        System.out.println(">> Inside anyMethodNameInjection!");
//    }

    @Override
    public String getDailyWorkout() {
        return "Do 15 squats!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
