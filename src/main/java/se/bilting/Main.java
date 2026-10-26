package se.bilting;

public class Main {
    static void main() {

        Scoring s = new HangmanScoring();
        GuessGame game = new Hangman(s);
        GameController controller = new GameController(game);

        controller.run();
    }
}



