
package ex2.geo.geo;


/**
 * This class represents a 2D point in the plane.
 * Do NOT change this class! It would be used as is for testing.
 * Ex2: you should NOT change this class!
 * @author boaz.benmoshe
 */


public class Point_2D {
    //public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
    public static final Point_2D ORIGIN = new Point_2D(0,0);
    private double _x,_y;

    //constructor

    /**
     * Constructs a new Point_2D with the given x and y coordinates.
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     */
    public Point_2D(double x, double y) {
        _x = x;
        _y = y;
    }

    /**
     * Copy constructor that creates a new Point_2D with the same coordinates as the given point.
     * @param p The Point_2D to copy.
     */
    public Point_2D(Point_2D p) {
        this._x = p._x;
        this._y = p._y;
    }

    /**
     * Constructs a new Point_2D from a string in the format "x,y".
     * @param s The string representing the coordinates of the point.
     */
    public Point_2D(String s) {
        try {
            String[] a = s.split(",");
            _x = Double.parseDouble(a[0]);
            _y = Double.parseDouble(a[1]);
        }
        catch(IllegalArgumentException e) {
            System.err.println("ERR: got wrong format string for Point2D init, got:"+s+"  should be of format: x,y");
            throw(e);
        }
    }

    // Getters

    /**
     * Returns the x-coordinate of this point.
     * @return The x-coordinate of the point.
     */
    public double x() { return _x; }

    /**
     * Returns the y-coordinate of this point.
     * @return The y-coordinate of the point.
     */
    public double y() { return _y; }

    // Method

    /**
     * Returns the sum of this point and the given point.
     * @param p The point to add.
     * @return A new Point_2D representing the sum of this point and the given point.
     */
    public Point_2D add(Point_2D p) {
        Point_2D a = new Point_2D(p.x() + this.x(), p.y() + this.y());
        return a;
    }

    /**
     * Returns a string representation of this point in the format "x,y".
     * @return The string representation of this point.
     */
    public String toString() {
        return _x + "," + _y;
    }

    /**
     * Computes the Euclidean distance between this point and the origin (0,0).
     * @return The Euclidean distance between this point and the origin.
     */
    public double distance() {
        return this.distance(ORIGIN);
    }

    /**
     * Computes the Euclidean distance between this point and the given point.
     * @param p2 The point to compute the distance to.
     * @return The Euclidean distance between this point and the given point.
     */
    public double distance(Point_2D p2) {
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double t = (dx * dx + dy * dy);
        return Math.sqrt(t);
    }

    /**
     * Checks if this point is equal to the given object.
     * @param p The object to compare with.
     * @return true if the given object is a Point_2D with the same coordinates as this point, false otherwise.
     */
    @Override
    public boolean equals(Object p) {
        if(p == null || !(p instanceof Point_2D)) { return false; }
        Point_2D p2 = (Point_2D)p;
        return (this._x == p2._x) && (this._y == p2._y);
    }

    /**
     * Checks if this point is close to the given point within a specified epsilon.
     * @param p2 The point to compare with.
     * @param eps The epsilon value for the comparison.
     * @return true if the Euclidean distance between this point and the given point is less than epsilon, false otherwise.
     */
    public boolean close2equals(Point_2D p2, double eps) {
        return (this.distance(p2) < eps);
    }

    /**
     * Computes the vector from this point to the given target point.
     * @param target The target point.
     * @return A new Point_2D representing the vector from this point to the target point.
     */
    public Point_2D vector(Point_2D target) {
        double dx = target.x() - this.x();
        double dy = target.y() - this.y();
        return new Point_2D(dx, dy);
    }

    /**
     * Moves this point by adding the given vector to its coordinates.
     * @param vec The vector representing the translation.
     */
    public void move(Point_2D vec) {
        this._x += vec.x();
        this._y += vec.y();
    }

    /**
     * Scales this point with respect to the given center and ratio.
     * @param cen The center of scaling.
     * @param ratio The scaling ratio.
     */
    public void scale(Point_2D cen, double ratio) {
        double dx = this.x() - cen.x();
        double dy = this.y() - cen.y();
        dx *= ratio;
        dy *= ratio;
        _x = dx + cen.x();
        _y = dy + cen.y();
    }

    /**
     * Rotates this point around the given center by the specified angle (in degrees).
     * @param cen The center of rotation.
     * @param angleDegrees The angle of rotation in degrees.
     */
    public void rotate(Point_2D cen, double angleDegrees) {
        double angRad = Math.toRadians(angleDegrees);
        double dx = this.x() - cen.x();
        double dy = this.y() - cen.y();
        double ang = Math.atan2(dy, dx);
        double d = Math.sqrt(dx * dx + dy * dy);
        ang += angRad;
        dx = d * Math.cos(ang);
        dy = d * Math.sin(ang);
        _x = cen.x() + dx;
        _y = cen.y() + dy;
    }
}