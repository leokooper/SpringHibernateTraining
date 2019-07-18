package ru.leonchenko.spring.sprinthibernate.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.leonchenko.spring.sprinthibernate.dao.BookDao;
import ru.leonchenko.spring.sprinthibernate.entities.Book;
import ru.leonchenko.spring.sprinthibernate.repositories.BookRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Service
@Transactional
public class BookService implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        bookRepository.save(book);

        if (book.getContent()!=null) {
            bookRepository.updateContent(book.getContent(), book.getId());
        }
        return book;
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }


    @Override
    public Book get(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public byte[] getContent(long id) {
        return bookRepository.getContent(id);
    }

    @Override
    public List<Book> search(String... searchString) {
        return null;
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return bookRepository.findAllWithoutContent(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return bookRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

}
