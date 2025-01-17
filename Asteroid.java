import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.image.BufferedImage;
public class Asteroid extends JPanel{

    private static final long serialVersionUID = 1L;
    private double size, speedX, speedY, x, y;
        
    //setting bounds for spawning x: -100 - 0 && 800 - 900 y: -100 - 0 && 800 - 900
    private double xmax, xmin, ymax, ymin;

    private BoundingBox bounds;
    private boolean approaching = true;
    private Vector2D vect;
    private BufferedImage img;

    public Asteroid(double speed, Spaceship ship)
    {

        size = (int)((Math.random()*3) + 1) * 15;
        vect = new Vector2D();
        String path;
        
        if(size==15)
                path = "small.png";
        else if (size==30)
                path = "medium.png";
        else 
                path = "large.png";

        try
		{
			img = ImageIO.read(new File(path));
		}
		
		catch (Exception e)
		{
			System.out.println(e.toString() + e.getStackTrace());
		}

        if(Math.random()>.5)
        {
            speedY = Math.random()*speed;
            speedX = speed-speedY;
        }
        else
        {
            speedX = Math.random()*speed;
            speedY = speed-speedX;
        }

        switch((int)(Math.random()*4))
        {
            //top
            case 0 : 
            ymin = -size; 
            ymax = -size; 
            xmin = 0;
            xmax = 800;
            if (Math.random()>.5)
                speedX*=-1;
            break;

            //left
            case 1 :
            ymin = 0; 
            ymax = 800; 
            xmin = -size;
            xmax = -size;
            if (Math.random()>.5)
                speedY*=-1;
            break;

            //bottom
            case 2 :
            ymin = 800; 
            ymax = 800; 
            xmin = 0;
            xmax = 800;
            if (Math.random()>.5)
                speedX*=-1;
            speedY*=-1;
            break;

            //right
            case 3 : 
            ymin = 0; 
            ymax = 800; 
            xmin = 800;
            xmax = 800;
            if (Math.random()>.5)
                speedY*=-1;
            speedX*=-1;
            break;
        }

        

        x = (int)(Math.random() * (xmax - xmin)) + xmin;
        y = (int)(Math.random() * (ymax - ymin)) + ymin;

        bounds = new BoundingBox(x, y, size, size);
        Math.atan2((y-(ship.getShipY()+(ship.getShipHeight()/2))), (x-(ship.getShipX()+(ship.getShipWidth()/2))));
    }

    public void drive()
    {
        x+=speedX;
        y+=speedY;
        bounds.translate(speedX, speedY);
    }

    public void newDirection(double speed, double rads) {
        vect.setVector(speed, rads);
        speedX = vect.getX();
        speedY = vect.getY();
    }

    public void redraw(Graphics g)
    {
        //g.setColor(Color.WHITE);
        //g.fillOval((int)x, (int)y, (int)size, (int)size);
        g.drawImage(img, (int)x, (int)y, this);
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

    public void activate()
    {
        approaching = false;
    }

    public boolean isActive()
    {
        return !approaching;
    }
}

