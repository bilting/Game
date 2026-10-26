package se.bilting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    Hangman h;
    ScoringMock smock;

    @BeforeEach
    void setUp() {
        smock = new ScoringMock();
        h = new Hangman(smock);
        h.setSecret("bulle");
    }

    @Test
    void makeGuess() {
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


        assertTrue(smock.saveWasCalled);
        assertEquals(4,smock.savedScore );
        assertEquals("bulle\nFinished", answer);
        assertTrue(h.finished());
    }

    @Test
    void finished() {
    }
}

class ScoringMock implements Scoring {
    public boolean saveWasCalled = false;
    public int savedScore = 0;
    @Override
    public void saveResult(int score) {
          saveWasCalled = true;
          savedScore = score;
    }

    @Override
    public String getStats() {
        return "Finished";
    }
}