package ru.leonchenko.springdemotwo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SoccerJavaConfigApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        SoccerCoach theCoach = context.getBean("soccerCoach", SoccerCoach.class);

        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getName());
        System.out.println(theCoach.getTeam());

        context.close();
    }
}
