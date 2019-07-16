package ru.leonchenko.spring.sprinthibernate.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.leonchenko.spring.sprinthibernate.entities.Author;
import ru.leonchenko.spring.sprinthibernate.entities.Genre;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */


@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findByNameContainingIgnoreCaseOrderByName(String name);
    Page<Genre> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);

}
