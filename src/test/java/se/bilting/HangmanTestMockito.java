package se.bilting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HangmanTestMockito {

    Hangman h;
    Scoring smock;

    @BeforeEach
    void setUp() {
        smock = mock(Scoring.class);
        when(smock.getStats()).thenReturn("Finished");
        h = new Hangman(smock);
        h.setSecret("bulle");
    }

    @Test
    void makeGuess1() {
        String answer = h.makeGuess("l");
        assertEquals("__ll_\n", answer);
    }
    @Test
    void makeGuessRepeat() {
        String answer;
        answer = h.makeGuess("l");
        answer = h.makeGuess("l");
        assertEquals("Already guessed that.", answer);
    }

    @Test
    void makeGuessFinished() {
        String answer;
        answer = h.makeGuess("l");
        answer = h.makeGuess("b");
        answer = h.makeGuess("e");
        answer = h.makeGuess("u");

        verify(smock,times(1)).saveResult(4);
        assertEquals("bulle\nFinished", answer);
        assertTrue(h.finished());
    }


}