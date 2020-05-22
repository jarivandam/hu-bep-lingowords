package com.jarivandam.lingowords.infrastructure.target;

import com.jarivandam.lingowords.domain.Word;
import com.jarivandam.lingowords.domain.WordRepository;
import com.jarivandam.lingowords.domain.WordTarget;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
