package ex2.geo.test;

import ex2.ex2.Ex2_Const;
import ex2.geo.geo.Point_2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point_2DTest {
    private Point_2D p1;
    private Point_2D p3;
    private Point_2D p2;

    @BeforeEach
    void setUp(){
        p1 = new Point_2D(1,3);
        p2 = new Point_2D(5.8,6.9);
        p3 = new Point_2D(1,6);
    }

    @Test
    void x() {
        double p = p1.x();
        assertEquals(p,1, Ex2_Const.EPS);
    }

    @Test
    void y() {
        double p = p1.y();
        assertEquals(p, 3, Ex2_Const.EPS);
    }

    @Test
    void add() {
        Point_2D a = new Point_2D(6.8,9.90000000001);
        Point_2D a1 =  p1.add(p2);
        assertEquals(a.x(),a1.x(),Ex2_Const.EPS);
        assertEquals(a.y(),a1.y(), Ex2_Const.EPS);
    }

    @Test
    void testToString() {
        String a1 = p1.toString();
        String a  = "1.0,3.0";
        assertEquals(a,a1);

        String s1 = p1.toString();
        Point_2D gs = new Point_2D(s1);
        assertEquals(p1, gs);
    }

    @Test
    void distance() {
        Point_2D p4 = new Point_2D(0,6);
        Point_2D p5 = new Point_2D(0,3);
        assertEquals(3,p4.distance(p5));
    }

    @Test
    void testDistance() {
        double a =  p1.distance(p3);
        assertEquals(3.0,a);
    }

    @Test
    void testEquals() {
        Point_2D e = new Point_2D(1,6);
        boolean e1 = p3.equals(e);
        assertTrue(e1);
    }

    @Test
    void close2equals() {
        assertTrue(p1.close2equals(new Point_2D(1.0000001,2.9999999999),Ex2_Const.EPS));
        assertFalse(p2.close2equals(new Point_2D(1.0000001,2.9999999999),Ex2_Const.EPS));
    }

    @Test
    void vector() {
        Point_2D p4 = new Point_2D(2,2);
        Point_2D p5 = new Point_2D(1,1);

        assertEquals(p5,p5.vector(p4));
    }

    @Test
    void move() {
        p1.move(p3);
       Point_2D m = new Point_2D(2,9);
       assertEquals(m,p1);
    }

    @Test
    void scale() {
        Point_2D center = new Point_2D(0, 0);
        Point_2D point = new Point_2D(2, 2);

        point.scale(center, 2.0);

        assertEquals(4.0, point.x());
        assertEquals(4.0, point.y());
    }

    @Test
    void rotate() {
        Point_2D center = new Point_2D(0, 0);
        Point_2D point = new Point_2D(2, 0);

        point.rotate(center, 90.0);

        assertEquals(0.0, point.x(), Ex2_Const.EPS);
        assertEquals(2.0, point.y(),Ex2_Const.EPS);
    }
}