package ru.leonchenko.spring.sprinthibernate.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.leonchenko.spring.sprinthibernate.entities.Author;
import ru.leonchenko.spring.sprinthibernate.entities.Book;
import ru.leonchenko.spring.sprinthibernate.entities.Genre;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select new ru.leonchenko.spring.sprinthibernate.entities.Book(b.id, b.name, b.pageCount, b.isbn, b.genre, b.author, b.publisher, b.publishYear, b.image, b.descr) from Book b")
    Page<Book> findAllWithoutContent(Pageable pageable);

    Page<Book> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);

    @Query("SELECT b.content from Book b WHERE b.id = :id")
    byte[] getContent (@Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Query("update Book b set b.content = :content where b.id = :id")
    void updateContent (@Param("content") byte[] content, @Param("id") Long id);

}
