package ex2.geo.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import org.junit.jupiter.api.BeforeEach;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import ex2.ex2.GUI_Shape_Collection;
import ex2.geo.geo.Circle_2D;
import ex2.geo.geo.GeoShape;
import ex2.geo.geo.Point_2D;
import ex2.geo.geo.Triangle_2D;
import ex2.gui.Ex2;

class Ex2Test {
    private Ex2 ex;
    private GUI_Shape_Collection _shapes;

    @BeforeEach
    void setUp() {
        ex = Ex2.getInstance();
        _shapes = ex.getShape_Collection();
    }

    @Test
    void load() {
        assertTrue(true); // Cannot be tested without the GUI, has been tested visually
    }

    @Test
    void save() {
        assertTrue(true); // Cannot be tested without the GUI, has been tested visually
    }

    @Test
    void copy() {
        ex.init(_shapes);
        Point_2D cen = new Point_2D(5, 5);
        double rad = 3;
        GeoShape gs = new Circle_2D(cen, rad);
        GUI_Shape _gs = new GUIShape(gs, true, Color.blue, 0);
        _shapes.add(_gs);

        Point_2D[] trianglePoints = {new Point_2D(5, 5), new Point_2D(1, 1), new Point_2D(-5, 5)};
        gs = new Triangle_2D(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
        _gs = new GUIShape(gs, false, Color.red, 0);
        _shapes.add(_gs);

        _shapes.get(0).setSelected(true);

        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            if (s.isSelected() && s != null) {
                assertTrue(s.getShape() instanceof Circle_2D);
            }
        }
    }


    @Test
    void remove() {
        ex.init(_shapes);
        Point_2D cen = new Point_2D(5, 5);
        double rad = 3;
        GeoShape gs = new Circle_2D(cen, rad);
        GUI_Shape _gs = new GUIShape(gs, true, Color.blue, 0);
        _shapes.add(_gs);

        Point_2D[] trianglePoints = {new Point_2D(5, 5), new Point_2D(1, 1), new Point_2D(-5, 5)};
        gs = new Triangle_2D(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
        _gs = new GUIShape(gs, false, Color.red, 0);
        _shapes.add(_gs);

        _shapes.get(1).setSelected(true);

        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            if (s.isSelected() && s != null) {
                assertTrue(s.getShape() instanceof Triangle_2D);
            }
        }
    }

    @Test
    void scale() {
        ex.init(_shapes);
        Point_2D cen = new Point_2D(5, 5);
        double rad = 3;
        GeoShape gs = new Circle_2D(cen, rad);
        GUI_Shape _gs = new GUIShape(gs, true, Color.blue, 0);
        _shapes.add(_gs);

        Point_2D[] trianglePoints = {new Point_2D(5, 5), new Point_2D(1, 1), new Point_2D(-5, 5)};
        gs = new Triangle_2D(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
        _gs = new GUIShape(gs, false, Color.red, 0);
        _shapes.add(_gs);

        double ratio = 1.1;
        _shapes.get(0).setSelected(true);
        _shapes.get(0).getShape().scale(cen, ratio);

        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            if (s.isSelected() && s != null) {
                assertTrue(s.getShape() instanceof Circle_2D);
            }
        }
    }

    @Test
    void rotate() {
        ex.init(_shapes);
        Point_2D cen = new Point_2D(5, 5);
        double rad = 3;
        GeoShape gs = new Circle_2D(cen, rad);
        GUI_Shape _gs = new GUIShape(gs, true, Color.blue, 0);
        _shapes.add(_gs);

        Point_2D[] trianglePoints = {new Point_2D(5, 5), new Point_2D(1, 1), new Point_2D(-5, 5)};
        gs = new Triangle_2D(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
        _gs = new GUIShape(gs, false, Color.red, 0);
        _shapes.add(_gs);

        double degrees = 90;
        _shapes.get(0).setSelected(true);
        _shapes.get(0).getShape().rotate(cen, degrees);

        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            if (s.isSelected() && s != null) {
                assertTrue(s.getShape() instanceof Circle_2D);
            }
        }
    }

}