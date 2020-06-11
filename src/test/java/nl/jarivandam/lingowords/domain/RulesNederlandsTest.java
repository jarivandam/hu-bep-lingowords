package nl.jarivandam.lingowords.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RulesNederlands")
public class RulesNederlandsTest {
    @Test
    @DisplayName("Nederlands happy flow 5 letters")
    public void NederlandsHappyFlowFiveLetters(){
        RulesNederlands rules = new RulesNederlands(5);
        Word validWord = new Word("aapje");

        boolean result=  rules.validate(validWord);

        assertTrue(result);
    }
    @Test
    @DisplayName("Nederlands happy flow 6 letters")
    public void NederlandsHappyFlowSixLetters(){
        RulesNederlands rules = new RulesNederlands(6);
        Word validWord = new Word("aapjes");

        boolean result=  rules.validate(validWord);

        assertTrue(result);
    }
    @Test
    @DisplayName("Nederlands happy flow 7 letters")
    public void NederlandsHappyFlowSevenLetters(){
        RulesNederlands rules = new RulesNederlands(7);
        Word validWord = new Word("vakpers");

        boolean result=  rules.validate(validWord);

        assertTrue(result);
    }
    @Test
    @DisplayName("Nederlands invalid word with quote")
    public void NederlandsWordWithQuote(){
        RulesNederlands rules = new RulesNederlands(5);
        Word validWord = new Word("a'pje");

        boolean result=  rules.validate(validWord);

        assertFalse(result);
    }

    @Test
    @DisplayName("Nederlands word to long")
    public void NederlandsWordToLong(){
        RulesNederlands rules = new RulesNederlands(5);
        Word validWord = new Word("aapjes");

        boolean result=  rules.validate(validWord);

        assertFalse(result);
    }
    @Test
    @DisplayName("Nederlands word start with capital letter")
    public void NederlandsWordStartWithCapital(){
        RulesNederlands rules = new RulesNederlands(5);
        Word validWord = new Word("Bosje");

        boolean result=  rules.validate(validWord);

        assertFalse(result);
    }
}
