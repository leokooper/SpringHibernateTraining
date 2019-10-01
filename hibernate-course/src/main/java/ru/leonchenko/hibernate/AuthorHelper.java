package ru.leonchenko.hibernate;


/**
 * @author Igor Leonchenko
 * @version 1.0
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.leonchenko.hibernate.entity.Author;
import ru.leonchenko.hibernate.entity.Author_;
import ru.leonchenko.hibernate.entity.CommonFields_;

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

        Selection[] selection = {root.get(Author_.commonFields).get(CommonFields_.id), root.get(Author_.commonFields).get(CommonFields_.name)}; // выборка полей, в классе Author должен быть конструктор с этими параметрами

        ParameterExpression<String> nameParam = cb.parameter(String.class, "name");

        cq.select(cb.construct(Author.class, selection))
                .where(cb.like(root.get(Author_.commonFields).get(CommonFields_.name), nameParam));


        // этап выполнения запроса
        Query query = session.createQuery(cq);
        query.setParameter("name", "%Лер%");


        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;

    }

    // добавляют нового автора в таблица Author
//    public Author addAuthor(Author author) {
//
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        for (int i = 1; i <= 200; i++) {
//            Author a = new Author("name" + i);
//            a.setSecondName("sec_name" + i);
//            if (i % 20 == 0) {
//                session.flush();
//            }
//            session.save(a); // сгенерит ID и вставит в объект
//        }
//
//        session.getTransaction().commit();
//
//        session.close();
//
//        return author;
//
//    }

    public void delete() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Author a = session.get(Author.class, 6L);

        session.delete(a);

        session.getTransaction().commit();

        session.close();
    }

    public void deletePackage(){
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaDelete<Author> criteriaDelete = cb.createCriteriaDelete(Author.class);

        Root<Author> root = criteriaDelete.from(Author.class);

        ParameterExpression<String> nameParam = cb.parameter(String.class, "name");
        ParameterExpression<String> secNameParam = cb.parameter(String.class, "secondName");


        criteriaDelete.where(cb.or(
                cb.and(
                        cb.like(root.get(Author_.commonFields).get(CommonFields_.name), nameParam),
                        cb.like(root.get(Author_.secondName), secNameParam)
                ),
                        cb.equal(root.get(Author_.commonFields).get(CommonFields_.name), "name_99")
                )
                );

        Query query = session.createQuery(criteriaDelete);

        query.setParameter("name", "%Аку%");

        query.setParameter("secName", "%ttt%");

        query.executeUpdate();

        session.getTransaction().commit();

        session.close();

    }

    public void update(String name) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaUpdate<Author> criteriaUpdate = cb.createCriteriaUpdate(Author.class);

        Root<Author> root = criteriaUpdate.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)

        ParameterExpression<String> nameParam = cb.parameter(String.class, "name");

        Expression<Integer> length = cb.length(root.get(Author_.secondName));

        criteriaUpdate.set(root.get(Author_.commonFields).get(CommonFields_.name), nameParam).
                where(cb.equal(length, 3)
                );


        // этап выполнения запроса
        Query query = session.createQuery(criteriaUpdate);
        query.setParameter("name", name);

        query.executeUpdate();// вместо возврата результата - используется метод обновления


        session.getTransaction().commit();

        session.close();
    }

    public Author getAuthor(String name) {
        return null;
    }

    public Author getAuthorList(long id) {

        Session session = sessionFactory.openSession();

        Author author =  session.get(Author.class, id);

        return author;
    }
}