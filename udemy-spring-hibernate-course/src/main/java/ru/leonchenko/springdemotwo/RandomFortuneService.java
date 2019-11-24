package ru.leonchenko.springdemotwo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {


    //create an array of strings
    private String[] data = {"Good job!", "Amazing result!", "You are one step closer to your dream!"};

    //create a random number with Random class
    private Random random = new Random();

    @Override
    public String getFortune() {

        //pick a random index from an array
        int idx = random.nextInt(data.length);

        //return random string
        return data[idx];
    }

}
