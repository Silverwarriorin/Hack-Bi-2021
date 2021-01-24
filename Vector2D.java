public class Vector2D
{
    private double x, y;
    
    public Vector2D()
    {
        
    }

    public Vector2D(double x, double y)
    {
        this.x=x;
        this.y=y;
    }

    public double getSpeed()
    {
        if (Math.sin(Math.atan2(y, x))==0)
            return y;
        return y/Math.sin(Math.atan2(y, x));
    }
    
    public double getDirection()
    {
        return Math.atan2(y, x);
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

    public void setVector(double speed, double radians)
    {
        x = Math.cos(radians)*speed;
        y = Math.sin(radians)*speed;
    }

    public void setX(double x)
    {
        this.x = x;
    }
    
    public void setY(double y)
    {
        this.y = y;
    }

    public Vector2D clone()
    {
        return new Vector2D(x,y);
    }
    
    public String toString()
    {
        return "x: " + x + " y: " + y + " speed: " + getSpeed() + " direction: " + Math.toDegrees(getDirection());
    }

}