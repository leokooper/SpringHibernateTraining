package ru.leonchenko.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.leonchenko.hibernate.entity.Author;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class AuthorHelper {
    private SessionFactory sessionFactory;

    public AuthorHelper() {sessionFactory = HibrnateUtil.getSessionFactory();}

    public List <Author> getAuthorList() {
        Session session = sessionFactory.openSession();
        session.get(Author.class, 1);

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Author.class);

        Root <Author> root = cq.from(Author.class);

        Query query = session.createQuery(cq);

        List <Author> authorList = query.getResultList();

        session.close();

        return authorList;
    }

    public Author addAuthor(Author author) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
        return author;

    }

    public Author getAuthor(String name) {
        return null;
    };
}
