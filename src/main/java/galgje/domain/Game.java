package galgje.domain;

public class Game {

    private String secret_word;
    private int attempts = 7;
    private String current_word;

    public Game(String secret_word) {
        this.secret_word = secret_word;
        this.current_word = "";
        for (int i = 0; i < secret_word.length(); i++ ) {
            this.current_word += "_";
        }
    }

    public Game(String secret_word, int attempts) {
        this.secret_word = secret_word;
        this.attempts = attempts;
        this.current_word = "";
        for (int i = 0; i < secret_word.length(); i++ ) {
            this.current_word += "_";
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "secret_word='" + secret_word + '\'' +
                ", attempts=" + attempts +
                ", current_word='" + current_word + '\'' +
                '}';
    }
}
