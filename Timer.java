
public class Timer {
	private double x;
	
	public Timer () {
		x = System.currentTimeMillis();
		
	}
	
	public double getTimeElapsed() {
		return System.currentTimeMillis() - x;
	}
}