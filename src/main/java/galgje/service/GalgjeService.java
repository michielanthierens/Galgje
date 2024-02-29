package galgje.service;

import galgje.domain.Game;

public class GalgjeService {

    private final Game game;

    public GalgjeService(Game game) {
        this.game = game;
    }
    
    public String getCurrentWord() {
        return game.getCurrentWord();
    }

    public int getAttempts() {
        return game.getAttempts();
    }

    public boolean checkWin() {
        return game.checkSolution();
    }

    public void checkLetter(String guess) {
        game.checkLetter(guess);
    }

    public String getSolution() {
        game.setAttempts(0);
        return game.getSecretWord();
    }

    public void checkGuess(String guess) {
        game.checkGuess(guess);
    }
}
