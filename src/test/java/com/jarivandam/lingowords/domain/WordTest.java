package com.jarivandam.lingowords.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Word")
public class WordTest {
    @Test
    @DisplayName("Create word")
    void newWord(){
        String string = "hello";

        Word word = new Word(string);

        assertNotNull(word.getWord());
        assertSame(word.getWord(),string);
    }
}
