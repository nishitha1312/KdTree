import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import java.util.Iterator;

public class PointSET {
    private final SET<Point2D> tree;

    // Initialize and empty `PointSET data structure.
    public PointSET() {
        this.tree = new SET<Point2D>();
    }

    // Return `true` or `false` if the `PointSET` is empty or not.
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    // Return the number of points in the `PointSET`.
    public int size() {
        return tree.size();
    }

    // Add the given point to the `PointSET` if the key is not already present
    // in the set.
    public void insert(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument cannot be null!");
        }

        tree.add(p);
    }

    // Returns `true` or `false` if the `PointSET` contains the given point.
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument cannot be null!");
        }

        if (tree.isEmpty()) return false;

        return tree.contains(p);
    }

    // Draw all points to standard draw.
    public void draw() {
        Iterator<Point2D> i = tree.iterator();

        while (i.hasNext()) {
            Point2D p = i.next();
            p.draw();
        }
    }

    // Returns an `Iterable<Point2D>` with all the points that are inside the
    // rectangle (or on the boundary).
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException("Argument cannot be null!");
        }

        Queue<Point2D> points = new Queue<Point2D>();
        Iterator<Point2D> i = tree.iterator();

        while (i.hasNext()) {
            Point2D p = i.next();
            if (rect.contains(p)) points.enqueue(p);
        }

        return points;
    }

    // Returns the nearest neighbor in the set to point p and null if the set is
    // empty.
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument cannot be null!");
        }

        if (tree.isEmpty()) return null;

        Iterator<Point2D> i = tree.iterator();

        Point2D currentPoint = i.next();
        Point2D nearest = currentPoint;

        double minimumDistance = p.distanceSquaredTo(currentPoint);

        while (i.hasNext()) {
            currentPoint = i.next();
            double currentDistance = p.distanceSquaredTo(currentPoint);

            if (currentDistance < minimumDistance) {
                minimumDistance = currentDistance;
                nearest = currentPoint;
            }
        }

        return nearest;
    }

    public static void main(String[] args) {
        Point2D p0 = new Point2D(0, 0);
        Point2D p1 = new Point2D(0.2, 0.2);
        Point2D p2 = new Point2D(0.2, 0.4);
        Point2D p3 = new Point2D(0.3, 0.2);
        Point2D p4 = new Point2D(0.5, 0.5);
        Point2D p5 = new Point2D(1.0, 1.0);

        System.out.println(p1.distanceSquaredTo(p2));

        PointSET pointSet = new PointSET();
        pointSet.insert(p1);
        pointSet.insert(p2);
        pointSet.insert(p3);
        pointSet.insert(p4);
        pointSet.insert(p5);

        System.out.println("Point set size: " + pointSet.size());
        System.out.println("Contains p0?: " + pointSet.contains(p0));
        System.out.println("Contains p3?: " + pointSet.contains(p3));

        RectHV rect = new RectHV(0.1, 0.1, 0.4, 0.3);
        Iterable<Point2D> range = pointSet.range(rect);

        for (Point2D p : range) {
            System.out.println(p);
        }

        System.out.println("Nearest point to p0?: " + pointSet.nearest(p0));
    }
}
