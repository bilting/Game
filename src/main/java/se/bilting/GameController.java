package se.bilting;

public class GameController {

    private GuessGame g;

    public GameController(GuessGame game){
        g = game;
    }

    public void run() {
        IO.println(g.getInfo());
        do {
            String guess = IO.readln("Make a guess:");
            String answer = g.makeGuess(guess);
            IO.println(answer);

        } while(!g.finished());
    }
}
