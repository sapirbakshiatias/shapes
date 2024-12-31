package ex2.geo.geo;

import java.util.Comparator;

import ex2.ex2.Ex2_Const;
import ex2.gui.GUI_Shape;

/**
 * This class represents a Comparator over GUI_Shapes - 
 * as a linear order over GUI_Shapes.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeComp implements Comparator<GUI_Shape>{

	public static final ShapeComp CompByArea = new ShapeComp(Ex2_Const.Sort_By_Area);
	public static final ShapeComp CompByToString = new ShapeComp(Ex2_Const.Sort_By_toString);
	public static final ShapeComp CompByAntiToString = new ShapeComp(Ex2_Const.Sort_By_Anti_toString);
	public static final ShapeComp CompByAntiArea = new ShapeComp(Ex2_Const.Sort_By_Anti_Area);
	public static final ShapeComp CompByPerimeter = new ShapeComp(Ex2_Const.Sort_By_Perimeter);
	public static final ShapeComp CompByAntiPerimeter = new ShapeComp(Ex2_Const.Sort_By_Anti_Perimeter);
	public static final ShapeComp CompByTag = new ShapeComp(Ex2_Const.Sort_By_Tag);
	public static final ShapeComp CompByAntiTag = new ShapeComp(Ex2_Const.Sort_By_Anti_Tag);
	private int _flag;
	public ShapeComp(int flag) {
		_flag = flag;
	}


	/**
	 * Compares two GUI_Shape objects based on the specified flag.
	 * @param o1 The first object to be compared.
	 * @param o2 The second object to be compared.
	 * @return 1 if o1 is greater than o2, -1 if o1 is smaller than o2, and 0 if o1 and o2 are equal.
	 */
	@Override
	public int compare(GUI_Shape o1, GUI_Shape o2) {
		double a1=-1, a2 = -1;
		int ans =0;
		if(_flag == Ex2_Const.Sort_By_Area) {
			double d1 = o1.getShape().area();
			double d2 = o2.getShape().area();
			if(d1<d2) {ans  = -1;}
			if(d2<d1) {ans = 1;}
		}
		if(_flag == Ex2_Const.Sort_By_Anti_Area) {
			double d1 = o1.getShape().area();
			double d2 = o2.getShape().area();
			if(d1<d2) {ans  = 1;}
			if(d2<d1) {ans = -1;}
		}
		if(_flag == Ex2_Const.Sort_By_Perimeter) {
			double d1 = o1.getShape().area();
			double d2 = o2.getShape().area();
			if(d1<d2) {ans  = -1;}
			if(d2<d1) {ans = 1;}
		}
		if(_flag == Ex2_Const.Sort_By_Anti_Perimeter) {
			double d1 = o1.getShape().perimeter();
			double d2 = o2.getShape().perimeter();
			if(d1<d2) {ans  = 1;}
			if(d2<d1) {ans = -1;}
		}
		if(_flag == Ex2_Const.Sort_By_toString) {
			ans = o1.toString().compareTo(o2.toString());
		}
		if(_flag == Ex2_Const.Sort_By_Anti_toString) {
			ans = o1.toString().compareTo(o2.toString())*-1;
		}
		if(_flag == Ex2_Const.Sort_By_Tag) {
			double d1 = o1.getTag();
			double d2 = o2.getTag();
			if(d1<d2) {ans  = -1;}
			if(d2<d1) {ans = 1;}		}
		if(_flag == Ex2_Const.Sort_By_Anti_Tag) {
			double d1 = o1.getTag();
			double d2 = o2.getTag();
			if(d1<d2) {ans  = 1;}
			if(d2<d1) {ans = -1;}
		}
		return ans;
	}
}
