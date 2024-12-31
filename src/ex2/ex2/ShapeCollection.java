package ex2.ex2;

import ex2.geo.geo.Circle_2D;
import ex2.geo.geo.Point_2D;
import ex2.geo.geo.Polygon_2D;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import ex2.geo.geo.GeoShape;


import java.awt.*;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.*;

/**
 * This class represents a collection of GUI_Shape.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeCollection implements GUI_Shape_Collection {
	private ArrayList<GUI_Shape> _shapes;
	GUI_Shape _gs;


	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shape>();
	}
	@Override
	public GUI_Shape get(int i) {
		return _shapes.get(i);
	}

	@Override
	public int size() {
		return _shapes.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) {
		return _shapes.remove(i);
	}

	@Override
	public void addAt(GUI_Shape s, int i) {
		this._shapes.add(i, s);
	}

	@Override
	public void add(GUI_Shape s) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}
	}
	@Override
	public GUI_Shape_Collection copy() {
		return new ShapeCollection();
	}

	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		Collections.sort(this._shapes, comp);
	}

	@Override
	public void removeAll() {
		_shapes.removeAll(_shapes);
	}

	@Override
	public void save(String file) {
		try {
			File filePath = new File(file);
			FileOutputStream is = new FileOutputStream(filePath);
			OutputStreamWriter osw = new OutputStreamWriter(is);

			Writer w = new BufferedWriter(osw);

			for (int i = 0; i < _shapes.size(); i++) {
				GeoShape s = _shapes.get(i).getShape();
				String joined = s.toString();
				System.out.println(joined);
				w.write(_shapes.get(i).getClass().getSimpleName()+","+_shapes.get(i).getColor().getRGB()+","+_shapes.get(i).isFilled()+","+0+","+s.getClass().getSimpleName()+","+joined+"\n");
			}

			w.close();
		} catch (Exception e) {
			System.err.println("Problem writing to the file");
		}
	}

	public void load(String file) {
		_shapes.clear();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				GUIShape guiShape = new GUIShape(line);
				_shapes.add(guiShape);


			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i);
		}
		return ans;
	}


}
