package com.jarivandam.lingowords.application;

import com.jarivandam.lingowords.domain.RulesStub;
import com.jarivandam.lingowords.domain.Word;
import com.jarivandam.lingowords.domain.WordSource;
import com.jarivandam.lingowords.domain.WordTarget;
import com.jarivandam.lingowords.infrastructure.source.FakeWordSource;
import com.jarivandam.lingowords.infrastructure.source.FileWordSource;
import com.jarivandam.lingowords.infrastructure.target.PrintToScreenWordTarget;
import com.jarivandam.lingowords.infrastructure.target.SpyTarget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("WordProcessor")
public class WordProcessorTest {
    @Test
    @DisplayName("WordProcessor with stub")
    public void wordProcessorWithStub() throws IOException {
        ArrayList<Word> wordList= new ArrayList<Word>();
        FakeWordSource input = new FakeWordSource(wordList);
        input.AddWordToList("aapje");
        SpyTarget output = new SpyTarget();
        RulesStub rules = new RulesStub();

        WordProcessor app = new WordProcessor(input,output,rules);
        app.run();
        assertNotNull(output.wordsList.toArray());
        assertArrayEquals(wordList.toArray(),output.wordsList.toArray());
    }
}
