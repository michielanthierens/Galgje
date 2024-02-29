package galgje.ui.cli;

import galgje.domain.Game;

public class Program {
    public static void main(String[] args) {
        Game game = new Game("test");
        System.out.println(game);

        Game game2 = new Game("test", 3);
        System.out.println(game2);
    }
}
