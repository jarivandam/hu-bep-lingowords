package nl.jarivandam.lingowords.domain;

public class RulesStubAlwaysTrue implements Rules {


    @Override
    public boolean validate(Word word) {
        return true;
    }
}
