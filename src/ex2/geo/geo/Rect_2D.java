package ex2.geo.geo;

import ex2.ex2.Ex2_Const;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author Sapir Bakshi
 *  ID - 212125660
 *  */

public class Rect_2D implements GeoShape {
	//data
	private Point_2D topLeft;
	private Point_2D bottomRight;
	private Point_2D topRight;
	private Point_2D bottomLeft;
	private Point_2D[] allPoints;


	//constructor

	/**
	 * Constructs a new Rect_2D object with the specified top-left and bottom-right corner points.
	 *
	 * @param p1 The top-left corner point.
	 * @param p2 The bottom-right corner point.
	 */
	public Rect_2D(Point_2D p1, Point_2D p2) {
		this.topLeft = new Point_2D(p1);
		this.bottomRight = new Point_2D(p2);
		this.topRight = new Point_2D(topLeft.x(), bottomRight.y());
		this.bottomLeft = new Point_2D(bottomRight.x(), topLeft.y());
	}

	/**
	 * Copy constructor that creates a deep copy of the given Rect_2D object.
	 *
	 * @param t1 The Rect_2D object to copy.
	 */
	public Rect_2D(Rect_2D t1) {
		this.topLeft = new Point_2D(t1.topLeft);
		this.bottomRight = new Point_2D(t1.bottomRight);
		this.topRight = new Point_2D(t1.topRight);
		this.bottomLeft = new Point_2D(t1.bottomLeft);
	}

	/**
	 * Constructor that creates a Rect_2D object from a string representation.
	 * The string should contain comma-separated x,y coordinates of the rectangle's corner points:
	 * x1,y1,x2,y2,x3,y3,x4,y4
	 *
	 * @param t The string representation of the rectangle.
	 */
	public Rect_2D(String t) {
		String[] a = t.split(",");
		String s1 = a[0] + "," + a[1];
		String s2 = a[2] + "," + a[3];
		String s3 = a[4] + "," + a[5];
		String s4 = a[6] + "," + a[7];

		topLeft = new Point_2D(s1);
		topRight = new Point_2D(s2);
		bottomRight= new Point_2D(s3);
		bottomLeft = new Point_2D(s4);
	}

	public Rect_2D(Point_2D rotatedTL, Point_2D rotatedTR, Point_2D rotatedBR, Point_2D rotatedBL) {
		this.topLeft = rotatedTL;
		this.topRight = rotatedTR;
		this.bottomRight = rotatedBR;
		this.bottomLeft = rotatedBL;
	}

	//method
	public Point_2D get_p1() {
		return new Point_2D(this.topLeft);
	}
	public Point_2D get_p2() {
		return new Point_2D(this.bottomLeft);
	}
		@Override
	public boolean contains(Point_2D ot) {
		Triangle_2D t1 = new Triangle_2D(ot, topLeft, bottomLeft);
		Triangle_2D t2 = new Triangle_2D(ot, topRight, bottomLeft);
		Triangle_2D t3 = new Triangle_2D(ot, topRight, bottomRight);
		Triangle_2D t4 = new Triangle_2D(ot, topLeft, bottomRight);
		double t1A = t1.area();
		double t2A = t2.area();
		double t3A = t3.area();
		double t4A = t4.area();

		return t1A + t2A + t3A + t4A < this.area() + Ex2_Const.EPS;
	}

	/**
	 * Calculates the area of the rectangle.
	 *
	 * @return The area of the rectangle.
	 */
	@Override
	public double area() {
		double len = topLeft.distance(topRight);
		double wid = topRight.distance(bottomRight);

		return len * wid;
	}

	/**
	 * Calculates the perimeter of the rectangle.
	 *
	 * @return The perimeter of the rectangle.
	 */
	@Override
	public double perimeter() {
		double h = topLeft.distance(topRight);
		double w = topRight.distance(bottomRight);
		return 2 * (h + w);
	}

	/**
	 * @param vec The vector by which to translate the rectangle.
	 */
	@Override
	public void translate(Point_2D vec) {
		this.topLeft.move(vec);
		this.topRight.move(vec);
		this.bottomRight.move(vec);
		this.bottomLeft.move(vec);
	}

	/**
	 * @return A  copy of the rectangle.
	 */
	@Override
	public GeoShape copy() {
		return new Rect_2D(this);

	}

	/**
	 * Scales the rectangle by the specified ratio with respect to the given center point.
	 *
	 * @param center The center point for scaling.
	 * @param ratio  The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		this.topLeft.scale(center, ratio);
		this.topRight.scale(center, ratio);
		this.bottomRight.scale(center, ratio);
		this.bottomLeft.scale(center, ratio);
	}

	/**
	 * Rotates the rectangle by the specified angle around the given center point.
	 *
	 * @param center       The center point for rotation.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		this.topLeft.rotate(center, angleDegrees);
		this.topRight.rotate(center, angleDegrees);
		this.bottomLeft.rotate(center, angleDegrees);
		this.bottomRight.rotate(center, angleDegrees);
	}

	/**
	 * Returns an array containing all the corner points of the rectangle.
	 *
	 * @return An array of Point_2D objects representing the rectangle's corner points.
	 */
	public Point_2D[] getAllPoints() {
		return new Point_2D[]{new Point_2D(this.topLeft), new Point_2D(this.topRight), new Point_2D(this.bottomRight), new Point_2D(this.bottomLeft)};
	}

	@Override
	public String toString() {
		return topLeft.toString() + "," + topRight.toString() + "," + bottomRight.toString() + "," + bottomLeft.toString();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Rect_2D rect2D = (Rect_2D) obj;
		Point_2D[] thisVertices = {this.topLeft, this.topRight, this.bottomRight, this.bottomLeft};
		Point_2D[] thatVertices = {rect2D.topLeft, rect2D.topRight, rect2D.bottomRight, rect2D.bottomLeft};

		for (int i = 0; i < thisVertices.length; i++) {
			boolean found = false;
			for (int j = 0; j < thatVertices.length; j++) {
				if (thisVertices[i].close2equals(thatVertices[j], Ex2_Const.EPS)) {
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}
		if (Math.abs(rect2D.area() - this.area()) <= Ex2_Const.EPS && Math.abs(rect2D.perimeter() - this.perimeter()) <= Ex2_Const.EPS) {
			return true;
		}

		return false;
	}



}
