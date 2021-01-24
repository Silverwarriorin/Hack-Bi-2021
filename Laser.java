import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
public class Laser extends JPanel{
	
	private int x;
	private int y;
	private int w;
	private int h;
	private Vector2D v;
	private Location head;
	private BufferedImage img;
	
	public Laser(double x, double y, double rads)
	{
		this.x = (int) x;
		this.y = (int) y;
		v = new Vector2D();
		v.setVector(1, rads);
		head = new Location((int)x, (int)y);

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
	}

	public Location getHead()
	{
		return head;
	}
	
	public void drive() {
		x += v.getX();
		y += v.getY();
	}
	
	public void redraw(Graphics g) {		
		g.drawImage(img, x-img.getWidth()/2, y-img.getHeight()/2, this);
	}

	public void setVector(double speed, double direction) {
		v.setVector(speed, direction);
	}
}