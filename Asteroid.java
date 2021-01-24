import javax.swing.*;
import java.awt.*;
public class Asteroid extends JPanel{

    private static final long serialVersionUID = 1L;
    private double size, x, y, speed;
        
    //setting bounds for spawning x: -100 - 0 && 800 - 900 y: -100 - 0 && 800 - 900
    private int xmax, xmin, ymax, ymin;

    private BoundingBox bounds;

    public Asteroid(double speed)
    {
    	switch((int)(Math.random()*4)) {
        case 0 : 
      	  ymin = -30; 
      	  ymax = -10; 
      	  xmin = 25;
      	  xmax = 775;
        	  break;
        case 1 :
      	  ymin = 25; 
      	  ymax = 775; 
      	  xmin = -30;
      	  xmax = -10;
        	  break;
        case 2 :
      	  ymin = 830; 
      	  ymax = 810; 
      	  xmin = 25;
      	  xmax = 775;
        	  break;
        case 3 : 
      	  ymin = 25; 
      	  ymax = 775; 
      	  xmin = 830;
      	  xmax = 810;
        	  break;
      }

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

        if(this.myX() >= 800)
            setX(1);

        if(this.myY() >= 800)
            setY(1);
        
        if(this.myX() <= 0)
            setX(799);

        if(this.myY() <= 0)
            setY(799);
    }
    public void redraw(Graphics g)
    {
        g.setColor(Color.BLACK);
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

