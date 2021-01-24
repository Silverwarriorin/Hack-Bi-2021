import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
public class Laser extends JPanel{
	 
	private double x;
	private double y;
	private double w;
	private double h;
	private Vector2D v;
	private Location head;
	private BufferedImage img;
	
	public Laser(double s, double x, double y, double rads)
	{
		this.x = x;
		this.y = y;
		v = new Vector2D();
		v.setVector(s, rads);
		
		try
		{
			img = ImageIO.read(new File("laser.png"));
		}
		
		catch (Exception e)
		{
			System.out.println(e.toString() + e.getStackTrace());
		}

		BufferedImage output = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		AffineTransform transform = new AffineTransform();
		transform.rotate(v.getDirection()+Math.toRadians(90), img.getWidth()/2, img.getHeight()/2);
		double offset = (img.getWidth()-img.getHeight())/2;
		transform.translate(offset,offset);
		AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		op.filter(img, output);
		img = output;

		w = img.getWidth();
		h = img.getHeight();

		head = new Location (x + w/2, y + w/2);

	}

	public Location getHead()
	{
		return head;
	}
	
	public void drive() {
		x += v.getX();
		y += v.getY();
		head.x = x+w/2;
		head.y = y+h/2;
	}
	
	public void redraw(Graphics g) {		
		g.drawImage(img, (int)(x-img.getWidth()/2),(int)(y-img.getHeight()/2), this);
	}

	public void setVector(double speed, double direction) {
		v.setVector(speed, direction);
	}
}