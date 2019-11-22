package ru.leonchenko.springdemotwo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        //read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");

        //retrieve bean from container
        Coach theCoach = context.getBean("annotationCoach",Coach.class);
        Coach theAnotherCoach = context.getBean("thatSillyCoach",Coach.class);

        //call bean methods
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theAnotherCoach.getDailyWorkout());
        
        //close conntext
        context.close();

    }
}
