import javax.swing.*;
import java.awt.*;

public class HangmanPanel extends JPanel {
    private int remainingLiefs;

    public void setRemainingLiefs(int remainingLiefs) {
        this.remainingLiefs = remainingLiefs;
    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);


        g.setColor(Color.BLACK);
        g.setColor(Color.WHITE);

        g.fillRect(0, 0, 200, 200);

        g.setColor(Color.BLACK);
        
        /*
            plase finde a better way to draw the lines for example you
            you can use for()
        */

        if (this.remainingLiefs < 12)
            g.drawLine(40, 180, 80, 180);
            if (this.remainingLiefs < 11)
            g.drawLine(60, 180, 60, 50);
        if (this.remainingLiefs < 10)
            g.drawLine(150, 50, 60, 50);
        if (this.remainingLiefs < 9)
            g.drawLine(70, 50, 60, 80);
        if (this.remainingLiefs < 8)
            g.drawLine(150, 50, 150, 80);
        if (this.remainingLiefs < 7)
            g.drawArc(140, 80, 25, 25, 0, 360);
        if (this.remainingLiefs < 6)
            g.drawLine(150, 105, 150, 150);
        if (this.remainingLiefs < 5)
            g.drawLine(150, 110, 130, 120);
        if (this.remainingLiefs < 4)
            g.drawLine(150, 110, 170, 120);
        if (this.remainingLiefs < 3)
            g.drawLine(150, 150, 135, 160);
        if (this.remainingLiefs < 2)
            g.drawLine(150, 150, 165, 160);



    }
}

