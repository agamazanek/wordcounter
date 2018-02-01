package com.smalaca.wordcounterwithtranslate;

import java.util.HashMap;
import java.util.Map;

class WordCounter {
    private static final int NO_WORD = 0;

    private final Map<String, Integer> words = new HashMap<>();
    private final Translator translator;

    WordCounter(Translator translator) {
        this.translator = translator;
    }

    int count(String word) {
        return countFor(word) + countIfDifferent(word, translator.translate(word));
    }

    private Integer countIfDifferent(String word, String translatedWord) {
        return word.equals(translatedWord)? NO_WORD : countFor(translatedWord);
    }

    private Integer countFor(String word) {
        return words.getOrDefault(word, NO_WORD);
    }

    void add(String word) {
        words.put(word, countFor(word) + 1);
    }
}
