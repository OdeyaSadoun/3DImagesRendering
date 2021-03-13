/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Plane;
import primitives.Point3D;
import primitives.Vector;

/**
 * @author Home
 *
 */
public class PlaneTest {

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormalPoint3D() 
	{
		try
		{
			// ============ Equivalence Partitions Tests ==============
			Point3D p1=new Point3D(1,2,3);
			Point3D p2=new Point3D(4,5,6);
			Point3D p3=new Point3D(1,7,5);
			Plane myPlane =new Plane(p1, p2 , p3);
			Vector v=new Vector(-9, -6, 15);
			assertFalse("ERROR: getNormal() function creates an Incorrect normal", myPlane.getNormal() !=v);
		}
		catch(Exception ex)
		{
			fail("for vectors that not zero vector does not need throw an exception");
		}
	}

}
