import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HPBar extends JPanel{

	private int x;
	private int y;
	private int rectWidth;
	private int height;
	private Color color;
	
	public HPBar (Spaceship player) {
		x = (int) player.getShipX();
		y = (int) player.getShipY();
		rectWidth = (int) player.getShipWidth();
		height = 15;
		color = Color.green;
	}
	
	public void deadBoi() {
		color = Color.red;
	}
	
	public void draw(Graphics g, Spaceship player) {
		Graphics g2d = (Graphics2D) g;
		
		x = (int) player.getShipX();
		y = (int) player.getShipY();
		
		// centers the hp bar underneath the ship if it works correctly
		g2d.setColor(color);
		g2d.fillRect(x - rectWidth/2, y + (int) (player.getShipHeight()/2), rectWidth, height);
	}
}