import javax.swing.*;
import java.awt.*;

public class Asteroid extends JPanel{

    int x = 100, y = 100;
    int max = 50, min = 5;
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