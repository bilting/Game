package se.bilting;

public class Main {
    static void main() {

        GuessGame game = new Hangman();
        GameController controller = new GameController(game);

        controller.run();
    }
}

// Uppgift:
// Beskriv spelet med ett interface GuessGame
// NumberGuessGame implements GuessGame
// hitta på nåt nytt gissningsspel (implements GuessGame)
// se hur lätt det är att byta till annat spel.

// Extrauppgift
// 1. låt spelaren välja spel vid start.
// 2. kunna spela flera ggr.
// 3. extra metod som beskriver spelets mål och regler




