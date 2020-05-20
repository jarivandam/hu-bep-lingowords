package com.jarivandam.lingowords.infrastructure.source;

import com.jarivandam.lingowords.domain.Word;
import com.jarivandam.lingowords.domain.WordSource;

import java.util.List;

public class FakeWordSource implements WordSource {
    private List<Word> wordList;
    public FakeWordSource(List<Word> words){
        this.wordList = words;
    }
    public void AddWordToList(String string){
        this.wordList.add(new Word(string));
    }

    @Override
    public List<Word> ReadWords() {
        return this.wordList;
    }
}
