package com.jarivandam.lingowords.application;

import com.jarivandam.lingowords.domain.Word;
import com.jarivandam.lingowords.domain.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {
    private WordRepository words;

    public List<Word> list(){
        return words.findAll();
    }

    public void writeWord(String word){
        this.words.save(new Word(word));
    }
}
