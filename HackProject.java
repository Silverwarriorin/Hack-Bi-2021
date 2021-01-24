import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.util.LinkedList;

public class HackProject extends JPanel {

  private Key klist;
  private Mouse mlist;
  private static ActiveObject ticker;
  private static final long serialVersionUID = 1L;
  private Asteroid test;
  private Spaceship ship;
  private Timer timer;
  private double shipSpeed = 1.5;
  private double shipDirection = 0;
  private BoundingBox bounds;
  private LinkedList<Asteroid> asteroids = new LinkedList<Asteroid>();
  private LinkedList<Laser> lasers = new LinkedList<Laser>();
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("HackProject");
    frame.setBackground(Color.BLACK);
    frame.setSize(800, 800);
    frame.setLocation(200, 100);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setVisible(true);
    HackProject driver = new HackProject(800, 800);
    frame.add(driver); 
    driver.paintComponent(frame.getGraphics());
    frame.addKeyListener(driver.getKeyListener());
    frame.addMouseMotionListener(driver.getMouseListener());
    frame.validate();
}

  public HackProject(double width, double height) 
  {
      setBackground(Color.BLACK);
      setFocusable(true);
      klist = new Key(this);
      mlist = new Mouse(this);
      asteroids.add(new Asteroid(1));
      ship = new Spaceship(lasers);
      ship.setShipLocation(400,400);
      bounds = new BoundingBox(0,0,width,height);
      timer = new Timer();
      ticker = new ActiveObject(this, 10);
  }
    
  @Override
  public void paintComponent(Graphics g)
  {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);

      ship.redraw(g);
      for(Asteroid a : asteroids)
      {
        a.redraw(g);
      }
      for(Laser lz : lasers)
        lz.redraw(g);
  }

  //whatever you want to do on each tick (currently 5 millis apart, check construtor for ActiveObject ticker to change interval)
  public void tick()
   {
    ship.drive();
    for(int k = 0; k < asteroids.size(); k++)
    {
      asteroids.get(k).drive();
      for(int j = 0; j<lasers.size(); j++)
      {
        if(asteroids.get(k).getBoundingBox().contains(lasers.get(j).getHead().x, lasers.get(j).getHead().y))
        {
          asteroids.remove(k);
          k--;
          lasers.remove(j);
          j--;
        }
        if(bounds.contains(asteroids.get(k).getBoundingBox())<0)
        {
          asteroids.remove(k);
          k--;
        }
      }
      if (ship.getBoundingBox().contains(asteroids.get(k).getBoundingBox())>=0)
        ;//ENDROUND
     // if(bounds)
    }

    for(int j = 0; j < lasers.size(); j++)
    {
      if(!bounds.contains(lasers.get(j).getHead().x, lasers.get(j).getHead().y))
        {
          lasers.remove(j);
          j--;
        }
    }
      

    //%n==0 where n is seconds passed
    if (timer.getTimeElapsed()%2==0)
    {
      asteroids.add(new Asteroid(Math.random()+.25));
    }
     repaint(); 
   }
   
  public void keyPressed(KeyEvent e)
  {
    if(e.getKeyCode() == KeyEvent.VK_W)
    {
        ship.setSpeed(2);
    }
  }

  public void keyReleased(KeyEvent e)
  {
    if(e.getKeyCode() == KeyEvent.VK_W)
    {
        ship.setShipLocation(ship.getShipX(),ship.getShipY());
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
    ship.setDirection(Math.atan2((e.getY()-(ship.getShipY()+(ship.getShipHeight()/2))), (e.getX()-(ship.getShipX()+(ship.getShipWidth()/2)))));
  }

  public void mouseClicked(MouseEvent e)
  {
    ship.shoot();
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
