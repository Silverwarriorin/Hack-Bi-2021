
import java.awt.*;

public class Asteroid{


    /*public void move(double x, double y)
    {
        Vector AsteroidVector = new Vector();

        AsteroidVector.setVector(x, y);
    }*/

    public void spawn(Graphics arg)
    {
        arg.setColor(Color.BLACK);
        arg.fillOval(100, 100, 100, 100);
    }

}