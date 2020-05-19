package com.jarivandam.lingowords.domain;

import com.jarivandam.lingowords.domain.Word;

import java.util.List;

public interface WordSource {
    public Word ReadWord();
    public List<Word> ReadWords();
}
