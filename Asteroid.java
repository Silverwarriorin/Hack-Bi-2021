import javax.swing.*;
import java.awt.*;

public class Asteroid extends JPanel{

    int xmax = 700, xmin = 50;
    int x = (int)(Math.random() * (xmax - xmin + 1) + xmin), y = (int)(Math.random() * (xmax - xmin + 1) + xmin);
    int max = 50, min = 15;
    int w = (int)(Math.random() * (max - min + 1) + min), h = w;
 
    public void glide(Asteroid arg)
    {
        arg.x += Math.random();
        arg.y += Math.random();
    }

    public void spawn(Graphics arg)
    {
        arg.setColor(Color.BLACK);
        arg.fillOval(x, y, w, h);
    }

}