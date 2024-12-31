package ex2.geo.geo;

import java.util.Arrays;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle_2D implements GeoShape {
	//data
	private Point_2D[] triArr;

//constructor
	/**
	 * Constructs a new Triangle_2D object with the specified points.
	 * @param p1 The first point.
	 * @param p2 The second point.
	 * @param p3 The third point.
	 */
	public Triangle_2D(Point_2D p1, Point_2D p2, Point_2D p3) {
		this.triArr = new Point_2D[]{p1, p2, p3};
	}
	/**
	 * Constructs a new Triangle_2D object that is a copy of the specified triangle.
	 * @param t1 The triangle to copy.
	 */
	public Triangle_2D(Triangle_2D t1) {
		this(t1.triArr[0], t1.triArr[1], t1.triArr[2]);
	}

	/**
	 * Constructs a new Triangle_2D object from the specified string representation.
	 * The string should contain coordinates of the three points separated by commas.
	 * @param t The string representation of the triangle.
	 */
    public Triangle_2D(String t) {
        String[] s = t.split(",");
        if (s.length != 6) {
            throw new IllegalArgumentException("Invalid input string format");
        }
        triArr = new Point_2D[3];
        for (int i = 0; i < 3; i++) {
            double x = Double.parseDouble(s[i * 2]);
            double y = Double.parseDouble(s[i * 2 + 1]);
            triArr[i] = new Point_2D(x, y);

        }
    }

	//methods
	/**
	 * Returns an array containing all the points of this triangle.
	 * @return An array containing all the points of this triangle.
	 */
	public Point_2D[] getAllPoints() {
		return triArr;
	}
	/**
	 * Checks if this triangle contains the specified point.
	 * @param ot The point to check.
	 * @return true if the point is inside this triangle, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		double areaABC = calculationArea(triArr[0], triArr[1], triArr[2]);
		double areaPAB = calculationArea(ot, triArr[0], triArr[1]);
		double areaPBC = calculationArea(ot, triArr[1], triArr[2]);
		double areaPCA = calculationArea(ot, triArr[2], triArr[0]);
		return areaABC == areaPAB + areaPBC + areaPCA;
	}
	/**
	 * Calculates the area of this triangle.
	 * @return The area of this triangle.
	 */
	@Override
	public double area() {
		return calculationArea(triArr[0], triArr[1], triArr[2]);
	}

	/**
	 * Calculates the perimeter of this triangle.
	 * @return The perimeter of this triangle.
	 */
	@Override
	public double perimeter() {
		double ans = 0;
		for (int i = 0; i < triArr.length; i++) {
			if (i + 1 == triArr.length) {
				ans += triArr[i].distance(triArr[0]);
			} else {
				ans += triArr[i].distance(triArr[i + 1]);
			}
		}
		return ans;
	}
	/**
	 * Translates this triangle by the specified vector.
	 * @param vec The vector to translate this triangle by.
	 */
	@Override
	public void translate(Point_2D vec) {
		for (int i = 0; i < triArr.length; i++) {
			this.triArr[i] = triArr[i].add(vec);
		}
	}
	/**
	 * Creates a copy of this triangle.
	 * @return A copy of this triangle.
	 */
	@Override
	public GeoShape copy() {
		Point_2D p1Copy = new Point_2D(this.triArr[0]);
		Point_2D p2Copy = new Point_2D(this.triArr[1]);
		Point_2D p3Copy = new Point_2D(this.triArr[2]);
		return new Triangle_2D(p1Copy, p2Copy, p3Copy);
    }
	/**
	 * Scales this triangle around the specified center point by the given ratio.
	 * @param center The center point for scaling.
	 * @param ratio The ratio by which to scale this triangle.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
			for (int i = 0; i < triArr.length; i++) {
				this.triArr[i].scale(center, ratio);
		}
	}
	/**
	 * Rotates this triangle around the specified center point by the given angle in degrees.
	 * @param center The center point for rotation.
	 * @param angleDegrees The angle in degrees by which to rotate this triangle.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		for (int i = 0; i < triArr.length; i++) {
			this.triArr[i].rotate(center, angleDegrees);
		}
	}
	/**
	 * Returns a string representation of this triangle.
	 * @return A string representation of this triangle.
	 */
	@Override
	public String toString() {
		return triArr[0] + "," + triArr[1]+ "," + triArr[2]; }

	/**
	 * Checks if this triangle is equal to the specified object.
	 * @param o The object to compare with.
	 * @return true if this triangle is equal to the specified object, false otherwise.
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Triangle_2D that = (Triangle_2D) o;
		return Arrays.equals(triArr, that.triArr);
	}
	/**
	 * Returns a hash code value for this triangle.
	 * @return A hash code value for this triangle.
	 */
	@Override
	public int hashCode() {
		return Arrays.hashCode(triArr);
	}

	//////my function
	/**
	 * Calculates the area of a triangle given its three points.
	 * @param a The first point of the triangle.
	 * @param b The second point of the triangle.
	 * @param c The third point of the triangle.
	 * @return The area of the triangle.
	 */
	public double calculationArea(Point_2D a, Point_2D b, Point_2D c){
		return Math.abs((a.x() * (b.y() - c.y()) + b.x() * (c.y() - a.y()) + c.x() * (a.y() - b.y())) * 0.5);
	}
}


