package com.jarivandam.lingowords.infrastructure.target;

import com.jarivandam.lingowords.domain.Word;
import com.jarivandam.lingowords.domain.WordTarget;

import java.util.ArrayList;

public class SpyTarget implements WordTarget {
    public ArrayList<Word> wordsList = new ArrayList<Word>();

    @Override
    public void saveWord(Word word) {
        this.wordsList.add(word);
    }
}

