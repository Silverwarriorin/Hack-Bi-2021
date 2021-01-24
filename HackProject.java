import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.util.LinkedList;

public class HackProject extends JPanel {

  private Key klist;
  private Mouse mlist;
  private Motion molist;
  private static ActiveObject ticker;
  private static final long serialVersionUID = 1L;
  private Spaceship ship;
  private Timer timer;
  private Timer chargeTimer;
  private static final double shipSpeed = 1.5;
  private BoundingBox bounds;
  private LinkedList<Asteroid> asteroids = new LinkedList<Asteroid>();
  private LinkedList<Laser> lasers = new LinkedList<Laser>();
  private Score score;
  
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
    frame.addMouseMotionListener(driver.getMotionListener());
    frame.addMouseListener(driver.getMouseListener());
    frame.validate();
}

  public HackProject(double width, double height) 
  {
      setBackground(Color.BLACK);
      setFocusable(true);
      timer = new Timer();
      chargeTimer = new Timer();
      mlist = new Mouse(this);
      klist = new Key(this);
      molist = new Motion(this);
      ship = new Spaceship(lasers, shipSpeed);
      ship.setShipLocation(width/2,width/2);
      bounds = new BoundingBox(0,0,width,height);
      ticker = new ActiveObject(this, 10);
      score = new Score();

  }
    
  @Override
  public void paintComponent(Graphics g)
  {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);

      ship.redraw(g);
      for(int k = 0; k < asteroids.size(); k++)
      {
        asteroids.get(k).redraw(g);
      }
      for(int k = 0; k < lasers.size(); k++)
        lasers.get(k).redraw(g);

      g.drawString(score.dscore, 50, 50);
      g.drawString(score.dhscore, 50, 80);
  }

  //whatever you want to do on each tick (currently 5 millis apart, check construtor for ActiveObject ticker to change interval)
  public boolean tick()
  {
    ship.drive();
    boolean deleted = false;
    for(int k = 0; k < asteroids.size(); k++)
    {
      
      asteroids.get(k).drive();
      //if the asteroid is inside the panel, check its 
      if (asteroids.get(k).isActive())
      {
        
        if(bounds.contains(asteroids.get(k).getBoundingBox())<0)
        {
          asteroids.remove(k);
          k--;
          deleted = true;
        }  

        //if the ship contains the asteroid, end the round;
        else if(ship.getBoundingBox().contains(asteroids.get(k).getBoundingBox())>=0)
        {
          //round over
          System.out.println("Game Over");
          asteroids.remove(k);
          k--;
          resetGame();
          return true;
        }

        //if the asteroid contains a laser, remove it and the laser
        else for(int j = 0; j<lasers.size() && !deleted; j++)
          if(asteroids.get(k).getBoundingBox().contains(lasers.get(j).getHead().x, lasers.get(j).getHead().y))
          {
            asteroids.remove(k);
            k--;
            lasers.remove(j);
            j--;
            deleted = true;
            score.IncrementScore();
          }
      }

      //If the entire asteroid is inside the frame, activate it
      else
      {
        boolean allIn = true;
        for (Location pt : asteroids.get(k).getBoundingBox().getLocations())
          if (!bounds.contains(pt.x, pt.y))
           allIn = false;
        if(allIn)
        {
          asteroids.get(k).activate();
        }
      }
    }

    //if the laser leave the frame, remove it
    for(int j = 0; j < lasers.size() && !deleted; j++)
    {

      lasers.get(j).drive();
      if(!bounds.contains(lasers.get(j).getHead().x, lasers.get(j).getHead().y))
        {
          lasers.remove(j);
          j--;
          System.out.println("Laser removed");
        }
    }

    //n seconds interval
    if (timer.getTimeElapsed()>.25)
    {
      for (int i = 0; i < 4; i++)
        asteroids.add(new Asteroid(1.5, ship));

      asteroids.add(new Asteroid(1.5));
      timer.reset();
    }

    repaint(); 

    return false;
  }

  public void resetGame()
  {
    asteroids.clear();
    lasers.clear();
    ship.setShipLocation(getWidth()/2, getHeight()/2);
  }

  int ct;
  void p()
  {
    System.out.println(++ct);
  }

  public void keyPressed(KeyEvent e)
  {
    if(e.getKeyCode() == KeyEvent.VK_W)
    {
        ship.setSpeed(shipSpeed);
    }

    if(e.getKeyCode() == KeyEvent.VK_S)
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
    ship.setDirection(Math.atan2((e.getY()-(ship.getShipY()+(ship.getShipHeight()/2))), (e.getX()-(ship.getShipX()+(ship.getShipWidth()/2)))));
    
  }

  public void mouseReleased(MouseEvent e)
  {
    System.out.println(chargeTimer.getTimeElapsed());
    if (chargeTimer.getTimeElapsed()>.35)
    {
      ship.shoot();
      chargeTimer.reset();
    }
  }

  public Motion getMotionListener()
  {
    return molist;
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

class Mouse implements MouseListener
{

  private HackProject cl;


  public Mouse (HackProject driver)
  {
    cl = driver;
  }
  
  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
      cl.mouseReleased(e);
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }

}

class Motion implements MouseMotionListener
{

  private HackProject cl;

  public Motion (HackProject driver)
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

  public void mouseEntered(MouseEvent e)
  {

  }

  public void mouseExited(MouseEvent e)
  {

  }
}
