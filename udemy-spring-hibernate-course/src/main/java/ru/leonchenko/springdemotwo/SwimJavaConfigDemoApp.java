package ru.leonchenko.springdemotwo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        //read spring config file class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        //retrieve bean from container
        Coach theCoach = context.getBean("swimCoach", Coach.class);

        SwimCoach theSwimCoach = context.getBean("swimCoach", SwimCoach.class);


        //call bean methods
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        //call value methods
        System.out.println(theSwimCoach.getEmail());
        System.out.println(theSwimCoach.getTeam());


        context.close();

    }
}
