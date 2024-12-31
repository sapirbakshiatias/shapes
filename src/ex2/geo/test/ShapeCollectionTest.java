package ex2.geo.test;

import ex2.ex2.GUI_Shape_Collection;
import ex2.ex2.ShapeCollection;
import ex2.geo.geo.Circle_2D;
import ex2.geo.geo.Point_2D;
import ex2.geo.geo.Rect_2D;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ShapeCollectionTest {
    private ShapeCollection arrayList;

    private Point_2D p1;
    private Point_2D p2;
    private double radius;
    private Circle_2D circle;
    private Rect_2D rect;

    GUI_Shape gs;
    GUI_Shape gs1;
    @BeforeEach
    void setUp(){
        p1 = new Point_2D(0,0);
        p2 = new Point_2D(2,2);
        radius = 2;
        circle = new Circle_2D(p1,radius);
        rect = new Rect_2D(p1,p2);
        gs = new GUIShape(rect, true, Color.black, 1);
        gs1 = new GUIShape(circle, true, Color.black, 1);
    }

    @Test
    void testShapeCollection() {
        ShapeCollection shapes = new ShapeCollection();
        assertNotNull(shapes);
    }

    @Test
    void testGet() {
        ShapeCollection shapes = new ShapeCollection();
        Point_2D center = new Point_2D(5, 5);
        Circle_2D circle = new Circle_2D(center, 3);
        GUIShape guiShape = new GUIShape(circle, true, Color.blue, 0);
        shapes.add(guiShape);

        assertEquals(circle, shapes.get(0).getShape());
    }

    @Test
    void testSize() {
        ShapeCollection shapes = new ShapeCollection();
        Point_2D center = new Point_2D(5, 5);
        Circle_2D circle = new Circle_2D(center, 3);
        GUIShape guiShape = new GUIShape(circle, true, Color.blue, 0);
        shapes.add(guiShape);

        assertEquals(1, shapes.size());
    }

    @Test
    void testRemoveElementAt() {
        ShapeCollection shapes = new ShapeCollection();
        Point_2D center = new Point_2D(5, 5);
        Circle_2D circle = new Circle_2D(center, 3);
        GUIShape guiShape = new GUIShape(circle, true, Color.blue, 0);
        shapes.add(guiShape);

        assertEquals(circle, shapes.removeElementAt(0).getShape());
        assertEquals(0, shapes.size());
    }

    @Test
    void testAddAt() {
        ShapeCollection shapes = new ShapeCollection();
        Point_2D center1 = new Point_2D(5, 5);
        Circle_2D circle1 = new Circle_2D(center1, 3);
        GUIShape guiShape1 = new GUIShape(circle1, true, Color.blue, 0);
        shapes.add(guiShape1);

        Point_2D center2 = new Point_2D(8, 8);
        Circle_2D circle2 = new Circle_2D(center2, 2);
        GUIShape guiShape2 = new GUIShape(circle2, true, Color.green, 1);
        shapes.addAt(guiShape2, 0);

        assertEquals(circle2, shapes.get(0).getShape());
    }

    @Test
    void testAdd() {
        ShapeCollection shapes = new ShapeCollection();
        Point_2D center = new Point_2D(5, 5);
        Circle_2D circle = new Circle_2D(center, 3);
        GUIShape guiShape = new GUIShape(circle, true, Color.blue, 0);
        shapes.add(guiShape);

        assertEquals(circle, shapes.get(0).getShape());
    }

    @Test
    void testCopy() {
        arrayList = new ShapeCollection();
        arrayList.add(gs);
        arrayList.add(gs1);

        GUI_Shape_Collection copiedList = arrayList.copy();

        assertTrue(arrayList.equals(copiedList));
    }

    @Test
    void testSort() {
        ShapeCollection shapes = new ShapeCollection();
        Point_2D center1 = new Point_2D(5, 5);
        Circle_2D circle1 = new Circle_2D(center1, 3);
        GUIShape guiShape1 = new GUIShape(circle1, true, Color.blue, 0);
        shapes.add(guiShape1);

        Point_2D center2 = new Point_2D(8, 8);
        Circle_2D circle2 = new Circle_2D(center2, 2);
        GUIShape guiShape2 = new GUIShape(circle2, true, Color.green, 1);
        shapes.add(guiShape2);

        Comparator<GUI_Shape> comp = Comparator.comparingDouble(s -> s.getShape().area());
        shapes.sort(comp);

        assertEquals(circle2, shapes.get(0).getShape());
    }

    @Test
    void testRemoveAll() {
        ShapeCollection shapes = new ShapeCollection();
        Point_2D center = new Point_2D(5, 5);
        Circle_2D circle = new Circle_2D(center, 3);
        GUIShape guiShape = new GUIShape(circle, true, Color.blue, 0);
        shapes.add(guiShape);

        shapes.removeAll();
        assertEquals(0, shapes.size());
    }

    @Test
    void testSave() {
        ShapeCollection shapes = new ShapeCollection();
        Point_2D center = new Point_2D(5, 5);
        Circle_2D circle = new Circle_2D(center, 3);
        GUIShape guiShape = new GUIShape(circle, true, Color.blue, 0);
        shapes.add(guiShape);

        String filePath = "testSave.txt";
        shapes.save(filePath);
    }

    @Test
    void testLoad() {
        ShapeCollection shapes = new ShapeCollection();
        String filePath = "testLoad.txt";

        shapes.load(filePath);
    }

    @Test
    void testToString() {
        String s1 = gs.toString();
        GUI_Shape gs7 = new GUIShape(s1);
        assertEquals(gs, gs7);
    }
}
