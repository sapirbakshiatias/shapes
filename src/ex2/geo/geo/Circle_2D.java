package ex2.geo.geo;

import java.awt.geom.Point2D;

/**
 * This class represents a 2D circle in the plane.
 * Please make sure you update it according to the GeoShape interface.
 * Ex2: you should update this class!
 * @author boaz.benmoshe
 *
 */

public class Circle_2D implements GeoShape{


	public Point_2D get_center() {
		return _center;
	}

	//data
	private Point_2D _center;
	private double _radius;

	//constructor

	/**
	 * Constructs a Circle_2D with the specified center point and radius.
	 * @param cen The center point of the circle.
	 * @param rad The radius of the circle.
	 */
	public Circle_2D(Point_2D cen, double rad) {
		this._center = new Point_2D(cen);
		this._radius = rad;
	}

	/**
	 * Constructs a copy of the given Circle_2D object.
	 * @param c The Circle_2D object to copy.
	 */
	public Circle_2D(Circle_2D c) {
		this._center= new Point_2D(c._center);
		this._radius = c._radius;
	}

	/**
	 * Constructs a Circle_2D from a string representation.
	 * @param t The string representation of the Circle_2D object.
	 */
	public Circle_2D(String t) {
		String[] a = t.split(",");
		String s1 = a[0] + "," + a[1];
		this._center = new Point_2D(s1);
		this._radius = Double.parseDouble(a[2]);
	}

	/**
	 * Returns the radius of the circle.
	 * @return The radius of the circle.
	 */
	public double getRadius() {
		return this._radius;
	}

	/**
	 * Returns the center point of the circle.
	 * @return The center point of the circle.
	 */
	public Point_2D getCenter() {
		return _center;
	}

	/**
	 * Checks if a point is contained within the circle.
	 * @param ot The point to check.
	 * @return True if the point is inside or on the boundary of the circle, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		double dist = ot.distance(this._center);
		return dist <= this._radius;
	}

	/**
	 * Calculates the area of the circle.
	 * @return The area of the circle.
	 */
	@Override
	public double area() {
		return Math.PI * Math.pow(this._radius, 2);
	}

	/**
	 * Calculates the perimeter of the circle.
	 * @return The perimeter of the circle.
	 */
	@Override
	public double perimeter() {
		return Math.PI * this._radius * 2;
	}

	/**
	 * Translates the circle by a specified vector.
	 * @param vec The vector by which to translate the circle.
	 */
	@Override
	public void translate(Point_2D vec) {
		_center.move(vec);
	}

	/**
	 * Creates a copy of the circle.
	 * @return A new Circle_2D object that is a copy of this circle.
	 */
	@Override
	public GeoShape copy() {
		return new Circle_2D(this._center, this._radius);
	}

	/**
	 * Scales the circle by a specified ratio around a given center point.
	 * @param center The center point of the scaling operation.
	 * @param ratio The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		if (center == null || ratio == 1) {
			System.out.println("Invalid input");
			return;
		}
		_center.scale(center, ratio);
		this._radius *= ratio;
	}

	/**
	 * Rotates the circle around a specified center point by a given angle in degrees.
	 * @param center The center point of the rotation.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_center.rotate(center, angleDegrees);
	}

	/**
	 * Returns a string representation of the circle.
	 */
	@Override
	public String toString() {
		return _center.toString() + "," + _radius;
	}

	/**
	 * Checks if this circle is equal to another object.
	 * @param obj The object to compare to.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Circle_2D other = (Circle_2D) obj;
		return Double.compare(other._radius, _radius) == 0 && _center.equals(other._center);
	}
}