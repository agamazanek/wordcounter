package com.smalaca.wordcounterwithtranslate;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class WordCounterTest {
    private static final String SOME_WORD = "some";
    private static final String DIFFERENT_WORD = "different";
    private static final String PL_WORD = "kot";
    private static final String ENG_WORD = "cat";

    @Test
    public void shouldReturnZeroWhenNothingGiven() {
        WordCounter wordCounter = givenWordCounterWithTranslator();

        int result = wordCounter.count(SOME_WORD);

        assertEquals(0, result);
    }

    @Test
    public void shouldReturnOneWithOneOccurence() {
        WordCounter wordCounter = givenWordCounterWithTranslator();
        wordCounter.add(SOME_WORD);

        int result = wordCounter.count(SOME_WORD);

        assertEquals(1, result);
    }

    @Test
    public void shouldReturnZeroWhenDifferentWordAdded() {
        WordCounter wordCounter = givenWordCounterWithTranslator();
        wordCounter.add(DIFFERENT_WORD);

        int result = wordCounter.count(SOME_WORD);

        assertEquals(0, result);
    }

    private WordCounter givenWordCounterWithTranslator() {
        Translator translator = mock(Translator.class);
        given(translator.translate(SOME_WORD)).willReturn(SOME_WORD);
        given(translator.translate(DIFFERENT_WORD)).willReturn(DIFFERENT_WORD);

        return new WordCounter(translator);
    }

    @Test
    public void shouldCountWordsGivenInDifferentLanguage() {
        WordCounter wordCounter = new WordCounter(givenPolishEnglishTranslator());
        wordCounter.add(ENG_WORD);
        wordCounter.add(ENG_WORD);

        int result = wordCounter.count(PL_WORD);

        assertEquals(2, result);
    }

    @Test
    public void shouldCountWordsCountedInDifferentLanguage() {
        WordCounter wordCounter = new WordCounter(givenPolishEnglishTranslator());
        wordCounter.add(PL_WORD);
        wordCounter.add(PL_WORD);

        int result = wordCounter.count(ENG_WORD);

        assertEquals(2, result);
    }

    @Test
    public void shouldCountWordsInBothLanguages() {
        WordCounter wordCounter = new WordCounter(givenPolishEnglishTranslator());
        wordCounter.add(PL_WORD);
        wordCounter.add(PL_WORD);
        wordCounter.add(PL_WORD);
        wordCounter.add(ENG_WORD);
        wordCounter.add(ENG_WORD);

        int result = wordCounter.count(ENG_WORD);

        assertEquals(5, result);
    }

    private Translator givenPolishEnglishTranslator() {
        Translator translator = mock(Translator.class);
        given(translator.translate(PL_WORD)).willReturn(ENG_WORD);
        given(translator.translate(ENG_WORD)).willReturn(PL_WORD);
        return translator;
    }
}
