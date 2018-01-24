package com.smalaca.wordcounter;

class WordCounter {
    private final String sentence;

    WordCounter(String sentence) {
        this.sentence = sentence;
    }

    int count(String word) {
        return sentence.contains(word) ? 1 : 0;
    }
}
