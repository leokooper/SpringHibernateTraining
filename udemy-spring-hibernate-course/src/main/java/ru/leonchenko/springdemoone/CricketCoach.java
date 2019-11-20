package ru.leonchenko.springdemoone;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;

    private String emailAddress;

    private String name;

    public void setEmailAddress(String emailAddress) {
        System.out.println("Inside setEmailAddress method");
        this.emailAddress = emailAddress;
    }

    public void setName(String name) {
        System.out.println("Inside setName method");
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public CricketCoach(){
        System.out.println("No-args constructor!");
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Inside setter method!");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 mins a day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
