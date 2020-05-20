package com.jarivandam.lingowords.domain;

public class RulesNederlands implements Rules {
    private int length;

    public RulesNederlands(int length) {
        this.length = length;
    }

    public  boolean validate (Word word){
        String string = word.getWord();

        if (Character.isUpperCase(string.charAt(0))){
            return false;
        }

        if (string.length() != length){
            return false;
        }

        if(!string.chars().allMatch(Character::isLetter)){
            return false;
        }
        return true;
    }
}
