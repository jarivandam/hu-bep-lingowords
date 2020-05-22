package com.jarivandam.lingowords;

import com.jarivandam.lingowords.application.WordProcessor;
import com.jarivandam.lingowords.domain.RulesNederlands;
import com.jarivandam.lingowords.domain.WordTarget;
import com.jarivandam.lingowords.infrastructure.source.FileWordSource;
import com.jarivandam.lingowords.infrastructure.target.DatabaseWordTarget;
import com.jarivandam.lingowords.infrastructure.target.PrintToScreenWordTarget;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class LingowordsApplication {

    public static void main(String[] args) throws IOException {
//        System.out.print(args[0]);
        SessionFactory sessionFactory = null;
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            DatabaseWordTarget target = new DatabaseWordTarget(sessionFactory);

            WordProcessor app = new WordProcessor(new FileWordSource(new File(LingowordsApplication.class.getClassLoader().getResource("basiswoorden-gekeurd.txt").getFile())),target,new RulesNederlands(7));
            app.run();
            target.EndTransaction();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }


    }

}
