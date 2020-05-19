package com.jarivandam.lingowords.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Word {
    @Id
    @GeneratedValue
    private int id;
    private String word;

    public Word () {}
    public Word (String word){
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
