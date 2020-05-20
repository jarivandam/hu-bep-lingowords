package com.jarivandam.lingowords.domain;

import org.dom4j.rule.Rule;

public class RulesStub implements Rules {


    @Override
    public boolean validate(Word word) {
        return true;
    }
}
