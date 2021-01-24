import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
public class Laser extends JPanel{
	
	private int x;
	private int y;
	private double direction;
	private double speed;
	private int width;
	private int height;
	private Vector2D vector;
	
	public Laser(double x, double y, Vector2D vect) {
		this.x = (int) x;
		this.y = (int) y;
		vector = vect.clone();
		width = 5;
		height = 5;
	}

	public boolean edgeCollision (int rightEdge, int bottomEdge) {
		if (x < 0) {
			return true;
		}
		else if (x > rightEdge) {
			return true;
		}
		else if (y < 0) {
			return true;
		}
		else if (y > bottomEdge) {
			return true;
		}
		return false;
	}
	
	public boolean hitAsteroid (Asteroid asteroid) {
		return asteroid.getBoundingBox().contains(x, y);
	}
	
	public void drive() {
		x += vector.getX();
		y += vector.getY();
	}
	
	public void draw(Graphics g) {		
		Graphics g2d = (Graphics2D) g;
		
		g2d.setColor(Color.yellow);
		g2d.fillRect((int) (x - width/2), (int) (y - height/2), width, height);
	}

	public void setVector(double speed, double direction) {
		vector.setVector(speed, direction);
	}
}