package ru.leonchenko.springdemotwo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        //download config file
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContextAnnotations.xml");

        //retrieve bean from context
        Coach coach = context.getBean("annotationCoach", Coach.class);

        Coach annotationCoach = context.getBean("annotationCoach", Coach.class);

        //resolve bean's method
        boolean result = (coach == annotationCoach);
        System.out.println("They are pointing to the same objects: " + result);

        System.out.println("Memory location of a coach object: " + coach);

        System.out.println("Memory location of a annotationCoach object: " + annotationCoach);

        //close context
        context.close();
    }
}
