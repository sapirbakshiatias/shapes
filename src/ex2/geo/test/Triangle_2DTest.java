package ex2.geo.test;

import ex2.ex2.Ex2_Const;
import ex2.geo.geo.Point_2D;
import ex2.geo.geo.Triangle_2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Triangle_2DTest {

    private Point_2D p = new Point_2D(Point_2D.ORIGIN);
    private Point_2D p1 = new Point_2D(new Point_2D(0, 2));
    private Point_2D p2 = new Point_2D(2, 2);
    private Triangle_2D triangle = new Triangle_2D(p, p1, p2);

    @Test
    void getAllPoints() {
        Point_2D[] expected = {new Point_2D(0,0), new Point_2D(0,2), new Point_2D(2,2 )};
        assertArrayEquals(expected, triangle.getAllPoints());
    }

    @Test
    void contains() {
        Point_2D pointInside = new Point_2D(2, 2);
        Point_2D pointOutside = new Point_2D(3, 3);

        assertTrue(triangle.contains(pointInside));
        assertFalse(triangle.contains(pointOutside));
    }

    @Test
    void area() {
        assertEquals(2, triangle.area(), Ex2_Const.EPS);
    }

    @Test
    void perimeter() {
        assertEquals(6.828, triangle.perimeter(),0.01);
    }

    @Test
    void translate() {
        Point_2D Vect = new Point_2D(1, 1);
        triangle.translate(Vect);

        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(1, 3);
        Point_2D p3 = new Point_2D(3, 3);
        Point_2D[] expected =new Point_2D[] {p1, p2, p3};

        Point_2D[] actualPoints = triangle.getAllPoints();

        assertArrayEquals(expected, actualPoints);
    }

    @Test
    void copy() {
        Point_2D s = new Point_2D(new Point_2D(0, 0));
        Point_2D s1 = new Point_2D(new Point_2D(0, 2));
        Point_2D s2 = new Point_2D(new Point_2D(2, 2));
        Triangle_2D t1 = new Triangle_2D(s, s1, s2);
        triangle.copy();
        assertArrayEquals(t1.getAllPoints(), triangle.getAllPoints());
    }

    @Test
    void rotate() {
        Point_2D s = new Point_2D(new Point_2D(4.0 / 3.0, 8.0 / 3.0));
        Point_2D s1 = new Point_2D(new Point_2D(4.0 / 3.0, 2.0 / 3.0));
        Point_2D s2 = new Point_2D(new Point_2D(-2.0 / 3.0, 2.0 / 3.0));
        Triangle_2D t1 = new Triangle_2D(s, s1, s2);
        Point_2D q0 = new Point_2D(2.0 / 3, 4.0 / 3);
        triangle.rotate(q0, 180);
        Point_2D[] expectedPoints = t1.getAllPoints();
        Point_2D[] actualPoints = triangle.getAllPoints();
        for (int i = 0; i < expectedPoints.length; i++) {
            assertEquals(expectedPoints[i].x(), actualPoints[i].x(), Ex2_Const.EPS);
            assertEquals(expectedPoints[i].y(), actualPoints[i].y(), Ex2_Const.EPS);
        }
    }

    @Test
    void scale() {
        Point_2D s = new Point_2D(new Point_2D(-2.0 / 3, -4.0 / 3));
        Point_2D s1 = new Point_2D(new Point_2D(-2.0 / 3, 8.0 / 3));
        Point_2D s2 = new Point_2D(new Point_2D(10.0 / 3, 8.0 / 3));
        Triangle_2D t1 = new Triangle_2D(s, s1, s2);
        Point_2D q0 = new Point_2D(2.0 / 3, 4.0 / 3);
        triangle.scale(q0, 2);
        Point_2D[] expectedPoints = t1.getAllPoints();
        Point_2D[] actualPoints = triangle.getAllPoints();

        for (int i = 0; i < expectedPoints.length; i++) {
            assertEquals(expectedPoints[i].x(), actualPoints[i].x(), Ex2_Const.EPS);
            assertEquals(expectedPoints[i].y(), actualPoints[i].y(), Ex2_Const.EPS);
        }
    }

    @Test
    void testToString() {
        String expected = "0.0,0.0,0.0,2.0,2.0,2.0";
        assertEquals(expected, triangle.toString());
    }

    @Test
    void testEquals() {
        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(2, 3);
        Point_2D p3 = new Point_2D(4, 2);
        Triangle_2D same = new Triangle_2D(p1, p2, p3);
        Triangle_2D different = new Triangle_2D(p1, p2, new Point_2D(0, 0));

        assertEquals(triangle, same);
        assertNotEquals(triangle, different);
    }

    @Test
    void calculationArea() {
        double expected = triangle.calculationArea(triangle.getAllPoints()[0],triangle.getAllPoints()[1],triangle.getAllPoints()[2]);
        double area = triangle.area();
        assertEquals(expected, area,  Ex2_Const.EPS);
    }
}