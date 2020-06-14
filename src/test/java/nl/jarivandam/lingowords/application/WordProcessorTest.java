package nl.jarivandam.lingowords.application;

import nl.jarivandam.lingowords.domain.RulesStubAlwaysFalse;
import nl.jarivandam.lingowords.domain.RulesStubAlwaysTrue;
import nl.jarivandam.lingowords.domain.Word;
import nl.jarivandam.lingowords.infrastructure.source.FakeWordSource;
import nl.jarivandam.lingowords.infrastructure.target.SpyTarget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

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
        RulesStubAlwaysTrue rules = new RulesStubAlwaysTrue();

        WordProcessor app = new WordProcessor(input,output,rules);
        app.run();
        assertNotNull(output.wordsList.toArray());
        assertArrayEquals(wordList.toArray(),output.wordsList.toArray());
    }

    @Test
    @DisplayName("WordProcessor with stub and invalid word")
    public void wordProcessorWithStubInvalidWord() throws IOException {
        ArrayList<Word> wordList= new ArrayList<Word>();
        FakeWordSource input = new FakeWordSource(wordList);
        input.AddWordToList("aapjes");
        SpyTarget output = new SpyTarget();
        RulesStubAlwaysFalse rules = new RulesStubAlwaysFalse();

        WordProcessor app = new WordProcessor(input,output,rules);
        app.run();

        assertEquals(0,output.wordsList.size());
    }
}
