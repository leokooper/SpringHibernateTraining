package ru.leonchenko.spring.sprinthibernate.dao;

import ru.leonchenko.spring.sprinthibernate.entities.Book;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface BookDao extends GeneralDao<Book> {
    byte[] getContent(long id);
}
