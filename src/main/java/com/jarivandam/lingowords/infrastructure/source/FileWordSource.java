package com.jarivandam.lingowords.infrastructure.source;

import com.jarivandam.lingowords.domain.Word;
import com.jarivandam.lingowords.domain.WordSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileWordSource implements WordSource {
    private String fileName  = "src/main/resources/basiswoorden-gekeurd.txt";
    private List<String> wordStrings = Files.readAllLines(Path.of(fileName));

    public FileWordSource(String fileName) throws IOException {
        this.fileName = fileName;
        this.wordStrings = Files.readAllLines(Path.of(this.fileName));
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
