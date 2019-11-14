import javax.swing.*;
import java.util.ArrayList;

public class Game {

    private GUI gui;

    private WordLoader wordLoader;

    public Game() {
        this.gui = new GUI(this);
        wordLoader = new WordLoader();
    }

    public static void main(String[] args) {
        new Game().start();
    }

    private int remainingLiefs;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    private String word;
    //    ArrayList <Boolean> correctGuessChar = new ArrayList<Boolean>();
    boolean[] correctGuessChar;
    ArrayList<Character> incorrectlyGassedChar = new ArrayList<Character>();

    /**
     * Starts the Game
     */
    public void start() {
        remainingLiefs = 12;
        incorrectlyGassedChar.clear();
        try {

            word = this.wordLoader.getRandomWord();
            correctGuessChar = new boolean[word.length()];

            for (int i = 0; i < word.length(); i++) {
                correctGuessChar[i] = false;

            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(gui.frame, e.getMessage());
        }
        /*
        1. get Word
        2.
         */

        updateGui();
    }

    public void onGuess(char guess) {
        //

        if (word.toLowerCase().contains("" + Character.toLowerCase(guess))) {
            for (int i = 0; i < word.length(); i++) {
                if (Character.toLowerCase(word.charAt(i)) == Character.toLowerCase( guess)) {
                    correctGuessChar[i] = true;
                }
            }
        } else {
            remainingLiefs--;
        }

        this.incorrectlyGassedChar.add(guess);

        if (remainingLiefs == 0) {
            gui.onLose();

        }
        if (checkArrey()) {
            gui.onWin();
            start();
        }


        updateGui();


    }

    public boolean checkArrey() {
        for (boolean f : correctGuessChar)
            if (!f)
                return false;

        return true;
    }

    public void updateGui() {

        //Überträgt die neuen Infos an die Gui
//
//        word / boolean[] ===> "H _ L L _ _ _"
        StringBuilder leer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (correctGuessChar[i]) {
                leer.append(c);

            } else {
                leer.append("_");
            }
            leer.append(" ");

        }


        gui.update(remainingLiefs, leer.toString(), incorrectlyGassedChar.toString());
    }

}
