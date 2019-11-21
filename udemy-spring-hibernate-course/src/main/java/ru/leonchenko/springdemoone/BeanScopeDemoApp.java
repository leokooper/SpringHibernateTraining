package ru.leonchenko.springdemoone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        //load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifecycleApplicationContext.xml");

        //retrieve bean from context

        Coach firstCoach = context.getBean("myTrackCoach", Coach.class);

        Coach secondCoach = context.getBean("myTrackCoach", Coach.class);

        //compare objects

        boolean result = (firstCoach == secondCoach);

        System.out.println("\nAre objects equals: " + result);

        System.out.println("\nMemory location of: " + firstCoach);

        System.out.println("\nMemory location of: " + secondCoach);


        //close the context

        context.close();

    }
}
