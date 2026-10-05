package se.bilting;

import java.util.Random;

public class NumberGuessGame implements GuessGame {
    private int secret;
    private boolean finished;
    public NumberGuessGame() {
        Random rand = new Random();
        secret = rand.nextInt(100)+1;
        finished = false;
    }

    @Override
    public String makeGuess(String guess) {
        int tal = Integer.parseInt(guess);
        if (tal > secret) {
            return "Too big";
        } else if (tal < secret) {
            return "Too small";
        } else {
            finished = true;
            return "Right!";
        }
    }

    @Override
    public boolean finished() {
          return finished;
    }

    @Override
    public String getInfo() {
        return "Gissa ett tal 1-100, du får reda på > < = !";
    }
}

