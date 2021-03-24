
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;

/**
 *   Unit tests for geometries.Triangle class
 *   @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public class TriangleTest
{

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
			double sqrt3 = Math.sqrt(1d / 3);
			Vector normal=new Vector(sqrt3, sqrt3, sqrt3);
		    assertEquals("Bad normal to trinagle", normal , myTriangle.getNormal(new Point3D(0, 0, 1)));
	
		}
		catch(Exception ex) 
		{
			fail("for vectors that not zero vector does not need throw an exception");
		}
	}

}
