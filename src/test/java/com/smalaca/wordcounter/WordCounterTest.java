package com.smalaca.wordcounter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {
    private static final String SOME_SENTENCE = "Hello! Hello everyone";
    private static final String SOME_WORD = "some";
    private static final String EVERYONE_WORD = "everyone";
    private static final int ZERO = 0;
    private static final int ONE = 1;

    @Test
    public void shouldRecognizeWhenWordIsNotPresentInSentence() {
        WordCounter wordCounter = new WordCounter(SOME_SENTENCE);

        assertEquals(ZERO, wordCounter.count(SOME_WORD));
    }

    @Test
    public void shouldRecognizeWhenWordIsPresentInSentence() {
        WordCounter wordCounter = new WordCounter(SOME_SENTENCE);

        assertEquals(ONE, wordCounter.count(EVERYONE_WORD));
    }
}
