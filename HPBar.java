

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HPBar {

	private int x;
	private int y;
	private int redRectWidth;
	private int height;
	
	public HPBar (Spaceship player) {
		x = player.getX();
		y = player.getY();
		redRectWidth = player.getShipWidth();
		height = 15;
	}
	
	public int determineFraction (Spaceship player) {
		return player.getCurrentHP() / player.getMaxHP();
	}
	
	public void draw(Graphics g, Spaceship player) {
		Graphics g2d = (Graphics2D) g;
		
		x = player.getX();
		y = player.getY();
		
		g2d.setColor(Color.red);
		// centers the hp bar underneath the ship if it works correctly
		g2d.fillRect(x - redRectWidth/2, y + player.getShipHeight()/2, redRectWidth, height);
		g2d.setColor(Color.green);
		// makes a second green rectangle to show how much hp is lost
		g2d.fillRect(x - redRectWidth/2, y + player.getShipHeight()/2, determineFraction(player) * redRectWidth, height);
	}
}