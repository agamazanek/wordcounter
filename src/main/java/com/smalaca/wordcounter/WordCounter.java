package com.smalaca.wordcounter;

import static java.util.Arrays.asList;

class WordCounter {
    private static final String SEPARATOR = " ";

    private final String sentence;

    WordCounter(String sentence) {
        this.sentence = sentence;
    }

    long count(String word) {
        return asList(sentence.split(SEPARATOR)).stream().filter(word::equals).count();
    }
}
