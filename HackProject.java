import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.event.KeyListener;

public class HackProject extends JPanel {

    /**
     *
     */
	
	private static ActiveObject ticker;
    private static final long serialVersionUID = 1L;
    private Asteroid test = new Asteroid();
    private Spaceship ship = new Spaceship();



    public HackProject() 
    {
        ticker = new ActiveObject(this, 5);
        addKeyListener(new Key());
        setFocusable(true);
            
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("HackProject");
        frame.setSize(800, 800);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        HackProject driver = new HackProject();
        frame.add(driver); 
        driver.paintComponent(frame.getGraphics());
        
                  
        
        
        	//test
        
    }
    
    
    
    class Key implements KeyListener
    { 
      
      public void keyPressed(KeyEvent e)
      {
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
                ship.translate(0,-10);
                repaint();  
            }
                
            if(e.getKeyCode() == KeyEvent.VK_A)
            {
                ship.translate(-10,0);
                repaint();
            }
                

            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                ship.translate(10,0);
                repaint();
            }
                
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
                ship.translate(0,10);
                repaint();
            }
            System.out.println(e.toString());
      }

      public void keyTyped(KeyEvent e)
      {

      }

      public void keyReleased(KeyEvent e)
      {
        
      }
   }
   @Override
   public void paintComponent(Graphics g)
   {
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
       RenderingHints.VALUE_ANTIALIAS_ON);

       ship.drawShip(g);
       test.spawn(g);
       
       
   }
    
   //whatever you want to do on each tick (currently 5 millis apart, check construtor for ActiveObject ticker to change interval)
   public void tick()
   {
     test.glide(test);
   }
    //testing push



}