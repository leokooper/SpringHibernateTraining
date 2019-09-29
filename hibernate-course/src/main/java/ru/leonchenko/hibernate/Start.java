package ru.leonchenko.hibernate;
import org.hibernate.Session;
import org.jboss.logging.Logger;
import ru.leonchenko.hibernate.entity.Author;
import ru.leonchenko.hibernate.entity.Book;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class Start {

    private static final Logger LOG = Logger.getLogger( AuthorHelper.class.getName() );


    public static void main(String[] args) {

        new AuthorHelper().getAuthorList();

        HibrnateUtil.getSessionFactory().close(); // закрываем фабрику, иначе программа останется в "зависнутом состоянии"

    }

}
