package nl.jarivandam.lingowords.infrastructure.target;

import nl.jarivandam.lingowords.domain.Word;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(OutputCaptureExtension.class)
public class PrintToScreenWordTargetTest {

    @Test
    public void DetectWordPrintedTest(CapturedOutput output){
        PrintToScreenWordTarget target = new PrintToScreenWordTarget();
        target.saveWord(new Word("hello"));
        assertTrue(output.toString().contains("hello"));
    }

}

