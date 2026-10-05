package se.bilting;

import java.util.Random;

public class AnimalGuess implements GuessGame{

    private String[] animals = { "Apa", "Björn", "Tiger", "Kanin"};
    private String secret;
    private boolean finished = false;

    public AnimalGuess() {
        Random rand = new Random();
        secret = animals[rand.nextInt(animals.length)];
    }

    @Override
    public String makeGuess(String guess) {
        if (guess.equalsIgnoreCase(secret)) {
            finished = true;
            return "Rätt!";
        } else {
            return "Försök igen!";
        }
    }

    @Override
    public boolean finished() {
        return finished;
    }

    @Override
    public String getInfo() {
        return "Gissa djur, du får ingen hjälp";
    }
}
