import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HPBar {

	private int x;
	private int y;
	private int redRectWidth;
	private int height;
	
	public HPBar (Spaceship player) {
		x = (int) player.getShipX();
		y = (int) player.getShipY();
		redRectWidth = (int) player.getShipWidth();
		height = 15;
	}
	
	public int determineFraction (Spaceship player) {
		return player.getCurrentHP() / player.getMaxHP();
	}
	
	public void draw(Graphics g, Spaceship player) {
		Graphics g2d = (Graphics2D) g;
		
		x = (int) player.getShipX();
		y = (int) player.getShipY();
		
		g2d.setColor(Color.red);
		// centers the hp bar underneath the ship if it works correctly
		g2d.fillRect(x - redRectWidth/2, y + (int) (player.getShipHeight()/2), redRectWidth, height);
		g2d.setColor(Color.green);
		// makes a second green rectangle to show how much hp is lost
		g2d.fillRect(x - redRectWidth/2, y + (int) (player.getShipHeight()/2), determineFraction(player) * redRectWidth, height);
	}
}