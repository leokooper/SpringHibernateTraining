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
    private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
//        Session session = HibrnateUtil.getSessionFactory().openSession();
//        for (Author author : new AuthorHelper().getAuthorList()
//             ) {
////            System.out.println("author = " + author.getName());
//            LOG.debug(author.getName());
//        }
//
//        for (Book book : new BookHelper().getBookList()
//        ) {
////            System.out.println("book = " + book.getName());
//            LOG.debug(book.getName());
//
//        }

//        Author author = new Author("Иванов");
//        new AuthorHelper().addAuthor(author);
//        Author author1 = session.get(Author.class, 1);
//        System.out.println(author1);

//        Author authorTH = new Author("Автор");
//        new AuthorHelper().addAuthorTH(authorTH);
        new AuthorHelper().getAuthorList();
    }
}
