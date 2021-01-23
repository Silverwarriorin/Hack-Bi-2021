


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Spaceship extends JPanel
{
    private double x, y, w, h;
	private Vector v;
	private BufferedImage img;
	
	public Spaceship()
	{
		loadImage();
	}
	
	private void loadImage()
	{
		try
		{
			img = ImageIO.read(new File("E:\\gitshit\\Hack-Bi-2021\\spaceship.png"));
		}
		
		catch (Exception e)
		{
			System.out.println(e.toString() + e.getStackTrace());
		}
		
		
		w = img.getWidth(null);
		h = img.getHeight(null);
	}
	
	public void translate(double dx, double dy)
	{
		x+=dx;
		y+=dy;
		
		repaint();
	}
	
	public void setLocation(double cx, double cy)
	{
		x = cx;
		y = cy;
		
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
	
	public double getShipWidth()
	{
		return w;
	}
	

	public double getShipHeight()
	{
		return h;
	}
@Override
	public void paintComponent(Graphics g)
	{
		
		Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(img, (int)x, 
            (int)y, this);
	}
	
	
	public static void main(String[] args)
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
	        
	}
	



}

