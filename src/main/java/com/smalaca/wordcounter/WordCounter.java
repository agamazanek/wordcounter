package com.smalaca.wordcounter;

import static java.util.Arrays.stream;

class WordCounter {
    private static final String SEPARATOR = " ";

    private final String sentence;

    WordCounter(String sentence) {
        this.sentence = sentence;
    }

    long count(String word) {
        return stream(sentence.split(SEPARATOR)).filter(word::equals).count();
    }
}
