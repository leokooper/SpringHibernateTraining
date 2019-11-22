package ru.leonchenko.springdemoone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {

        //load context
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve the mean
        CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

        Coach personalCoachProto = context.getBean("myPersonalCoachPrototype", Coach.class);

        Coach anotherPersonalCoachProto = context.getBean("myPersonalCoachPrototype", Coach.class);

        Coach personalCoachSing = context.getBean("myPersonalCoachSingleton", Coach.class);

        Coach anotherPersonalCoachSing = context.getBean("myPersonalCoachSingleton", Coach.class);

        //use methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        System.out.printf(theCoach.getEmailAddress());
        System.out.println(theCoach.getName());

        System.out.println(personalCoachSing.getDailyWorkout());
        System.out.println(personalCoachSing.getDailyFortune());
        System.out.println(personalCoachSing.getDailyFortune());
        System.out.println(personalCoachSing.getDailyFortune());

        System.out.println(personalCoachSing == anotherPersonalCoachSing);

        System.out.println(personalCoachProto == anotherPersonalCoachProto);

        System.out.println(personalCoachSing.getDailyFortune());

        //close context
        context.close();
    }
}
