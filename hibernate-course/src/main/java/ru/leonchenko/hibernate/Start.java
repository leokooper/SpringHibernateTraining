package ru.leonchenko.hibernate;
import org.hibernate.Session;
import org.jboss.logging.Logger;
import ru.leonchenko.hibernate.entity.Author;
import ru.leonchenko.hibernate.entity.Book;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class Start {

    private static final Logger LOG = Logger.getLogger( AuthorHelper.class.getName() );


    public static void main(String[] args) {

//        new AuthorHelper().getAuthorList(1);
//
//        HibrnateUtil.getSessionFactory().close();

//        new BookHelper().getBookList();

//        List<Book> books = new BookHelper().getBookList();

        new AuthorHelper().update("test22");


    }

}
