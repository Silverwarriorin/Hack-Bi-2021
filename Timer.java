
public class Timer {
	private Long x;
	
	public Timer () {
		x = System.currentTimeMillis();
		
	}
	
	public long getTimeElapsed() {
		return (int)((System.currentTimeMillis() - x)/5);
	}
}
