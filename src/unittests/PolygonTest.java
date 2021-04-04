
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Polygon;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 *   Unit tests for geometries.Polygon class
 *   @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public class PolygonTest 
{
    /**
     * Test method for
     * {@link geometries.Polygon#Polygon(primitives.Point3D, primitives.Point3D, primitives.Point3D, primitives.Point3D)}.
     * 
     * @throws Exception
     */
    @Test
    public void testConstructor()
    {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct concave quadrangular with vertices in correct order
        try 
        {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(-1, 1, 1));
        } 
        catch (IllegalArgumentException e) {
            fail("Failed constructing a correct polygon");
        } 
        catch (Exception e) {}

        // TC02: Wrong vertices order
        try 
        {
            new Polygon(new Point3D(0, 0, 1), new Point3D(0, 1, 0),
                    new Point3D(1, 0, 0), new Point3D(-1, 1, 1));
            fail("Constructed a polygon with wrong order of vertices");
        } 
        catch (IllegalArgumentException e) {}
        catch (Exception e) {}

        // TC03: Not in the same plane
        try 
        {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 2, 2));
            fail("Constructed a polygon with vertices that are not in the same plane");
        } 
        catch (IllegalArgumentException e) {}
        catch (Exception e) {}

        // TC04: Concave quadrangular
        try 
        {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0.5, 0.25, 0.5));
            fail("Constructed a concave polygon");
        } 
        catch (IllegalArgumentException e) {}
        catch (Exception e) {}

        // =============== Boundary Values Tests ==================

        // TC10: Vertex on a side of a quadrangular
        try 
        {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 0.5, 0.5));
            fail("Constructed a polygon with vertix on a side");
        } 
        catch (IllegalArgumentException e) {}
        catch (Exception e) {}

        // TC11: Last point = first point
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 0, 1));
            fail("Constructed a polygon with vertice on a side");
        } 
        catch (IllegalArgumentException e) {}
        catch (Exception e) {}

        // TC12: Colocated points
        try 
        {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 1, 0));
            fail("Constructed a polygon with vertice on a side");
        } 
        catch (IllegalArgumentException e) {}
        catch (Exception e) {}

    }

    /**
     * Test method for {@link geometries.Polygon#getNormal(primitives.Point3D)}.
     * 
     * @throws Exception
     */
    @Test
    public void testGetNormal() throws Exception
    {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Polygon pl = new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0),
                new Point3D(-1, 1, 1));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals("Bad normal to trinagle", new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)));
    }
	 /**
     * Test method for {@link geometries.Polygon#findIntersections(primitives.Point3D)}.
     */
    @Test
    public void testfindIntersections() 
    {
        try
        {
        	Polygon squre = new Polygon(new Point3D(0, 1, 0), new Point3D(2, 6, 0), new Point3D(5, 0, 0), new Point);
        

        // ============ Equivalence Partitions Tests ====================

        // TC01: The ray cuts the plane In front of the side of the triangle
        Ray ray = new Ray(new Point3D(6.94, -2.39, 0), new Vector(new Point3D(-2.68, 5.72, 0)));
        assertNull("the intersection point is out of the triangle - need 0 intersections", triangle.findIntersections(ray));

        // TC02: The ray intersects the plane on which the triangle is in front of the vertex
        ray = new Ray(new Point3D(-0.93, 6.2, 0), new Vector(new Point3D(2.54, 2.23, 0)));
        assertNull("the intersection point is out of the triangle - need 0 intersections", triangle.findIntersections(ray));

        // TC03: The ray cuts the plane within the boundaries of the triangle
        ray = new Ray(new Point3D(-2.09, 2.69, 2.3), new Vector(new Point3D(4.09, -0.69, -2.3)));
        assertEquals("the intersection point is in the triangle - need 1 intersections", 1, triangle.findIntersections(ray).size());
        
       

        // =============== Boundary Values Tests ==================

        // TC11: The ray intersects on the side of the triangle
        ray = new Ray(new Point3D(4.26, -1.28, 2.14), new Vector(new Point3D(-0.15, 3.07, -2.14)));
        assertNull("on the side - need 0 intersections", triangle.findIntersections(ray));
        
        // TC12: The ray intersects on one of the vertices of the triangle
        ray = new Ray(new Point3D(3.7, -0.71, 1.44), new Vector(new Point3D(1.3, 0.71, -1.44)));
        assertNull("on the vertex - need 0 intersections", triangle.findIntersections(ray));
        
        // TC13: The ray On the straight line continuing the side of the triangle
        ray = new Ray(new Point3D(3.86, -4.95, 0), new Vector(new Point3D(2.97, 1.28, 0)));
        assertNull("the intersection point is out of the triangle - need 0 intersections", triangle.findIntersections(ray));
}
