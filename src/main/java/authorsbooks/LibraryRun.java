package authorsbooks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author ArvikV
 * @version 1.0
 * @since 15.01.2022
 */
public class LibraryRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

          /*  Book book1 = Book.of("PiknikNaObochine");
            book1.addAuthor(new Author("A-Strugacki"));
            book1.addAuthor(new Author("B-Strugacki"));

            Book book2 = Book.of("MasterAndMargarita");
            book2.addAuthor(new Author("Bulgakov"));

            session.save(book1);
            session.save(book2);*/
            Book book = session.get(Book.class, 1);
            session.remove(book);

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
