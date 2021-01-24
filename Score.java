public class Score 
{
    private int score, highscore;
    public String dscore, dhscore;

    public Score()
    {
        int score = 0;
        int highScore = 0;
    }

    public void IncrementScore()
    {
        score++;
    }

    public String CurrentScore()
    {
        dscore = Integer.toString(score);
        return dscore;
    }

    public String HighScore()
    {
        if(score >= highscore)
            highscore = score;
        else
            return Integer.toString(highscore);

        dhscore = Integer.toString(highscore);

        return dhscore;
    }
}