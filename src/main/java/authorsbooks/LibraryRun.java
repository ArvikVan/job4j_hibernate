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
/**
            Author author1 = Author.of("A-Strugacki");
            Author author2 = Author.of("B-Strugacki");
            Author author3 = Author.of("Bulgakov");

            Book book1 = Book.of("PiknikNaObochine");
            book1.getAuthors().add(author1);
            book1.getAuthors().add(author2);

            Book book2 = Book.of("MasterAndMargarita");
            book2.getAuthors().add(author3);

            session.save(book1);
            session.save(book2);
 */
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
