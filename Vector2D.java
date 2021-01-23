


public class Vector2D
{
    double x, y;
    
    public Vector2D()
    {
    	
    }
    
    public void setVector(double speed, double radians)
    {
    	x = Math.cos(radians)*speed;
    	y = Math.sin(radians)*speed;
    }
    
    public Vector2D(double x, double y)
    {
    	this.x=x;
    	this.y=y;
    }
    
    public double getSpeed()
    {
    	return y/Math.sin(Math.atan(y/x));
    }
    
    public double getDirection()
    {
    	return Math.atan(y/x);
    }
    
    public double getX()
    {
    	return x;
    }
    
    public double getY()
    {
    	return y;
    }
    
    public void setSpeed(double s)
    {
    	x = Math.cos(getDirection())*s;
    	y = Math.sin(getDirection())*s;
    }
    
    public void setDirection(double radians)
    {
    	x = Math.cos(radians)*getSpeed();
    	y = Math.sin(radians)*getSpeed();
    }
    
    public Vector2D clone()
    {
    	return new Vector2D(x,y);
    }
    
    public String toString()
    {
    	return "y: " + x + " y: " + y + " speed: " + getSpeed() + " direction: " + Math.toDegrees(getDirection());
    }

}
