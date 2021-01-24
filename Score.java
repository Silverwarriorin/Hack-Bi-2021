import java.awt.*;
public class Score 
{
    private int sc, hs;

    public void increment()
    {
        sc++;
        if(sc>hs)
            hs = sc;
    }

    public String getScore()
    {
        return Integer.toString(sc);
    }

    public String getHighScore()
    {
        return Integer.toString(hs);
    }

    public void redraw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.drawString(getScore(), 50, 50);
        g.drawString(getHighScore(), 50, 80);
    }

    public void reset()
    {
        sc = 0;
    }
}