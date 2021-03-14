/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;

/**
 * @author Home
 *
 */
public class TriangleTest {

	/**
	 * Test method for {@link geometries.Polygon#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() 
	{
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
		try
		{
			Triangle myTriangle = new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
			Vector normal=new Vector(1, 1, 1);
			assertEquals("ERROR: getNormal() function creates an Incorrect normal", myTriangle.getNormal(new Point3D(0, 0, 1)), normal);

			//assertFalse("ERROR: getNormal() function creates an Incorrect normal", myTriangle.getNormal(new Point3D(0, 0, 1)) !=v);
		}
		catch(Exception ex) 
		{
			fail("for vectors that not zero vector does not need throw an exception");
		}
	}

}
