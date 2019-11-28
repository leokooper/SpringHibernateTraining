package ru.leonchenko.springdemotwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HomeworkCoach implements Coach{

    @Autowired
    @Qualifier("homeworkFortuneService")
    private FortuneService fortuneService;

    public void injectFortuneService(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "It's your dream dont't miss it!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
