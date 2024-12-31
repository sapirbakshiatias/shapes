package ex2.geo.test;

import ex2.geo.geo.Point_2D;
import ex2.geo.geo.Polygon_2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Polygon_2DTest {
    private Polygon_2D polygon;


    @BeforeEach
    public void realPolygon() {
        polygon = new Polygon_2D();
        polygon.add(new Point_2D(1, 1));
        polygon.add(new Point_2D(2, 3));
        polygon.add(new Point_2D(4, 2));
    }

    @Test
    void getAllPoints() {
        Point_2D[] expected = {new Point_2D(1, 1), new Point_2D(2, 3), new Point_2D(4, 2)};
        assertArrayEquals(expected, polygon.getAllPoints());
    }

    @Test
    void add() {
        Point_2D[] p = {
                new Point_2D(1, 1),
                new Point_2D(2, 3),
                new Point_2D(4, 2),
                new Point_2D(2, 2),
                new Point_2D(-1, 5)};
        Polygon_2D polygon1 = new Polygon_2D(p);

        Point_2D newPoint = new Point_2D(2, 2);
        polygon.add(newPoint);
        Point_2D newPoint2 = new Point_2D(-1, 2);
        polygon.add(newPoint2);
        assertEquals(polygon1, polygon);

    }

    @Test
    void testToString() {
        String coordinatesString = "1.0,1.0,2.0,3.0,4.0,2.0";
        Point_2D[] expectedPoints = {
                new Point_2D(1, 1),
                new Point_2D(2, 3),
                new Point_2D(4, 2),};

        Polygon_2D polygon = new Polygon_2D(coordinatesString);
        Point_2D[] actualPoints = polygon.getAllPoints();

        assertArrayEquals(expectedPoints, actualPoints);

        String a = polygon.toString();
        Polygon_2D po2 = new Polygon_2D(a);
        assertEquals(polygon,po2);
    }

    @Test
    void contains() {
        Point_2D insidePoint = new Point_2D(2, 2);
        Point_2D outsidePoint = new Point_2D(3, 4);
        assertTrue(polygon.contains(insidePoint));
        assertFalse(polygon.contains(outsidePoint));
            }

    @Test
    void area() {
        assertEquals(2.5, polygon.area());
    }

    @Test
    void perimeter() {
        assertEquals(7.634, polygon.perimeter(), 0.01);
    }

    @Test
    void translate() {
        Point_2D vector = new Point_2D(1, 1);
        polygon.translate(vector);

        Point_2D[] expected = {new Point_2D(2, 2), new Point_2D(3, 4), new Point_2D(5, 3)};
        Point_2D[] actual = polygon.getAllPoints();
        assertArrayEquals(expected, actual);
    }

    @Test
    void copy() {
        Polygon_2D copyPolygon = (Polygon_2D) polygon.copy();

        assertEquals(polygon, copyPolygon);

        copyPolygon.translate(new Point_2D(1, 1));
        assertNotEquals(polygon, copyPolygon);
    }

    @Test
    void scale() {
        Polygon_2D expected = new Polygon_2D();
        expected.add(new Point_2D(2, 2)); // 1,1 scaled with ratio 2 around (0,0) gives (2,2)
        expected.add(new Point_2D(4, 6)); // 2,3 scaled with ratio 2 around (0,0) gives (4,6)
        expected.add(new Point_2D(8, 4)); // 4,2 scaled with ratio 2 around (0,0) gives (8,4)

        polygon.scale(new Point_2D(0, 0), 2);

        assertEquals(expected, polygon);
}

    @Test
    void rotate() {/////////////////////////////אפסילון
        Polygon_2D expected = new Polygon_2D();
        expected.add(new Point_2D(1, 1));
        expected.add(new Point_2D(-3, 2));
        expected.add(new Point_2D(-2, -4));

        polygon.rotate(new Point_2D(0, 0), 90);

        assertEquals(expected, polygon);
    }

    @Test
    void Equals() {
            Polygon_2D polygon1 = new Polygon_2D();
            polygon1.add(new Point_2D(2, 0));
            polygon1.add(new Point_2D(1, 1));
            polygon1.add(new Point_2D(-1, 1));
            polygon1.add(new Point_2D(-2, 0));
            polygon1.add(new Point_2D(-1, -1));
            polygon1.add(new Point_2D(1, -1));

            Polygon_2D polygon2 = new Polygon_2D();
            polygon2.add(new Point_2D(2, 0));
            polygon2.add(new Point_2D(1, 1));
            polygon2.add(new Point_2D(-1, 1));
            polygon2.add(new Point_2D(-2, 0));
            polygon2.add(new Point_2D(-1, -1));
            polygon2.add(new Point_2D(1, -1));

            Polygon_2D polygon3 = new Polygon_2D();
            polygon3.add(new Point_2D(2, 0));
            polygon3.add(new Point_2D(-1, 1));
            polygon3.add(new Point_2D(-2, 0));
            polygon3.add(new Point_2D(-1, -1));
            polygon3.add(new Point_2D(1, -1));
            polygon3.add(new Point_2D(1, 1));

            Polygon_2D polygon4 = new Polygon_2D();
            polygon4.add(new Point_2D(2, 0));
            polygon4.add(new Point_2D(-1, 1));
            polygon4.add(new Point_2D(-2, 0));
            polygon4.add(new Point_2D(-1, -1));
            polygon4.add(new Point_2D(1, -1));

            Polygon_2D polygon5 = new Polygon_2D();
            polygon5.add(new Point_2D(2, 0));
            polygon5.add(new Point_2D(-1, 1));
            polygon5.add(new Point_2D(-2, 0));
            polygon5.add(new Point_2D(-1, -1));
            polygon5.add(new Point_2D(1, -1));
            polygon5.add(new Point_2D(1, 5));

            assertEquals(polygon1, polygon2);
            assertNotEquals(polygon3, polygon2);
            assertNotEquals(polygon3, polygon1);
            assertNotEquals(polygon4, polygon3);
            assertNotEquals(polygon5, polygon3);
            assertNotEquals(polygon5, polygon3);
            assertNotEquals(polygon5, null);
        }

    @Test
    void setPoints() {
        Point_2D[] newPoints = { new Point_2D(2, 2), new Point_2D(3, 4), new Point_2D(5, 3)};

        polygon.setPoints(newPoints);

        Point_2D[] actualPoints = polygon.getAllPoints();
        assertArrayEquals(newPoints, actualPoints);
    }
}
