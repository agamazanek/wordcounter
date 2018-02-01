package com.smalaca.wordcounterwithtranslate;

import java.util.HashMap;
import java.util.Map;

class WordCounter {
    private static final int NO_WORD = 0;
    private final Map<String, Integer> words = new HashMap<>();

    int count(String word) {
        return words.getOrDefault(word, NO_WORD);
    }

    void add(String word) {
        words.put(word, count(word) + 1);
    }
}
