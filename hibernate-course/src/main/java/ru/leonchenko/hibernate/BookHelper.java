package ru.leonchenko.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.leonchenko.hibernate.entity.Author;
import ru.leonchenko.hibernate.entity.Book;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class BookHelper {
    private SessionFactory sessionFactory;

    public BookHelper() {sessionFactory = HibrnateUtil.getSessionFactory();}

    public List<Book> getBookList() {
        Session session = sessionFactory.openSession();
        session.get(Book.class, 1);

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Book.class);

        Root<Author> root = cq.from(Book.class);

        Query query = session.createQuery(cq);

        List <Book> bookList = query.getResultList();

        session.close();

        return bookList;
    }
}
