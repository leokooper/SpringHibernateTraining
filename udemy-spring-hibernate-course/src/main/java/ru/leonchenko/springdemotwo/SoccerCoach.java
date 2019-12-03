package ru.leonchenko.springdemotwo;

import org.springframework.beans.factory.annotation.Value;

public class SoccerCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${bar.name}")
    private String name;

    @Value("${bar.team}")
    private String team;

    public SoccerCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run 3 km today!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
}
