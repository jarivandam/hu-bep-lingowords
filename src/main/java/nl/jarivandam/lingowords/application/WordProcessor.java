package nl.jarivandam.lingowords.application;

import nl.jarivandam.lingowords.domain.*;
import nl.jarivandam.lingowords.domain.Rules;
import nl.jarivandam.lingowords.domain.Word;
import nl.jarivandam.lingowords.domain.WordSource;
import nl.jarivandam.lingowords.domain.WordTarget;

import java.io.IOException;

public class WordProcessor {
    private WordSource input;
    private WordTarget output;
    private Rules rules;

    public WordProcessor(WordSource input, WordTarget output, Rules rules) throws IOException {
        this.input = input;
        this.output = output;
        this.rules= rules;
    }

    public void run(){
        for(Word word: input.ReadWords()){
            if (rules.validate(word)){
                output.saveWord(word);
            }
        }
    }
}
