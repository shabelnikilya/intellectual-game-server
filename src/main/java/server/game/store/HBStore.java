package server.game.store;

import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import server.game.models.Question;

@Log4j
public class HBStore implements Store {
    private static final Store STORE = new HBStore();
    private final SessionFactory sf;

    private HBStore() {
        log.info("Инициализация подключения к БД (создание экземпляра SessionFactory)");
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        this.sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static Store getInstance() {
        return STORE;
    }

    @Override
    public Question findQuestionById(Integer id) {
        log.info("Начался поиск вопроса!");
        Session session = sf.openSession();
        session.beginTransaction();
        Question question = session.get(Question.class, id);
        session.getTransaction().commit();
        session.close();
        log.info("Окончен поиск вопроса!");
        return question;
    }
}
