package hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

/**
 * @author ArvikV
 * @version 1.0
 * @since 21.01.2022
 */
public class CandidateRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry)
                    .buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            /*
            Сохраните 3 объекта в таблице, данные возьмите произвольно.
            Candidate first = Candidate.of("VALERA", 10, 100500);
            Candidate second = Candidate.of("Arvik", 24, 17500);
            Candidate third = Candidate.of("Zhenya", 10, 32000);
            session.save(first);
            session.save(second);
            session.save(third);
            */
            /*
            Выполните запросы выборки всех кандидатов
            Query query = session.createQuery("from Candidate");
            for (Object arg : query.list()) {
                System.out.println(arg);
            }
            */
            /*
            кандидата по id
            Query query = session.createQuery("from Candidate c where c.id = 2");
            System.out.println(query.uniqueResult());
            */
            /*
            кандидата по имени
            Query query = session.createQuery("from Candidate c where c.name =: newName")
                    .setParameter("newName", "VALERA");
            System.out.println(query.uniqueResult());
            */
            /*
            обновления записи кандидата
            session.createQuery("update Candidate c set c.name =: newName where c.id =: fId")
                    .setParameter("newName", "VALDEMAR")
                    .setParameter("fId", 1)
                    .executeUpdate();
            */
            /*
            удаления записи кандидата по id
            session.createQuery("delete from Candidate c where c.id =: fId")
                    .setParameter("fId", 1).executeUpdate();
            */
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
