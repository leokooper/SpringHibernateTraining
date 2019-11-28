package ru.leonchenko.springdemotwo;


import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@Component
public class HomeworkFortuneService implements FortuneService {

    private Random random = new Random();

    @Override
    public String getFortune() {

        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/fortunes.txt"))) {
            while (br.ready()) {
                result.add(br.readLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int idx = random.nextInt(result.size());

        return result.get(idx);
    }
}
