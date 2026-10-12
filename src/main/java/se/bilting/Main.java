package se.bilting;

public class Main {
    static void main() {

        Scoring s = new HangmanScoring();
        GuessGame game = new Hangman(s);
        GameController controller = new GameController(game);

        controller.run();
    }
}

/*
Skriv ett test för Hangman, med mockning av Scoring så denm inte skriver på nån fil.

Lägg till tester för de andra spelen med eventuell mockning
 */



