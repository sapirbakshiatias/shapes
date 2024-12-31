package ex2.geo.test;

import ex2.ex2.Ex2_Const;
import ex2.geo.geo.Point_2D;
import ex2.geo.geo.Segment_2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Segment_2DTest {
    private Segment_2D s1;
    private Point_2D p1;
    private Point_2D p2;
    private Segment_2D s2;

    @BeforeEach
    void setUp() {
        p1 = new Point_2D(1, 0);
        p2 = new Point_2D(5, 3);
        s1 = new Segment_2D(Point_2D.ORIGIN, new Point_2D(0, 1));
        s2 = new Segment_2D(p1, p2);
    }

    @Test
    void testContains() {
        assertTrue(s2.contains(p1));
        assertTrue(s2.contains(p2));
        assertTrue(s2.contains(new Point_2D(3, 1.5)));
        assertFalse(s2.contains(new Point_2D(10, 10)));
    }

    @Test
    public void testPerimeter() {
        double expected = p1.distance(p2) * 2;
        assertEquals(expected, s2.perimeter(), Ex2_Const.EPS);
    }

    @Test
    public void testArea() {
        assertEquals(0, s1.area());
    }

    @Test
    public void testTranslate() {
        Segment_2D segment = new Segment_2D(new Point_2D(1, 1), new Point_2D(5, 1));
        segment.translate(new Point_2D(2, 3));
        assertEquals(new Point_2D(3, 4), segment.get_p1());
        assertEquals(new Point_2D(7, 4), segment.get_p2());
    }

    @Test
    public void testCopy() {
        Segment_2D s = new Segment_2D(new Point_2D(0,0),new Point_2D(0,1));
        s.copy();
        assertEquals(s1.get_p1(),s.get_p1());
        assertEquals(s1.get_p2(),s.get_p2());
        assertNotEquals(s1.get_p1(),s2.get_p1());
    }

    @Test
    public void testScale() {
        Point_2D p1 = new Point_2D(0.0, 0.0);
        Point_2D p2 = new Point_2D(0.0, 1.0);
        Segment_2D t = new Segment_2D(p1, p2);

        Point_2D center = new Point_2D(0, 0.5);
        double angleDegrees = 360;
        s1.rotate(center, angleDegrees);
        assertEquals(t.get_p1().x(),s1.get_p1().x(),Ex2_Const.EPS);
        assertEquals(t.get_p2().x(),s1.get_p2().x(),Ex2_Const.EPS);

        Point_2D pp = new Point_2D(0.5, 0.5);
        Point_2D pp1 = new Point_2D(-0.5, 0.5);
        Segment_2D t1 = new Segment_2D(pp, pp1);

        Point_2D center1 = new Point_2D(0, 0.5);
        double angleDegrees1 = 90;
        s1.rotate(center1, angleDegrees1);
        assertEquals(t1.get_p1().x(),s1.get_p1().x(),Ex2_Const.EPS);
        assertEquals(t1.get_p2().x(),s1.get_p2().x(),Ex2_Const.EPS);
    }
    @Test
    public void testRotate() {
        Segment_2D rotated = new Segment_2D(new Point_2D(0, 0), new Point_2D(4, 0));
        rotated.rotate(Point_2D.ORIGIN, 90);
        assertEquals(new Point_2D(0, 0), rotated.get_p1());
        assertTrue(rotated.get_p2().close2equals(new Point_2D(0, 4), 0.0001));
    }
    @Test
    public void string(){
        String st1 = "0.0,0.0,0.0,1.0";
        String st2 = "1.0,0.0,5.0,3.0";
        assertTrue(s1.toString().equals(st1));
        assertTrue(s2.toString().equals(st2));

        String s1 = s2.toString();
        Segment_2D gs = new Segment_2D(s1);
        assertEquals(s2, gs);
}

    @Test
    void testEquals() {
        Segment_2D segment1 = new Segment_2D(new Point_2D(1, 2), new Point_2D(3, 4));
        Segment_2D segment2 = new Segment_2D(new Point_2D(1, 2), new Point_2D(3, 4));
        Segment_2D segment3 = new Segment_2D(new Point_2D(5, 6), new Point_2D(7, 8));

        assertTrue(segment1.equals(segment1));
        assertTrue(segment1.equals(segment2));
        assertFalse(segment1.equals(segment3));
    }

    }
