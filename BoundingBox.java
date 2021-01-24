import java.awt.Polygon;
import java.util.Arrays;

public class BoundingBox {

    private Location[] pts;

    public BoundingBox(double x, double y, double w, double h)
    {
        pts = new Location[] {new Location((int)x,(int)y), new Location((int)(x+w), (int)y), new Location((int)(x+w),(int)(y+h)), new Location((int)x, (int)(y+h))};
    }

    public boolean contains(double x, double y)
    {
        Polygon p = new Polygon();
        for(Location pt : pts)
        {
            p.addPoint((int)pt.x, (int)pt.y);
        }
        return p.contains(x, y);
    }

    public int contains(BoundingBox b)
    {
        for (int k = 0; k < 4; k++)
            if (contains(b.getLocations()[k].x, b.getLocations()[k].y))
                return k;

        return -1;
    }

    public Location[] getLocations()
    {
        return pts;
    }

    public void translate(double dx, double dy)
    {
       for (Location pt : pts)
       {
           pt.translate(dx,dy);
       }
    }

    public String toString()
    {
        return Arrays.toString(getLocations());
    }

    public void setLocation(double cx, double cy)
    {
        double dx = cx - pts[0].x;
        double dy = cy - pts[0].y;

        for (Location pt : pts)
        {
            pt.x+=dx;
            pt.y+=dy;
        }
    }

    public Location getLocation()
    {
        return new Location ( pts[0].x, pts[0].y);
    }
}
