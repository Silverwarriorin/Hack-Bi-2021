public class Location
{
    public double x,y;

    public Location(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Location clone()
    {
        return new Location(x, y);
    }

    public void translate(double dx, double dy)
    {
        x+=dx;
        y+=dy;
    }

    
}
