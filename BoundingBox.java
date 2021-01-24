import java.awt.Polygon;
import java.util.Arrays;
import java.awt.Point;

public class BoundingBox {

    private Point[] pts;

    public BoundingBox(double x, double y, double w, double h)
    {
        pts = new Point[] {new Point((int)x,(int)y), new Point((int)(x+w), (int)y), new Point((int)(x+w),(int)(y+h)), new Point((int)x, (int)(y+h))};
    }

    public boolean contains(double x, double y)
    {
        Polygon p = new Polygon();
        for(Point pt : pts)
        {
            p.addPoint(pt.x, pt.y);
        }
        return p.contains(x, y);
    }

    public int contains(BoundingBox b)
    {
        for (int k = 0; k < 4; k++)
            if (contains(b.getPoints()[k].x, b.getPoints()[k].y))
                return k;

        return -1;
    }

    public Point[] getPoints()
    {
        return pts;
    }

    public void translate(double dx, double dy)
    {
       for (Point pt : pts)
       {
           pt.x+=dx;
           pt.y+=dy;
       }
    }

    public String toString()
    {
        return Arrays.toString(getPoints());
    }
}
