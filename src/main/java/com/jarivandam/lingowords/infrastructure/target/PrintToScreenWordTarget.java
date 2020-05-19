package com.jarivandam.lingowords.infrastructure.target;

import com.jarivandam.lingowords.domain.Word;
import com.jarivandam.lingowords.domain.WordTarget;

public class PrintToScreenWordTarget implements WordTarget {

    @Override
    public void saveWord(Word word) {
        System.out.print(word.getWord() +"\n");
    }
}
