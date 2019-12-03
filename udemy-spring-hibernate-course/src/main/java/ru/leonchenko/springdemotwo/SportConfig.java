package ru.leonchenko.springdemotwo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("ru.leonchenko.springdemotwo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public SwimCoach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }

    @Bean
    public FortuneService insaneFortuneService() {
        return new InsaneFortuneService();
    }

    @Bean SoccerCoach soccerCoach() {
        return new SoccerCoach(insaneFortuneService());
    }

}
