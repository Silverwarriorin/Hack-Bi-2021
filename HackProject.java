import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.util.ArrayList;

public class HackProject extends JPanel {

  private Key klist;
  private Mouse mlist;
  private static ActiveObject ticker;
  private static final long serialVersionUID = 1L;
  private Asteroid test;
  private Spaceship ship;

  private double shipSpeed = 1.5;
  private double shipDirection = 0;
  private ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
  
  public HackProject() 
  {
      setBackground(Color.BLACK);
      setFocusable(true);
      klist = new Key(this);
      mlist = new Mouse(this);
      test = new Asteroid(1);
      ship = new Spaceship();
      ship.setSpeed(20);
      ticker = new ActiveObject(this, 10);

  }
  
  public static void main(String[] args) {
      JFrame frame = new JFrame("HackProject");
      frame.setBackground(Color.BLACK);
      frame.setSize(800, 800);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      frame.setVisible(true);
      HackProject driver = new HackProject();
      frame.add(driver); 
      driver.paintComponent(frame.getGraphics());
      frame.addKeyListener(driver.getKeyListener());
      frame.addMouseMotionListener(driver.getMouseListener());
  }
    
    
  @Override
  public void paintComponent(Graphics g)
  {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);

      ship.redraw(g);
      test.redraw(g);
  }

  //whatever you want to do on each tick (currently 5 millis apart, check construtor for ActiveObject ticker to change interval)
  public void tick()
   {
     test.glide();
     ship.drive();
     repaint(); 
   }
   
  public void keyPressed(KeyEvent e)
  {
    if(e.getKeyCode() == KeyEvent.VK_W)
    {
        ship.setVector(shipSpeed, shipDirection);
       
    }
  }

  public void keyReleased(KeyEvent e)
  {
    if(e.getKeyCode() == KeyEvent.VK_W)
    {
        ship.setSpeed(0);
        
    }
  }

  public Key getKeyListener()
  {
    return klist;
  }

  public Mouse getMouseListener()
  {
    return mlist;
  }

  public void mouseMoved(MouseEvent e)
  {
    shipDirection = Math.atan((e.getY()-ship.getShipY())/(e.getX()-ship.getShipX()));
    ship.setDirection(shipDirection);
    
    repaint();
  }

  public void mouseClicked(MouseEvent e)
  {
    
  }
}

class Key implements KeyListener
    { 
      
      HackProject cl;

      public Key(HackProject driver)
      {
        cl = driver;
      }

      public void keyPressed(KeyEvent e)
      {
            cl.keyPressed(e); 
      }

      public void keyTyped(KeyEvent e)
      {

      }

      public void keyReleased(KeyEvent e)
      {
        
      }
   }

  class Mouse implements MouseMotionListener, MouseListener
  {

    private HackProject cl;

    public Mouse (HackProject driver)
    {
       cl = driver;
    }

    public void mouseMoved(MouseEvent e)
    {
      cl.mouseMoved(e);
    }

    public void mouseDragged(MouseEvent e)
    {
      
    }

    public void mouseClicked(MouseEvent e)
    {
      cl.mouseClicked(e);
    }

    public void mousePressed(MouseEvent e)
    {

    }

    public void mouseReleased(MouseEvent e)
    {

    }

    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }

}