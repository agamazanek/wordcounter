package com.smalaca.wordcounterwithtranslate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {
    private static final String SOME_WORD = "word";

    @Test
    public void shouldReturnZeroWhenNothingGiven() {
        WordCounter wordCounter = new WordCounter();

        int result = wordCounter.count(SOME_WORD);

        assertEquals(0, result);
    }
}
