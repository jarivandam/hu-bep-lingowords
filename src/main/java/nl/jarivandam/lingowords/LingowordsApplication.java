package nl.jarivandam.lingowords;

import nl.jarivandam.lingowords.application.WordProcessor;
import nl.jarivandam.lingowords.domain.RulesNederlands;
import nl.jarivandam.lingowords.infrastructure.source.FileWordSource;
import nl.jarivandam.lingowords.infrastructure.target.HttpRequestTarget;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpClient;

public class LingowordsApplication {

    public static void main(String[] args) throws IOException {
//        System.out.print(args[0]);
        String runType = "rest";

        if (runType == "rest"){
            String url = "https://hu-bep-lingogame.herokuapp.com/words";
            HttpRequestTarget target = new HttpRequestTarget(url, HttpClient.newHttpClient());
            FileWordSource source =  new FileWordSource(new File(LingowordsApplication.class.getClassLoader().getResource("basiswoorden-gekeurd.txt").getFile()));

            WordProcessor app = new WordProcessor(source, target, new RulesNederlands(5));
            app.run();
        }

    }

}
