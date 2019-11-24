package ru.leonchenko.springdemotwo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        System.out.println(">> Inside getFortune method");
        return "Today is your lucky day!";
    }


}
