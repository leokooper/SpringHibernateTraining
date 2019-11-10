package ru.leonchenko.springdemoone;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public TrackCoach() {

    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5K";
    }

    @Override
    public String getDailyFortune() {
        return "Just Do It: " + fortuneService.getFortune();
    }
}
