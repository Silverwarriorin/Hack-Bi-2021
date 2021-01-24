
public class Timer {
	private Long x;
	
	public Timer () {
		x = System.currentTimeMillis();
		
	}
	
	public long getTimeElapsed() {
		return (System.currentTimeMillis() - x)/1000;
	}

	public void reset()
	{
		x = System.currentTimeMillis();
	}
}
