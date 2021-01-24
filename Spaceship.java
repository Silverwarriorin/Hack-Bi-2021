import java.awt.*; 
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.LinkedList;

public class Spaceship extends JPanel
{
    private double x, y, w, h, r, s;
	private Vector2D v;
	private BufferedImage srcImg, img;
	private LinkedList<Laser> lasers;
	private BoundingBox bounds;
	
	public Spaceship(LinkedList<Laser> lasers, double speed)
	{
		this.lasers = lasers;
		s = speed;
		try
		{
			srcImg = ImageIO.read(new File("spaceship.png"));
		}
		
		catch (Exception e)
		{
			System.out.println(e.toString() + e.getStackTrace());
		}
		
		img = srcImg;
		w = img.getWidth(null);
		h = img.getHeight(null);

		v = new Vector2D();
		bounds = new BoundingBox(0,0,w,h);
	}
	
	public void shoot()
	{
		lasers.add(new Laser(s*2, getShipX()+getShipWidth()/2, getShipY()+getShipHeight()/2, r));
	}
	
	public void drive()
	{
		if(v.getSpeed()!=0)
			v.setSpeed(s);
		x+=v.getX();
		y+=v.getY();
		bounds.translate(v.getX(), v.getY());

		checkBounds();
	}
	
	public void setY(double cy)
	{
		y = cy;
	}

	public void setX(double cx)
	{
		x = cx;

	}

	public void setShipLocation(double cx, double cy)
	{
		x = cx;
		y = cy;	

		bounds.setLocation(cx, cy);
	}
	
	public Vector2D getVector2D() {
		return v;
	}

	public void setVector(double speed, double direction)
	{
		v.setVector(speed, direction);
	}
	
	public void checkBounds()
    {
        if(getShipX() > 800)
        {
			setX(1);
			bounds.setLocation(1, bounds.getLocation().y);
        }

        if(getShipX() < 0)
        {
			setX(799);
			bounds.setLocation(799, bounds.getLocation().y);
        }

        if(getShipY() > 800)
        {
			setY(1);
			bounds.setLocation(bounds.getLocation().x, 1);
        }

        if(getShipY() < 0)
        {
			setY(799);
			bounds.setLocation(bounds.getLocation().x, 799);
        }
    }

	public void setSpeed(double s)
	{
		v.setVector(s, r);
	}
	
	public void setDirection(double rads)
	{
		v.setDirection(rads);
		if (r != rads)
		{
			BufferedImage output = new BufferedImage((int)w, (int)h, srcImg.getType());
			AffineTransform transform = new AffineTransform();
        	transform.rotate(rads+Math.toRadians(90), (int)w/2, (int)h/2);
        	double offset = (w-h)/2;
        	transform.translate(offset,offset);
			AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
			op.filter(srcImg, output);
			img = output;
		}

		r = rads;
	}
	
	public void setSize(double width, double height)
	{
		w = width;
		h = height;
	}
	
	public double getShipX() {
		return x;
	}
	
	public double getShipY() {
		return y;
	}
	
	public double getShipWidth()
	{
		return w;
	}

	public double getShipHeight()
	{
		return h;
	}

	public void redraw(Graphics g)
	{
		g.drawImage(img, (int)x, (int)y, this);
		g.drawRect((int)bounds.getLocations()[0].x, (int)bounds.getLocations()[0].y, (int)w, (int)h);
	}

	public double getDirection()
	{
		return Math.atan(v.getX()/v.getY());
	}

	public BoundingBox getBoundingBox()
	{
		return bounds;
	}
	
/*	public static void main(String[] args)
	{
		Spaceship panel = new Spaceship();
		
		 JFrame frame = new JFrame("HackProject");
	        frame.setSize(800, 800);
	        frame.setLocation(200, 100);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        
	        frame.add(panel);
	       panel.paintComponent(frame.getGraphics());
	       
	       panel.translate(100, 100);
	       
	       panel.rotate(Math.toRadians(180));
	        
	}*/
}

