package ru.leonchenko.springdemotwo;


import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class AnotherAnnotationCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Do another 15 squats!";
    }
}
