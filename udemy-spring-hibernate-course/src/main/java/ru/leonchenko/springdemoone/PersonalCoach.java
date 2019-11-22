package ru.leonchenko.springdemoone;

public class PersonalCoach implements Coach {

    private FortuneService fortuneService;

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "30 abs!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void initMethod(){
        System.out.println("Born!");
    }

    public void destroyMethod(){
        System.out.println("Dead!");
    }

}
