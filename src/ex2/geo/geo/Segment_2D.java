package ex2.geo.geo;

import ex2.ex2.Ex2_Const;

import java.util.Objects;

/**
 * This class represents a 2D segment on the plane, 
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Segment_2D implements GeoShape {


	//data
	private Point_2D _p1;
	private Point_2D _p2;

	//constructor
	/**
	 * Constructs a new Segment_2D with the given endpoints.
	 * @param p1 The first endpoint of the segment.
	 * @param p2 The second endpoint of the segment.
	 */
	public Segment_2D(Point_2D p1, Point_2D p2) {
		if (p1 == null || p2 == null) {
			return;
		}
		_p1 = new Point_2D(p1);
		_p2 = new Point_2D(p2);
	}
	/**
	 * Constructs a copy of the given Segment_2D.
	 * @param t1 The segment to copy.
	 */
	public Segment_2D(Segment_2D t1) {
		_p1 = new Point_2D(t1._p1);
		_p2 = new Point_2D(t1._p2);
	}
	/**
	 * Constructs a new Segment_2D from a string representation.
	 * The string should contain the coordinates of the two endpoints separated by commas.
	 * @param t The string representation of the segment.
	 * @throws IllegalArgumentException if the input string format is invalid.
	 */
	public Segment_2D(String t) {
		String[] s = t.split(",");
		if (s.length != 4) {
			throw new IllegalArgumentException("Invalid input string format");
		}
		_p1 = new Point_2D(Double.parseDouble(s[0]), Double.parseDouble(s[1]));
		_p2 = new Point_2D(Double.parseDouble(s[2]), Double.parseDouble(s[3]));
	}

	//method
	/**
	 * Checks if this segment contains the given point.
	 * @param ot The point to check.
	 * @return True if the point is contained within the segment, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		double dist = _p1.distance(_p2);
		double d1 = _p1.distance(ot);
		double d2 = ot.distance(_p2);
		return d1 + d2 < dist + Ex2_Const.EPS;
	}

	/**
	 * Calculates the perimeter of the segment.
	 * @return The perimeter of the segment.
	 */
	@Override
	public double perimeter() {
		double d = _p1.distance(_p2);
		return 2 * d;
	}
	/**
	 * Calculates the area of the segment.
	 * @return The area of the segment (always 0 for a segment).
	 */
	@Override
	public double area() {
		return 0;
	}
	/**
	 * Translates the segment by the specified vector.
	 * @param vec The vector by which to translate the segment.
	 */
	@Override
	public void translate(Point_2D vec) {
		this._p1 = _p1.add(vec);
		this._p2 = _p2.add(vec);
	}
	/**
	 * Creates a copy of the segment.
	 * @return A copy of the segment.
	 */
	@Override
	public GeoShape copy() {
		return new Segment_2D(_p1, _p2);
	}
	/**
	 * Scales the segment relative to the specified center point by the given ratio.
	 * @param center The center point for scaling.
	 * @param ratio The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		this._p1.scale(center, ratio);
		this._p2.scale(center, ratio);
	}
	/**
	 * Rotates the segment around the specified center point by the given angle in degrees.
	 * @param center The center point for rotation.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		this._p1.rotate(center, angleDegrees);
		this._p2.rotate(center, angleDegrees);
	}
	/**
	 * Returns a string representation of the segment.
	 * @return A string representation of the segment.
	 */
	@Override
	public String toString() {
		return _p1 + "," + _p2;
	}
	/**
	 * Checks if this segment is equal to another object.
	 * Two segments are considered equal if their endpoints are equal.
	 * @param obj The object to compare with.
	 * @return True if the segments are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Segment_2D other = (Segment_2D) obj;
		return Objects.equals(_p1, other._p1) && Objects.equals(_p2, other._p2);
	}

	public Point_2D get_p1() {
		return _p1;
	}

	public Point_2D get_p2() {
		return _p2;
	}
}