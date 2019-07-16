package ru.leonchenko.spring.sprinthibernate.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.leonchenko.spring.sprinthibernate.entities.Author;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByFioContainingIgnoreCaseOrderByFio(String fio);
    Page<Author> findByFioContainingIgnoreCaseOrderByFio(String fio, Pageable pageable);

}
