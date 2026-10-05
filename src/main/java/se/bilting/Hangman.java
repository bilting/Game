package se.bilting;

import java.security.PrivateKey;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Hangman implements GuessGame{

    private Set<Character> guesses;
    private int nGuess;
    private String[] words = {"kardemumma", "syltlök", "kanelbulle", "wasabi"};
    private String secret;
    private boolean finished = false;

    public Hangman() {
        Random rand = new Random();
        guesses = new HashSet<>();
        secret = words[rand.nextInt(words.length)];
        nGuess = 0;

    }

    @Override
    public String makeGuess(String guess) {

        char cGuess = guess.charAt(0);
        if (guesses.contains(cGuess)) {
            return "Already guessed that.";
        }

        guesses.add(cGuess);
        String answer = "";
        finished = true;
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (guesses.contains(c)) {
                answer += c;
            } else {
                finished = false;
                answer += "_";
            }
        }
        return answer;
    }

    @Override
    public boolean finished() {
        return finished;
    }

    @Override
    public String getInfo() {
        return "Hangman, guess one char at a time!\n"
                + "_".repeat(secret.length());
    }
}
