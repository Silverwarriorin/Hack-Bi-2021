import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.swing.JFrame;
import java.io.*;
import java.awt.event.*;



public class HackProject extends JPanel 
{
    
    public static void main(String[] args)
    {         
        JFrame frame = new JFrame("HackProject");
        frame.setSize(800, 800);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        HackProject driver = new HackProject();
        frame.add(driver);            
        
        

    }
    
    
    private static class Key extends KeyAdapter
    { 
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

   public void paintComponent(Graphics g)
   {
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
       RenderingHints.VALUE_ANTIALIAS_ON);

       Asteroid test = new Asteroid();
       test.spawn(g);
       test.glide(5, 5);
       
   }
    
    //testing push



}