package se.bilting;

public interface GuessGame {
    String makeGuess(String guess);
    boolean finished();
    String getInfo();
}
