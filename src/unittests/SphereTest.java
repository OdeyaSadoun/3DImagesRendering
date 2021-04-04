package unittests;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import geometries.Sphere;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 *   Unit tests for geometries.Sphere class
 *   @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public class SphereTest 
{

	/**
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() 
	{
		try
		{
			// ============ Equivalence Partitions Tests ==============
			double radius=5;// הנקודה p שעל הספרה תהיה 5,2,6
			Point3D center=new Point3D(1, 2, 3);		
			Sphere mySphere=new Sphere(center, radius);
			Vector normal=new Vector(4d/5, 0, 3d/5);
			assertEquals("bad normal to sphere", normal, mySphere.getNormal(new Point3D(5,2,6)));

		}
		catch(Exception ex)
		{
			fail("for vectors that not zero vector does not need throw an exception");
		}
		
	}	
		
	    /**
	     * Test method for {@link geometries.Sphere#findIntersections(primitives.Ray)}.
	     */
	    @Test
	    public void testfindIntersections() 
	    {
	        try
	        {
	        	Sphere sphere = new Sphere( new Point3D(1, 0, 0), 1d);
	        

	        // ============ Equivalence Partitions Tests ====================

	        // TC01: Ray's line is outside the sphere (0 points)
	        assertNull("Ray's line out of sphere",
	        		sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(1, 1, 0))));

	        // TC02: Ray starts before and crosses the sphere (2 points)
	        Point3D p1 = new Point3D(0.0651530771650466, 0.355051025721682, 0);
	        Point3D p2 = new Point3D(1.53484692283495, 0.844948974278318, 0);
	        List<Point3D> result = sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(3, 1, 0)));
	        assertEquals("Wrong number of points", 2, result.size());
	        if (result.get(0).getX() > result.get(1).getX())
	            result = List.of(result.get(1), result.get(0));
	        assertEquals("Ray crosses sphere", List.of(p1, p2), result);

	        // TC03: Ray starts inside the sphere (1 point)	        
	        result = sphere.findIntersections(new Ray(new Point3D(1, 0.5, 0),new Vector(-1, -1, -2)));
	        assertEquals("Wrong number of points", 1, result.size());
	    
	        
	        // TC04: Ray starts after the sphere (0 points)
	        assertNull("The ray starts after the sphere", sphere.findIntersections(new Ray(new Point3D(4, 10, 0),new Vector(1, 2, 0))));

	        // =============== Boundary Values Tests ==================

	        // **** Group: Ray's line crosses the sphere (but not the center)
	        // TC11: Ray starts at sphere and goes inside (1 points)
	        result = sphere.findIntersections(new Ray(new Point3D(2, 0, 0),new Vector(-1, 0, 1)));
	        assertEquals("Wrong number of points", 1, result.size());
	        
	        // TC12: Ray starts at sphere and goes outside (0 points)
	        assertNull("The ray starts at sphere and goes outside", sphere.findIntersections(new Ray(new Point3D(3, 0, 0),new Vector(1, 0, 0))));
	        		

	        // **** Group: Ray's line goes through the center
	        // TC13: Ray starts before the sphere (2 points)
	        result = sphere.findIntersections(new Ray(new Point3D(1, -2, 0),new Vector(0, 1, 0)));
	        assertEquals("Wrong number of points", 2, result.size());
	        if (result.get(0).getX() > result.get(1).getX())
	            result = List.of(result.get(1), result.get(0));
	        assertEquals("Ray crosses sphere", List.of(new Point3D(1, 1, 0), new Point3D(1, -1, 0)), result);/////??????????
	        
	        // TC14: Ray starts at sphere and goes inside (1 points)
	        result = sphere.findIntersections(new Ray(new Point3D(1, -1, 0),new Vector(0, 1, 0)));
	        assertEquals("Wrong number of points", 1, result.size());
	        
	        // TC15: Ray starts inside (1 points)
	        result = sphere.findIntersections(new Ray(new Point3D(0.5, 0, 0),new Vector(4, 0, 0)));
	        assertEquals("Wrong number of points", 1, result.size());
	        
	        // TC16: Ray starts at the center (1 points)
	        result = sphere.findIntersections(new Ray(new Point3D(1, 0, 0),new Vector(2.52,-5.02, 0)));
	        assertEquals("Wrong number of points", 1, result.size());
	        
	        // TC17: Ray starts at sphere and goes outside (0 points)
	        result = sphere.findIntersections(new Ray(new Point3D(2, 0, 0),new Vector(1, 0, 0)));
	        assertNull("Wrong number of points", result);
	        assertNull("The ray starts at sphere and goes outside", sphere.findIntersections(new Ray(new Point3D(1, 1, 0),new Vector(0, 1, 0))));
	        // TC18: Ray starts after sphere (0 points)	        
	        assertNull("The ray starts  after sphere", sphere.findIntersections(new Ray(new Point3D(1, 2, 0),new Vector(0, 1, 0))));
	        
	        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
	        // TC19: Ray starts before the tangent point
	        assertNull("The ray starts before the tangent point", sphere.findIntersections(new Ray(new Point3D(-0.5,-0.5, 0),new Vector(-2, -1, 0))));
	        
	        // TC20: Ray starts at the tangent point
	        assertNull("The ray starts at the tangent point", sphere.findIntersections(new Ray(new Point3D(1, 0, 1),new Vector(-1,-1, 0))));
	        
	        // TC21: Ray starts after the tangent point
	        assertNull("The ray starts after the tangent point", sphere.findIntersections(new Ray(new Point3D(1, 1, 1),new Vector(0, -2, 1))));
	        
	        // **** Group: Special cases
	        // TC22: Ray's line is outside, ray is orthogonal to ray start to sphere's center line
	        assertNull("The ray's line is outside, ray is orthogonal to ray start to sphere's center line", sphere.findIntersections(new Ray(new Point3D(-0.5, 0, 0),new Vector(0, -2, 1))));
	        }
	        catch(Exception ex)
	        {
	        	ex.printStackTrace();
	        	fail("not need throws exception!");
	        	
	        }

	    }

	
}



