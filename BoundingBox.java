import java.awt.Polygon;
import java.awt.Point;

public class BoundingBox {

    private Polygon box;

    public BoundingBox(double x, double y, double w, double h)
    {
        box = new Polygon(new int[]{(int)x, (int)(x+w), (int)(x+w), (int)x}, new int[]{(int)y, (int)(y+h), (int)y, (int)(y+h)}, 4);
    }

    public boolean contains(double x, double y)
    {
        return box.contains(x, y);
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
        return new Point[]
            {
                new Point(box.xpoints[0], box.ypoints[0]),
                new Point(box.xpoints[1], box.ypoints[1]),
                new Point(box.xpoints[2], box.ypoints[2]),
                new Point(box.xpoints[3], box.ypoints[3])
            };
    }

    public void translate(double dx, double dy)
    {
       box.translate((int)dx, (int)dy);
    }


    
}
