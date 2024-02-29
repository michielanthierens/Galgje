package galgje.domain;

public class Game {

    private final String secret_word;
    private int attempts = 7;
    private String current_word;

    public String getCurrentWord() {
        return current_word;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void failedAttempt() {
        this.attempts -= 1;
    }

    public void setCurrentWord(String current_word) {
        this.current_word = current_word;
    }

    public void checkGuess(String guess) {
        if (secret_word.equals(guess)) {
            current_word = guess;
        } else failedAttempt();
    }

    public boolean checkSolution() {
        return secret_word.equals(current_word);
    }

    public Game(String secret_word) {
        this.secret_word = secret_word;
        this.current_word = "";

        // Populate current_word with underscores for letters and leave spaces as is
        for (char ch : secret_word.toCharArray()) {
            if (Character.isLetter(ch)) this.current_word += "_";
            else if (ch == ' ') this.current_word += " ";
        }
    }

    public Game(String secret_word, int attempts) {
        this.secret_word = secret_word;
        this.attempts = attempts;
        this.current_word = "";

        for (char ch : secret_word.toCharArray()) {
            if (Character.isLetter(ch)) this.current_word += "_";
            else if (ch == ' ') this.current_word += " ";
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

    public void checkLetter(String guess) {
        if (secret_word.contains(guess)) {
            StringBuilder updatedWord = new StringBuilder(current_word);
            char character = guess.toLowerCase().charAt(0);

            for (int i = 0; i < secret_word.length(); i++) {
                if (secret_word.charAt(i) == character) {
                    updatedWord.setCharAt(i, character);
                }
            }
            setCurrentWord(updatedWord.toString());
        } else {
            failedAttempt();
        }
    }

    public String getSecretWord() {
        return secret_word;
    }
}
