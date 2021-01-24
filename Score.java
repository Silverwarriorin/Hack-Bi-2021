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
}