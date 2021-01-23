

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Laser {
	
	private int x;
	private int y;
	private double direction;
	private double speed;
	private int width;
	private int height;
	private Vector2D vector;
	
	public Laser(Spaceship player) {
		x = player.getX();
		y = player.getY();
		vector = new Vector2D(x, y);
		direction = vector.getDirection();
		speed = vector.getSpeed();
		width = 5;
		height = 5;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public double getSpeed() {
		return vector.getSpeed();
	}
	
	public double getDirection() {
		return vector.getDirection();
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
		double distanceToAsteroid = Math.sqrt(Math.pow(asteroid.getX() - x, 2) + Math.pow(asteroid.getY() - y, 2));
		if (distanceToAsteroid <= asteroid.getWidth()) {
			return true;
		}
		return false;
	}
	
	
	
	public void draw(Graphics g) {		
		Graphics g2d = (Graphics2D) g;
		
		g2d.setColor(Color.yellow);
		g2d.fillRect(x - width/2, y - height/2, width, height);
	}
}