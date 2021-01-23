


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Spaceship extends JPanel
{
    private double x, y, w, h, r;
	private Vector2D v;
	private BufferedImage srcImg;
	private BufferedImage img;

	
	public Spaceship()
	{
		loadImage();
	}
	
	private void loadImage()
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
	}
	
	public void translate(double dx, double dy)
	{
		x+=dx;
		y+=dy;
		
		repaint();
	}
	
	public void setY(double cy)
	{
		y = cy;
		repaint();
	}

	public void setX(double cx)
	{
		x = cx;
		repaint();
	}

	public void setShipLocation(double cx, double cy)
	{
		x = cx;
		y = cy;
		repaint();
	}
	
	public void checkboundingbox()
    {
        if(ship.getShipX() > 800)
        {
            ship.setX(1);
            repaint();
        }

        if(ship.getShipX() < 0)
        {
            ship.setX(799);
            repaint();
        }

        if(ship.getShipY() > 800)
        {
            ship.setY(1);
            repaint();
        }

        if(ship.getShipY() < 0)
        {
            ship.setY(799);
            repaint();
        }
    }

	public void rotate(double rads)
	{
		r = r+rads;
		final double sin = Math.abs(Math.sin(rads));
		final double cos = Math.abs(Math.cos(rads));
		final int w = (int) Math.floor(img.getWidth() * cos + srcImg.getHeight() * sin);
		final int h = (int) Math.floor(img.getHeight() * cos + srcImg.getWidth() * sin);
		final BufferedImage rotatedImage = new BufferedImage(w, h, srcImg.getType());
		final AffineTransform at = new AffineTransform();
		at.translate(w / 2, h / 2);
		at.rotate(rads,0, 0);
		at.translate(-srcImg.getWidth() / 2, -srcImg.getHeight() / 2);
		final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		rotateOp.filter(srcImg,rotatedImage);
		img = rotatedImage;
		repaint();
	}
	
	public void setSpeed(double s)
	{
		v.setSpeed(s);
	}
	
	public void setDirection(double radians)
	{
		v.setDirection(radians);
	}
	
	public void setSize(double width, double height)
	{
		w = width;
		h = height;
		
		repaint();
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

	public void drawShip(Graphics arg)
	{

        arg.drawImage(img, (int)x, 
            (int)y, this);
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

