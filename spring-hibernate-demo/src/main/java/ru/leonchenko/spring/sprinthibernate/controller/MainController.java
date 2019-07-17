package ru.leonchenko.spring.sprinthibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.leonchenko.spring.sprinthibernate.entities.Author;
import ru.leonchenko.spring.sprinthibernate.entities.Genre;
import ru.leonchenko.spring.sprinthibernate.repositories.GenreRepository;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Controller
public class MainController {

    @Autowired
    private GenreRepository genreRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody String main() {

//        Genre genre = new Genre();
//        Genre genre2 = new Genre();
//
//        genre.setName("Тесторый жанр!");
//        genre2.setName("Тесторый жанр1!");
//
//        genreRepository.save(genre);
//        genreRepository.save(genre2);



        return genreRepository.getOne(3L).getName();
    }
}
