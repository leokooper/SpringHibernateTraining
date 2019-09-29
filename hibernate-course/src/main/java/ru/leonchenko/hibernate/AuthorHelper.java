package ru.leonchenko.hibernate;


/**
 * @author Igor Leonchenko
 * @version 1.0
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.leonchenko.hibernate.entity.Author;
import ru.leonchenko.hibernate.entity.Author_;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;


public class AuthorHelper {

    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibrnateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList() {

        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();

        // этап подготовки запроса

        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery cq = cb.createQuery(Author.class);

        Root<Author> root = cq.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)

        Selection[] selection = {root.get(Author_.id), root.get(Author_.name)}; // выборка полей, в классе Author должен быть конструктор с этими параметрами

        ParameterExpression<String> nameParam = cb.parameter(String.class, "name");

        cq.select(cb.construct(Author.class, selection))
                .where(cb.like(root.get(Author_.name), nameParam));


        // этап выполнения запроса
        Query query = session.createQuery(cq);
        query.setParameter("name", "%Лер%");


        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;

    }

    // добавляют нового автора в таблица Author
    public Author addAuthor(Author author) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for (int i = 1; i <= 200; i++) {
            Author a = new Author("name" + i);
            a.setSecondName("sec_name" + i);
            if (i % 20 == 0) {
                session.flush();
            }
            session.save(a); // сгенерит ID и вставит в объект
        }

        session.getTransaction().commit();

        session.close();

        return author;

    }

    public Author getAuthor(String name) {
        return null;
    }
}