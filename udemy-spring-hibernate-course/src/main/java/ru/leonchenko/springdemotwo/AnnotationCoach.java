package ru.leonchenko.springdemotwo;


import org.springframework.stereotype.Component;

@Component
public class AnnotationCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Do 15 squats!";
    }
}
