package ru.leonchenko.springdemotwo;

public class SadFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "Today is a sad fortune!";
    }
}
