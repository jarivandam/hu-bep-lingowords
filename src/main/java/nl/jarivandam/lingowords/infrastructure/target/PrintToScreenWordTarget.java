package nl.jarivandam.lingowords.infrastructure.target;

import nl.jarivandam.lingowords.domain.Word;
import nl.jarivandam.lingowords.domain.WordTarget;

public class PrintToScreenWordTarget implements WordTarget {

    @Override
    public void saveWord(Word word) {
        System.out.print(word.getWord() +"\n");
    }
}
