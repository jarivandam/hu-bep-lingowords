package nl.jarivandam.lingowords.infrastructure.target;

import nl.jarivandam.lingowords.domain.Word;
import nl.jarivandam.lingowords.domain.WordTarget;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DatabaseWordTarget implements WordTarget {
    Session session;
    public DatabaseWordTarget(SessionFactory sessionFactory){
        this.session = sessionFactory.openSession();

    }



    @Override
    public void saveWord(Word word) {
        this.session.beginTransaction();
        this.session.save(word);
        this.session.getTransaction().commit();
    }

    public void EndTransaction(){

        this.session.close();
    }
}
