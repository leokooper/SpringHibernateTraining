package ru.leonchenko.springdemoone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class HelloSpringApp {
    public static void main(String[] args) {
        //loading config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieving bean
        Coach theBaseballCoach = context.getBean("myBaseballCoach", Coach.class);
        Coach theTrackCoach = context.getBean("myTrackCoach", Coach.class);



        //get method from bean
        System.out.println(theBaseballCoach.getDailyWorkout());

        System.out.println(theBaseballCoach.getDailyFortune());

        System.out.println(theTrackCoach.getDailyWorkout());

        System.out.println(theTrackCoach.getDailyFortune());


        //close context
        context.close();

    }
}
