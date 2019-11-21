package ru.leonchenko.springdemoone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {
    public static void main(String[] args) {
        //load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifecycleApplicationContext.xml");

        //retrieve bean from context

        Coach theCoach = context.getBean("myTrackCoach", Coach.class);

        //execute method from bean

        System.out.println(theCoach.getDailyWorkout());

        //close the context

        context.close();

    }
}
