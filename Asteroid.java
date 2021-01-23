import javax.swing.*;
import java.awt.*;

public class Asteroid extends JPanel{

    private static final long serialVersionUID = 1L;
    
    // setting bounds for spawning max = 700 min = 50
    int xmax = 700, xmin = 50;
    int x = (int)(Math.random() * (xmax - xmin + 1) + xmin), y = (int)(Math.random() * (xmax - xmin + 1) + xmin);
    
    //setting bounds for size max = 50 min = 15
    int max = 50, min = 15;
    int w = (int)(Math.random() * (max - min + 1) + min), h = w;
 
    //I have no clue how to make this work
    public void glide(Asteroid arg)
    {
        arg.x += (int)(Math.random() * (10) + 1);
        arg.y += (int)(Math.random() * (10) + 1);

        repaint();
    }

    //spawn method
    public void spawn(Graphics arg)
    {
        arg.setColor(Color.BLACK);
        arg.fillOval(x, y, w, h);
    }

}

