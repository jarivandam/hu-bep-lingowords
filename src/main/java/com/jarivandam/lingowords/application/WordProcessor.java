package com.jarivandam.lingowords.application;

import com.jarivandam.lingowords.domain.*;

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
