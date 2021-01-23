


public class Vector
{
    double x, y;
    
    public Vector()
    {
    	
    }
    
    public void setVector(double speed, double radians)
    {
    	x = Math.cos(radians)*speed;
    	y = Math.sin(radians)*speed;
    }
    
    public Vector(double x, double y)
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
    
    public Vector clone
    {
    	return new Vector(x,y);
    }

}
