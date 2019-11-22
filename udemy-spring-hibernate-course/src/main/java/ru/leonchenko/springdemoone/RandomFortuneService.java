package ru.leonchenko.springdemoone;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        String[] fs = {"Good job!", "Amazing result!", "You are one step closer to your dream!"};
        return (fs[new Random().nextInt(fs.length)]);
    }

}
