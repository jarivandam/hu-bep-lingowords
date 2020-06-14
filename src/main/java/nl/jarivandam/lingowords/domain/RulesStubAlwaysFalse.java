package nl.jarivandam.lingowords.domain;

public class RulesStubAlwaysFalse implements Rules {


    @Override
    public boolean validate(Word word) {
        return false;
    }
}
