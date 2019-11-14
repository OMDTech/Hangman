import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GUI {

    JFrame frame = new JFrame("Hangman");
    JFrame chooseFrame = new JFrame();
    JPanel panel = new JPanel();
    JPanel chooseFramePanel = new JPanel();
    JButton button = new JButton("button");
    JButton retry = new JButton("retry");
    JButton Exit = new JButton("Exit");

    JTextField field = new JTextField();
    JLabel label = new JLabel("Write a letter");
    JLabel word = new JLabel("_ _ _ _ _ _ _ _ _ _");
    JLabel remainingLives = new JLabel(" remainingLives");
    JLabel usedChar = new JLabel("used : ");
    HangmanPanel zeichnung = new HangmanPanel();
    JLabel used =new JLabel("used");


    public void setButton(JButton button) {
        this.button = button;
    }

    final private Game game;

    public GUI(Game game) {
        this.game = game;
        chooseFrame.setSize(300, 300);
//        chooseFrame.setVisible(true);
        frame.setVisible(true);
        frame.setSize(600, 600);
        chooseFramePanel.setLayout(null);
        panel.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        chooseFrame.add(chooseFramePanel);
        label.setBounds(20, 400, 250, 20);
        word.setBounds(50, 80, 500, 20);
        remainingLives.setBounds(400, 50, 400, 20);
        field.requestFocusInWindow();

        used.setBounds(90 , 390 , 4000 , 200);

        panel.setBounds(50, 30, 290, 200);
        button.setBounds(140, 450, 100, 20);
        retry.setBounds(140, 450, 100, 20);
        Exit.setBounds(140, 450, 100, 20);
        field.setBounds(140, 400, 50, 20);
        usedChar.setBounds(100, 500, 400, 20);
        zeichnung.setBounds(350, 150, 200, 200);
        zeichnung.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        panel.add(zeichnung);
        panel.add(label);
        panel.add(field);
        panel.add(button);
        panel.add(word);
        panel.add(remainingLives);
        panel.add(usedChar);
        panel.add(used);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.isEnabled()){
                    if (field.getText().length() == 1) {
                        game.onGuess(field.getText().charAt(0));
                        field.setText("");
                    }
                }
            }
        });





        field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {


            }

            @Override
            public void keyPressed(KeyEvent e) {
                if ( e.getKeyCode() == KeyEvent.VK_ENTER){
                    if (field.getText().length() == 1) {
                        game.onGuess(field.getText().charAt(0));
                        field.setText("");
                    }


                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


    }

    public void update(int remainingLives, String Words, String incorrectlyGassedChar) {
        this.remainingLives.setText("!remainingLives : " + remainingLives);
        word.setText(Words);
        frame.repaint();

        usedChar.setText(incorrectlyGassedChar);
//        if (incorrectlyGassedChar.contains(field.getText()))
//            JOptionPane.showMessageDialog(frame, "already used");

        this.zeichnung.setRemainingLiefs(remainingLives);

        this.frame.repaint();
    }


    public void onLose() {
        JOptionPane.showMessageDialog(frame,  "Game over\nthe word was : " + game.getWord());
        if (retry.isEnabled())
            game.start();

    }

    public void onWin() {

        JOptionPane.showMessageDialog(frame, "you win\nthe word is : " + game.getWord());
        if (retry.isEnabled()) {
            game.start();

        }
    }


}

