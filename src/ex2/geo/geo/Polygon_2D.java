package ex2.geo.geo;

import java.util.Arrays;

public class Polygon_2D implements GeoShape {

	//data
	private Point_2D[] p_arr;

	//constructor

	public Polygon_2D() {
		p_arr = new Point_2D[0];
	}

	/**
	 * Copy constructor that creates a deep copy of the given Polygon_2D object.
	 * @param po The Polygon_2D object to copy.
	 */
	public Polygon_2D(Polygon_2D po) {
		Point_2D[] originalPoints = po.getAllPoints();
		this.p_arr = new Point_2D[originalPoints.length];
		for (int i = 0; i < originalPoints.length; i++) {
			this.p_arr[i] = new Point_2D(originalPoints[i]);
		}
	}
	/**
	 * Constructor that creates a Polygon_2D object from a string representation.
	 * The string should contain comma-separated x,y coordinates of the polygon's vertices.
	 * @param s The string representation of the polygon.
	 */
	public Polygon_2D(String s) {
		String[] points = s.split(",");
		int numPoints = points.length / 2;
		p_arr = new Point_2D[numPoints];

		for (int i = 0; i < numPoints; i++) {
			String x = points[i * 2];
			String y = points[i * 2 + 1];
			p_arr[i] = new Point_2D(Double.parseDouble(x), Double.parseDouble(y));
		}
	}

	public Polygon_2D(Point_2D[] points) {
	}


	//method
	/**
	 * Returns an array containing all the points of the polygon.
	 * @return An array of Point_2D objects representing the polygon's vertices.
	 */
	public Point_2D[] getAllPoints() {
		return Arrays.copyOf(p_arr, p_arr.length);
	}
	/**
	 * Adds a new point to the polygon.
	 * @param p The Point_2D object to add to the polygon.
	 */
	public void add(Point_2D p) {
		Point_2D[] newP_arr = Arrays.copyOf(p_arr, p_arr.length + 1);
		newP_arr[newP_arr.length - 1] = new Point_2D(p);
		p_arr = newP_arr;
	}
	/**
	 * Determines whether the polygon contains the specified point.
	 * @param ot The point to check for containment.
	 * @return True if the point is inside or on the boundary of the polygon, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
	double minX = p_arr[0].x();
	double maxX = p_arr[0].x();
	double minY = p_arr[0].y();
	double maxY = p_arr[0].y();
		for ( int i = 1 ; i < p_arr.length ; i++ )
	{
		Point_2D q = p_arr[ i ];
		minX = Math.min( q.x(), minX );
		maxX = Math.max( q.x(), maxX );
		minY = Math.min( q.y(), minY );
		maxY = Math.max( q.y(), maxY );
	}
		if ( ot.x() < minX || ot.x() > maxX || ot.y() < minY || ot.y() > maxY )
	{return false;}

	boolean inside = false;
		for ( int i = 0, j = p_arr.length - 1 ; i < p_arr.length ; j = i++ ){
		if ((p_arr[i].y()>ot.y()) != (p_arr[j].y()>ot.y()) &&
				ot.x()<(p_arr[j].x()-p_arr[i].x())*(ot.y()-p_arr[i].y())/(p_arr[j].y()-p_arr[i].y())+p_arr[i].x()){
			inside = !inside;
		}
	}
		return inside;
}

	/**
	 * Calculates the area of the polygon.
	 * @return The area of the polygon.
	 */
	@Override
	public double area() {
		double sum = 0;
		for (int i = 0; i < p_arr.length; i++) {
			if (i == 0) {
				sum += p_arr[i].x() * (p_arr[i + 1].y() - p_arr[p_arr.length - 1].y());
			} else if (i == p_arr.length - 1) {
				sum += p_arr[i].x() * (p_arr[0].y() - p_arr[i - 1].y());
			} else {
				sum += p_arr[i].x() * (p_arr[i + 1].y() - p_arr[i - 1].y());
			}
		}
		return 0.5 * Math.abs(sum);
	}
	/**
	 * Calculates the perimeter of the polygon.
	 * @return The perimeter of the polygon.
	 */
	@Override
	public double perimeter() {
		double ans = 0;
		for (int i = 0; i < p_arr.length; i++) {
			if (i + 1 == p_arr.length) {
				ans += p_arr[i].distance(p_arr[0]);
			} else {
				ans += p_arr[i].distance(p_arr[i + 1]);
			}
		}
		return ans;
	}
	/**
	 * Translates the polygon by the specified vector.
	 * @param vec The vector by which to translate the polygon.
	 */
	@Override
	public void translate(Point_2D vec) {
		for (int i = 0; i < p_arr.length; i++) {
			this.p_arr[i] = p_arr[i].add(vec);
		}
	}
	/**
	 * Creates a deep copy of the polygon.
	 * @return A deep copy of the polygon.
	 */
	@Override
	public GeoShape copy() {
		Polygon_2D copyP_arr = new Polygon_2D();
		copyP_arr.setPoints(getAllPoints());
		return copyP_arr;
	}

	/**
	 * Scales the polygon by the specified ratio with respect to the given center point.
	 * @param center The center point for scaling.
	 * @param ratio The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		for (int i = 0; i < p_arr.length; i++) {
			this.p_arr[i].scale(center, ratio);
		}
	}
	/**
	 * Rotates the polygon by the specified angle around the given center point.
	 * @param center The center point for rotation.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		for (int i = 0; i < p_arr.length; i++) {
			this.p_arr[i].rotate(center, angleDegrees);
		}
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Polygon_2D other = (Polygon_2D) obj;
		Point_2D[] otherPoints = other.getAllPoints();
		if (this.p_arr.length != otherPoints.length) return false;
		for (int i = 0; i < p_arr.length; i++) {
			if (!p_arr[i].equals(otherPoints[i])) return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String ans = "";
		for (int i = 0; i < p_arr.length; i++) {
			if(i<p_arr.length-1) {
				ans += p_arr[i].toString()+",";
			}else {
				ans += p_arr[i].toString();
			}
		}
		return ans;
	}

	//my functions
	public void setPoints(Point_2D[] points) {
		this.p_arr = Arrays.copyOf(points, points.length);
	}
}
