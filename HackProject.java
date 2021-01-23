import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;

public class HackProject extends JPanel {

    /**
     *
     */
	
	private static ActiveObject ticker;
    private static final long serialVersionUID = 1L;




    public HackProject() 
    {
        ticker = new ActiveObject(this, 5);
        addKeyListener(new Key());
        setFocusable(true);
            
    }
    Asteroid test = new Asteroid();
    Spaceship ship = new Spaceship();
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
    
    
    
    private static class Key extends KeyAdapter
    { 
      @Override
      public void keyPressed(KeyEvent e)
      {
             if(e.getKeyCode() == KeyEvent.VK_W){               
                
                }
             if(e.getKeyCode() == KeyEvent.VK_A){
               
               }
              if(e.getKeyCode() == KeyEvent.VK_D){
               
               }
             if(e.getKeyCode() == KeyEvent.VK_S){
               
               }
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