package ex2.geo.test;

import ex2.ex2.Ex2_Const;
import ex2.geo.geo.Point_2D;
import ex2.geo.geo.Rect_2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rect_2DTest {
    private Point_2D a;
    private Point_2D a1;
    private Rect_2D b;

    @BeforeEach
    void setUp(){
        a1 = new Point_2D(2,2);
        a = new Point_2D(Point_2D.ORIGIN);
        b = new Rect_2D(a, a1);
    }

    @Test
    void get_r1() {
        Point_2D expected = b.get_p1();
        assertEquals(expected, b.get_p1());
    }

    @Test
    void get_r2() {
        Point_2D expected = b.get_p2();
        assertEquals(expected, b.get_p2());
    }

    @Test
    void contains() {
        Point_2D s2  = new Point_2D(1,1);
        boolean p = b.contains(s2);
        assertTrue(p);

        Point_2D s  = new Point_2D(5,5);
        boolean p1 = b.contains(s);
        assertFalse(p1);
    }

    @Test
    void area() {
        double p = b.area();
        assertEquals(4,p, Ex2_Const.EPS);
    }

    @Test
    void perimeter() {
        double p = b.perimeter();
        assertEquals(8,p, Ex2_Const.EPS);
    }

    @Test
    void translate() {
        Point_2D s = new Point_2D(new Point_2D(0,2));
        Point_2D s2 = new Point_2D(new Point_2D(2,4));
        Rect_2D r1 = new Rect_2D(s,s2);
        Point_2D q0 = new Point_2D(0,2);
        b.translate(q0);
        assertEquals(r1.get_p1(), b.get_p1());
        assertEquals(r1.get_p2(), b.get_p2());
    }

    @Test
    void copy() {
        Point_2D s = new Point_2D(new Point_2D(0,0));
        Point_2D s2 = new Point_2D(new Point_2D(2,2));
        Rect_2D r1 = new Rect_2D(s,s2);
        b.copy();
        assertEquals(r1.get_p1(), b.get_p1());
        assertEquals(r1.get_p2(), b.get_p2());
    }

    @Test
    void scale() {
        Point_2D sc = new Point_2D(new Point_2D(3,3));
        Point_2D sc1 = new Point_2D(new Point_2D(-1,-1));
        Point_2D q0 = new Point_2D(1, 1);
        a.scale(q0,2);
        a1.scale(q0,2);
        assertEquals(sc.x(), a1.x(), String.valueOf(Ex2_Const.EPS));
        assertEquals(sc1.x(), a.x(),String.valueOf(Ex2_Const.EPS));
    }

    @Test
    void rotate() {
        Point_2D p1 = new Point_2D(-2, 2);
        Point_2D p2 = new Point_2D(0, 2);
        Point_2D p3 = new Point_2D(0, 0);
        Point_2D p4 = new Point_2D(-2, 0);
        Rect_2D rect = new Rect_2D(p1, p2,p3,p4);
        Point_2D q0 = new Point_2D(0, 0);
       b.rotate(q0, 180);
        rect.rotate(q0,180);
            System.out.println(rect);
        Point_2D[] expectedPoints = rect.getAllPoints();
           System.out.println(b);

        Point_2D[] actualPoints = b.getAllPoints();
        for (int i = 0; i < expectedPoints.length; i++) {
            assertEquals(expectedPoints[i].x(), actualPoints[i].x(), Ex2_Const.EPS);
            assertEquals(expectedPoints[i].y(), actualPoints[i].y(), Ex2_Const.EPS);
        }
    }

    @Test
    public void toString1() {
        String st1 = "0.0,0.0,0.0,2.0,2.0,2.0,2.0,0.0";
                assertTrue(b.toString().equals(st1));
                assertEquals(b.toString(), st1);

        String s1 = b.toString();
        Rect_2D gs = new Rect_2D(s1);
        assertEquals(b, gs);
    }

    @Test
    public void equals(){
        Point_2D point1 = new Point_2D(0, 0);
        Point_2D point2 = new Point_2D(1, 1);
        Point_2D point3 = new Point_2D(2, 2);

        Rect_2D rect = new Rect_2D(point1,point3);
        Rect_2D rect1 = new Rect_2D(point3,point1);
        Rect_2D rect2 = new Rect_2D(point3,point2);

        assertTrue(rect.equals(rect1));
        assertFalse(rect1.equals(rect2));
        assertFalse(rect1.equals(null));
        assertFalse(rect1.equals(a));

        Point_2D point4 = new Point_2D(2, 2.0000001);
        Rect_2D rect3 = new Rect_2D(point1,point4);

        assertTrue(rect.equals(rect3));
    }
}