package ru.leonchenko.springdemoone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {

        //load context
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve the mean
        CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

        //use methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        System.out.printf(theCoach.getEmailAddress());
        System.out.printf(theCoach.getName());

        //close context
        context.close();
    }
}
