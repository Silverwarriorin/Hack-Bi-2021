
public class Clock {
	private double x;
	
	public Clock () {
		x = System.currentTimeMillis();
		
	}
	
	public double getTimeElapsed() {
		return System.currentTimeMillis() - x;
	}
}
