package ru.leonchenko.spring.sprinthibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.leonchenko.spring.sprinthibernate.dao.impl.AuthorService;
import ru.leonchenko.spring.sprinthibernate.entities.Author;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@RestController
public class RestAuthor {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/authors")
    public List<Author> getAuthors() {
        return authorService.getAll();
    }

    @RequestMapping("/search")
    public List<Author> search(@RequestParam("fio") String fio) {
        return authorService.search(fio);
    }

    @RequestMapping("/pagesearch")
    public List<Author> searchPage(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize, @RequestParam("fio") String fio){
        return authorService.search(pageNumber, pageSize, "fio", Sort.Direction.ASC, fio).getContent();
    }




}
