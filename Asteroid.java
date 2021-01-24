import javax.swing.*;
import java.awt.*;
public class Asteroid extends JPanel{

    private static final long serialVersionUID = 1L;
    private double size, x, y, speed;
        
    //setting bounds for spawning x: -100 - 0 && 800 - 900 y: -100 - 0 && 800 - 900
    private int xmax = 0, xmin = -100, ymax = 900, ymin = 800;

    private BoundingBox bounds;

    public Asteroid(double speed)
    {
        this.speed = speed;
        size = (int)((Math.random()*3) + 1) * 15;
        x = (int)(Math.random() * (xmax - xmin)) + xmin;
        y = (int)(Math.random() * (ymax - ymin)) + ymin;

        bounds = new BoundingBox(x, y, size, size);
    }

    public void glide()
    {
        double dx = Math.random() * (speed);
        double dy = Math.random() * (speed);
        x+=dx;
        y+=dy;
        bounds.translate(dx, dy);
    }

    public void redraw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillOval((int)x, (int)y, (int)size, (int)size);

    }

    public double myX()
    {
        return x;
    }

    public double myY()
    {
        return y;
    }

    public void setY(double cy)
	{
		y = cy;

	}

	public void setX(double cx)
	{
		x = cx;

    }
    
    public BoundingBox getBoundingBox()
    {
        return bounds;
    }

    

}

