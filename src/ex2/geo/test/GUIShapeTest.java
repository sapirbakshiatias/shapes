package ex2.geo.test;

import ex2.geo.geo.Circle_2D;
import ex2.geo.geo.GeoShape;
import ex2.geo.geo.Point_2D;
import ex2.geo.geo.Rect_2D;
import ex2.gui.GUIShape;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GUIShapeTest {

    @Test
    void getShape() {
        Point_2D center = new Point_2D(5.0, 5.0);
        double radius = 3.0;
        Circle_2D circle = new Circle_2D(center, radius);
        GUIShape guiShape = new GUIShape(circle, true, Color.RED, 1);

        GeoShape result = guiShape.getShape();

        assertEquals(circle, result);
    }


    @Test
    void setShape() { Point_2D center1 = new Point_2D(5.0, 5.0);
        double radius1 = 3.0;
        Circle_2D circle1 = new Circle_2D(center1, radius1);
        GUIShape guiShape = new GUIShape(circle1, true, Color.RED, 1);

        Point_2D center2 = new Point_2D(10.0, 10.0);
        double radius2 = 5.0;
        Circle_2D circle2 = new Circle_2D(center2, radius2);

        guiShape.setShape(circle2);

        assertEquals(circle2, guiShape.getShape());
    }

    @Test
    void isFilled() {
        Point_2D center = new Point_2D(5.0, 5.0);
        double radius = 3.0;
        Circle_2D circle = new Circle_2D(center, radius);
        GUIShape guiShape = new GUIShape(circle, true, Color.RED, 1);

        boolean result = guiShape.isFilled();

        assertTrue(result);
    }

    @Test
    void setFilled() {
        Point_2D center = new Point_2D(5.0, 5.0);
        double radius = 3.0;
        Circle_2D circle = new Circle_2D(center, radius);
        GUIShape guiShape = new GUIShape(circle, true, Color.RED, 1);

        guiShape.setFilled(false);

        assertFalse(guiShape.isFilled());
    }

    @Test
    void getColor() {Point_2D center = new Point_2D(5.0, 5.0);
        double radius = 3.0;
        Circle_2D circle = new Circle_2D(center, radius);
        GUIShape guiShape = new GUIShape(circle, true, Color.RED, 1);

        Color color = guiShape.getColor();

        assertEquals(Color.RED, color);
    }

    @Test
    void setColor() {
        Point_2D center = new Point_2D(5.0, 5.0);
        double radius = 3.0;
        Circle_2D circle = new Circle_2D(center, radius);
        GUIShape guiShape = new GUIShape(circle, true, Color.RED, 1);

        guiShape.setColor(Color.BLUE);

        assertEquals(Color.BLUE, guiShape.getColor());
    }

    @Test
    void getTag() {
        Point_2D center = new Point_2D(5.0, 5.0);
        double radius = 3.0;
        Circle_2D circle = new Circle_2D(center, radius);
        GUIShape guiShape = new GUIShape(circle, true, Color.RED, 1);

        assertEquals(1, guiShape.getTag());
    }

    @Test
    void setTag() {
        Point_2D center = new Point_2D(5.0, 5.0);
        double radius = 3.0;
        Circle_2D circle = new Circle_2D(center, radius);
        GUIShape guiShape = new GUIShape(circle, true, Color.RED, 1);

        guiShape.setTag(2);

        assertEquals(2, guiShape.getTag());
    }

    @Test
    void copy() {
        Point_2D center = new Point_2D(5.0, 5.0);
        double radius = 3.0;
        Circle_2D circle = new Circle_2D(center, radius);
        GUIShape original = new GUIShape(circle, true, Color.RED, 1);

        GUIShape copied = (GUIShape) original.copy();

        assertNotSame(original, copied); // Make sure they are not the same instance
        assertEquals(original.getShape(), copied.getShape());
        assertEquals(original.isFilled(), copied.isFilled());
        assertEquals(original.getColor(), copied.getColor());
        assertEquals(original.getTag(), copied.getTag());
    }

    @Test
    void testToString() {
        Rect_2D rectangle = new Rect_2D(new Point_2D(1, 1), new Point_2D(3, 3));
//        GUIShape guiShape = new GUIShape(rectangle, true, Color.RED, 11);
//
//        String s1 = guiShape.toString();
//        GUI_Shape gs7 = new GUIShape(s1);
//        assertEquals(guiShape, gs7);
    }

    @Test
    void isSelected() {
        Point_2D center = new Point_2D(5.0, 5.0);
        double radius = 3.0;
        Circle_2D circle = new Circle_2D(center, radius);
        GUIShape guiShape = new GUIShape(circle, true, Color.RED, 1);

        assertFalse(guiShape.isSelected());
    }

    @Test
    void setSelected() { Point_2D center = new Point_2D(5.0, 5.0);
        double radius = 3.0;
        Circle_2D circle = new Circle_2D(center, radius);
        GUIShape guiShape = new GUIShape(circle, true, Color.RED, 1);

        guiShape.setSelected(true);

        assertTrue(guiShape.isSelected());
    }
}