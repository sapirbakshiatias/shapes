package ex2.geo.test;
import ex2.ex2.Ex2_Const;
import ex2.geo.geo.Circle_2D;
import ex2.geo.geo.Point_2D;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import ex2.geo.geo.Rect_2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Circle_2DTest {

    private Point_2D center;
    private double radius;
    private Circle_2D circle;

    @BeforeEach
    public void c(){
        center = new Point_2D(1, 1);
        radius = 5;
        circle = new Circle_2D(center, radius);
    }

    @Test
    public void Constructor() {
        Circle_2D copiedCircle = new Circle_2D(circle);
        assertEquals(circle.getCenter(), copiedCircle.getCenter());
        assertEquals(circle.getRadius(), copiedCircle.getRadius());
    }
        @Test
        public void ConstructorS() {
            Circle_2D circle = new Circle_2D("3,5,7");
            assertEquals(3.0, circle.get_center().x(), 0.001);
            assertEquals(5.0, circle.get_center().y(), 0.001);
            assertEquals(7.0, circle.getRadius(), 0.001);
        }


    @Test
    public void GetCenter() {
        Point_2D r = circle.getCenter();
        assertEquals(r, center, String.valueOf(Ex2_Const.EPS));

    }

    @Test
    public void GetRadius() {
    Point_2D r = circle.getCenter();
    assertEquals(5, circle.getRadius());
    }

    @Test
    void contains() {
        assertTrue(circle.contains(new Point_2D(-4, 1)));

        assertTrue(circle.contains(new Point_2D(1, 5)));
        assertFalse(circle.contains(new Point_2D(7, 1)));
    }

    @Test
    void area() {
        assertEquals(Math.PI * Math.pow(5, 2), circle.area());
    }


    @Test
    void perimeter() {
        assertEquals(Math.PI * 5 * 2, circle.perimeter());
    }

    @Test
    void translate() {
        Point_2D translationVector = new Point_2D(3, -2);
        circle.translate(translationVector);

        assertEquals(4, circle.getCenter().x());
        assertEquals(-1, circle.getCenter().y());
    }

    @Test
    void copy() {
    Circle_2D copiedCircle = (Circle_2D) circle.copy();

    assertEquals(circle.getCenter(), copiedCircle.getCenter());
    assertEquals(circle.getRadius(), copiedCircle.getRadius());
}

    @Test
    void Scale() {
        double ratio = 2;
        circle.scale(center, ratio);

        assertEquals(10, circle.getRadius());
        assertEquals(1, circle.getCenter().x());
        assertEquals(1, circle.getCenter().y());
    }

    @Test
    void rotate() {
        circle.rotate(center, 90);

        assertEquals(1, circle.getCenter().x());
        assertEquals(1, circle.getCenter().y());
    }

    @Test
    void ToString() {
        String s = center.toString() + "," + radius ;
        assertEquals(circle.toString(),s);

    }
    @Test
    void Equals() {
        Circle_2D otherCircle = new Circle_2D(new Point_2D(1, 1), 5);
        assertTrue(circle.equals(otherCircle));

        Circle_2D differentCircle = new Circle_2D(new Point_2D(0, 0), 10);
        assertFalse(circle.equals(differentCircle));
    }
}
