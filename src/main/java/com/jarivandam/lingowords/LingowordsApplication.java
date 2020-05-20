package com.jarivandam.lingowords;

import com.jarivandam.lingowords.application.WordProcessor;
import com.jarivandam.lingowords.domain.RulesNederlands;
import com.jarivandam.lingowords.infrastructure.source.FileWordSource;
import com.jarivandam.lingowords.infrastructure.target.PrintToScreenWordTarget;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class LingowordsApplication {

    public static void main(String[] args) throws IOException {
        System.out.print("Hello world!");
//        System.out.print(args[0]);
        WordProcessor app= new WordProcessor(new FileWordSource("resources/baiswoorden-gekeurd.txt"),new PrintToScreenWordTarget(),new RulesNederlands(7));
        app.run();
        //SpringApplication.run(LingowordsApplication.class, args);
    }

}
