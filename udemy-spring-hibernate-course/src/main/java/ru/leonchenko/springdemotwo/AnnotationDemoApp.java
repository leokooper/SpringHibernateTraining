package ru.leonchenko.springdemotwo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        //read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");

        //retrieve bean from container
        AnnotationCoach theCoach = context.getBean("annotationCoach", AnnotationCoach.class);
//        Coach theAnotherCoach = context.getBean("thatSillyCoach",Coach.class);
        //retrieving the bean from context of HomeworkCoach class
//        Coach hwc = context.getBean("homeworkCoach", Coach.class);

        //call bean methods
        System.out.println(theCoach.getDailyWorkout());
//        System.out.println(theAnotherCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

//        System.out.println(theCoach.getName());
//        System.out.println(theCoach.getEmail());

        //calling methods of HWC
//        System.out.println(hwc.getDailyWorkout());
//        System.out.println(hwc.getDailyFortune());

        //close context
        context.close();

    }
}
