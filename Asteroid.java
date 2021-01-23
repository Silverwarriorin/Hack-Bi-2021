import javax.swing.*;
import java.awt.*;

public class Asteroid extends JPanel{

    int x = 100, y = 100;
    double w = Math.random(), h = Math.random();

    public void glide(Asteroid arg)
    {
        arg.x += Math.random();
        arg.y += Math.random();
    }

    public void spawn(Graphics arg)
    {
        arg.setColor(Color.BLACK);
        arg.fillOval(x, y, 50, 50);
    }

}