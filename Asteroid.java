import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Asteroid extends JPanel{

    private Timer t;

    

    public void glide(double x, double y)
    {
        x += Math.random();
        y += Math.random();
    }

    public void spawn(Graphics arg)
    {
        arg.setColor(Color.BLACK);
        arg.fillOval(100, 100, 50, 50);
    }

}