import java.awt.*; 
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

import HackProjectDevelopmentSpace.Laser;

import java.util.ArrayList;

public class Spaceship extends JPanel
{
    private double x, y, w, h, r;
	private Vector2D v;
	private BufferedImage srcImg, img;
	private ArrayList<Laser> lasers;
	private BoundingBox bounds;
	
	public Spaceship()
	{
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
		lasers = new ArrayList<Laser>();
		bounds = new BoundingBox(0,0,0,0);
	}
	
	public void shoot()
	{
		lasers.add(new Laser(getShipX(), getShipY(), v));
		lasers.get(laser.size - 1).setVector(v.getSpeed() * 2, v.getDirection());
	}
	
	public void drive()
	{
		x+=v.getX();
		y+=v.getY();
		bounds.translate(v.getX(), v.getY());
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
	}
	
	public Vector2D getVector2D() {
		return v;
	}

	public void setVector(double speed, double direction)
	{
		v.setVector(speed, direction);
	}
	
	public void checkboundingbox()
    {
        if(getShipX() > 800)
        {
            setX(1);
        }

        if(getShipX() < 0)
        {
            setX(799);
        }

        if(getShipY() > 800)
        {
            setY(1);
        }

        if(getShipY() < 0)
        {
            setY(799);
        }
    }

	public void setSpeed(double s)
	{
		v.setSpeed(s);
	}
	
	public void setDirection(double rads)
	{
		v.setDirection(rads);
		if (r != rads)
		{
			final BufferedImage rotatedImage = new BufferedImage((int)w, (int)h, srcImg.getType());
			AffineTransform at = new AffineTransform();
			at.translate(x + (w / 2), y + (h / 2));
			at.rotate(rads,x,y);
			at.translate(-img.getWidth() / 2, -img.getHeight() / 2);
			AffineTransformOp atOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
			if(!srcImg.equals(img))
				atOp.filter(srcImg, img);
			img = rotatedImage;
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

