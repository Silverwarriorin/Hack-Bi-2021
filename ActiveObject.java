class ActiveObject extends Thread implements Runnable{

	private boolean killed = false;
	private static int id = 1
	private double pauseTime = 5;
			
	private static final ThreadGroup GROUP = new ThreadGroup("HackProject");
	
	private HackProject cl;
	
    public ActiveObject(HackProject client, double pauseTime)
    {
    	super();
    	this.pauseTime = pauseTime;
    	
    	cl = client;
    }
    
    public void setPauseTime(double x)
    {
    	pauseTime = x;
    }
    
	public static void killAll() {
		final Thread[] threads = new Thread[GROUP.activeCount() + 20];
		final int length = GROUP.enumerate(threads);
		for(int i = 0; i < length; i++) {
			((ActiveObject)threads[i]).kill();
		}
	}
	
    public void kill()
    {
    	interrupt();
    	isKilled = true;
    }
    
    public boolean isKilled()
    {
    	return killed;
    }
    
	public static void pause(long millis, int nanos) {
		checkKilled();
		try {
			Thread.sleep(millis, nanos);
		} catch(InterruptedException e) {
		}
		checkKilled();
	}
	
	public static void pause(double millis)
	{
		pause((long)millis, 0);
	}
			
	public static void yield() {
		checkKilled();
		Thread.yield();
		checkKilled();
	}
	
	public void run()
	{
		super.run();
		cl.tick();
	}
	
	public void start()
	{
		super.start();
	}
}
