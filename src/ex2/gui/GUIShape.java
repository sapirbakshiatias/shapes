package ex2.gui;
/**
 * This class implements the GUI_shape.
 * Ex2: you should implement this class!
 * @author I2CS
 */
import ex2.geo.geo.*;

import java.awt.*;


public class GUIShape implements GUI_Shape{
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;

	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}

	public GUIShape(String s) {
		String[] parts = s.split(",");
		// Parsing the string to extract color, fill status, tag, and shape details.

		int rgb = Integer.parseInt(parts[1]);
		_color = new Color(rgb);
		_fill = Boolean.parseBoolean(parts[2]);
		_tag = Integer.parseInt(parts[3]);

		String shapeType = parts[4];
		GeoShape geoShape = null;

		// Creating the corresponding GeoShape based on shape type.
		switch (shapeType) {
			case "Circle_2D":
				double centerX = Double.parseDouble(parts[5]);
				double centerY = Double.parseDouble(parts[6]);
				double radius = Double.parseDouble(parts[7]);
				geoShape = new Circle_2D(new Point_2D(centerX, centerY), radius);
				break;

			case "Rect_2D":
				double x1 = Double.parseDouble(parts[5]);
				double y1 = Double.parseDouble(parts[6]);
				double x2 = Double.parseDouble(parts[7]);
				double y2 = Double.parseDouble(parts[8]);
				double x3 = Double.parseDouble(parts[9]);
				double y3 = Double.parseDouble(parts[10]);
				double x4 = Double.parseDouble(parts[11]);
				double y4 = Double.parseDouble(parts[12]);
				geoShape = new Rect_2D(new Point_2D(x1, y1), new Point_2D(x3, y3), new Point_2D(x2, y2),new Point_2D(x4, y4));

				break;

			case "Segment_2D":
				double x1s = Double.parseDouble(parts[5]);
				double y1s = Double.parseDouble(parts[6]);
				double x2s = Double.parseDouble(parts[7]);
				double y2s = Double.parseDouble(parts[8]);
				geoShape = new Segment_2D(new Point_2D(x1s, y1s), new Point_2D(x2s, y2s));

				break;

			case "Triangle_2D":
				double x1t = Double.parseDouble(parts[5]);
				double y1t = Double.parseDouble(parts[6]);
				double x2t = Double.parseDouble(parts[7]);
				double y2t = Double.parseDouble(parts[8]);
				double x3t = Double.parseDouble(parts[9]);
				double y3t = Double.parseDouble(parts[10]);
				geoShape = new Triangle_2D(new Point_2D(x1t, y1t), new Point_2D(x2t, y2t), new Point_2D(x3t, y3t));

				break;

			case "Polygon_2D":

				double[] coordinates = new double[(parts.length - 5)];
				for (int i = 0; i < (parts.length - 5); i++) {
					coordinates[i] = Double.parseDouble(parts[5 + i]);
				}


				int numPoints = coordinates.length / 2;


				Point_2D[] points = new Point_2D[numPoints];
				for (int i = 0; i < numPoints; i++) {
					points[i] = new Point_2D(coordinates[i * 2], coordinates[i * 2 + 1]);
				}


				geoShape = new Polygon_2D(points);

				break;

			default:
				throw new IllegalArgumentException("Unknown shape type: " + shapeType);
		}

		_g = geoShape;
	}

	@Override
	public GeoShape getShape() {
		return _g;
	}

	@Override
	public void setShape(GeoShape g) {
		_g = g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;

	}

	@Override
	public GUI_Shape copy() {
		GUI_Shape cp = new GUIShape(this);
		return cp;
	}
	@Override
	public String toString() {
		String ans = "" + this.getClass().getSimpleName()+ "," + colorEncoding(_color)+ "," +_fill+ "," + _tag + "," + this._g.getClass().getSimpleName() + "," + _g.toString();
		return ans;
	}
	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}

	/**
	 * Decoding the RGB values in HEX
	 *
	 * @param a - Samples the color in the RGB form
	 * @return returns the HEX value
	 */
	public int colorEncoding(Color a) {
		int r = a.getRed();
		int g = a.getGreen();
		int b = a.getBlue();
		return r * 256 * 256 + g *256+b;}
}
