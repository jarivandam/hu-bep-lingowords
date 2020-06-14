package nl.jarivandam.lingowords.infrastructure.source;

import nl.jarivandam.lingowords.domain.Word;
import nl.jarivandam.lingowords.domain.WordSource;

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
