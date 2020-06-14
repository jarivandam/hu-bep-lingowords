package nl.jarivandam.lingowords.infrastructure.source;

import nl.jarivandam.lingowords.domain.Word;
import nl.jarivandam.lingowords.domain.WordSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("FileWordSourceTest")
public class FileWordSourceTest {
    @Test
    @DisplayName("")
    public void ReadWordsFromSmallFile() throws IOException {
        WordSource source = new FileWordSource(new File("src/test/resources/test-words.txt"));
        ArrayList<Word> correctWordsList = new ArrayList<Word>();
        correctWordsList.add(new Word("aapje"));
        correctWordsList.add(new Word("noot"));
        correctWordsList.add(new Word("test'"));
        correctWordsList.add(new Word("hallo"));

        assertEquals(correctWordsList.get(0).getWord(), source.ReadWords().get(0).getWord());
        assertEquals(correctWordsList.get(1).getWord(), source.ReadWords().get(1).getWord());
        assertEquals(correctWordsList.get(2).getWord(), source.ReadWords().get(2).getWord());
        assertEquals(correctWordsList.get(3).getWord(), source.ReadWords().get(3).getWord());

    }
}
