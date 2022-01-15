package manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author ArvikV
 * @version 1.0
 * @since 15.01.2022
 * При выполнеии задания более двух адресов не добавляется
 * и при попытке удалить одну запись полностью с помощью session.remove(person);
 * она удаляется. Если же поменять сет на лист, то происходит как описано. Добавляется
 * столько сколько требуется, адалить не получается, только после изменения каскадтайпа
 *
 */
public class HbmRun {
    public static void main(String[] args) {
        /**
         * читаем файл настроек хибернате
         */
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

       /*     Address one = Address.of("Kazanskaya", "1");
            Address two = Address.of("Piterskaya", "10");
            Address three = Address.of("Poo", "5");

            Person first = Person.of("Nikolay");
            first.getAddresses().add(one);
            first.getAddresses().add(two);
            first.getAddresses().add(three);

            Person second = Person.of("Anatoliy");
            second.getAddresses().add(two);

            session.save(first);
            session.save(second);*/
              Person person = session.get(Person.class, 1);
                        session.remove(person);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
