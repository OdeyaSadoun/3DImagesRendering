
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Plane;
import primitives.Point3D;
import primitives.Vector;

/**
 *   Unit tests for geometries.Plane class
 *   @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public class PlaneTest
{

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
			double normalLength=Math.sqrt(38)*3;
			Vector normal=new Vector(-9/normalLength, -6/normalLength, 15/normalLength);
			assertEquals("Bad normal to plane", normal, myPlane.getNormal());

		
		}
		catch(Exception ex)
		{
			fail("for vectors that not zero vector does not need throw an exception");
		}
	}

}
