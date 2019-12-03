package ru.leonchenko.springdemotwo;

public class InsaneFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Train 6 hours a day!";
    }
}
