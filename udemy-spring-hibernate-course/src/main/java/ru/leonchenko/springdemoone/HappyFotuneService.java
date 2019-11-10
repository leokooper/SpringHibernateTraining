package ru.leonchenko.springdemoone;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class HappyFotuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
