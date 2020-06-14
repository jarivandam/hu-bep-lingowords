package nl.jarivandam.lingowords.infrastructure.source;

import nl.jarivandam.lingowords.domain.Word;
import nl.jarivandam.lingowords.domain.WordSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileWordSource implements WordSource {
    private File file  = new File("src/main/resources/basiswoorden-gekeurd.txt");
    private List<String> wordStrings = new ArrayList<String>();

    public FileWordSource(File file) throws IOException {
        this.file = file;
        this.wordStrings = Files.readAllLines(Paths.get(file.getPath()));
    }

    @Override
    public List<Word> ReadWords() {
        ArrayList<Word> words = new ArrayList<Word>();
        for (String wordString : wordStrings){
            words.add(new Word(wordString));
        }

        return words;
    }
}
