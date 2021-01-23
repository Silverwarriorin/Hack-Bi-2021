import javax.swing.*;
import java.awt.*;


public class Asteroid extends JPanel{

    private static final long serialVersionUID = 1L;
    private int size, x, y;
    
    //setting bounds for spawning x: -100 - 0 && 800 - 900 y: -100 - 0 && 800 - 900
    private int xmax = 0, xmin = -100, ymax = 900, ymin = 800;

    public Asteroid()
    {
        size = (int)((Math.random()*3) + 1) * 15;
        x = (int)(Math.random() * (xmax - xmin + 1) + xmin);
        y = (int)(Math.random() * (ymax - ymin + 1) + ymin);

    }

    
    

 
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
        arg.fillOval(x, y, size, size);
    }

    

}

