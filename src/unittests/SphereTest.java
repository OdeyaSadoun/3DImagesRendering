/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Sphere;
import primitives.Point3D;
import primitives.Vector;

/**
 * @author Home
 *
 */
public class SphereTest {

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
			Vector normal=new Vector(4/5, 0, 3/5);
			assertFalse("ERROR: getNormal() function creates an Incorrect normal", mySphere.getNormal(center) !=normal);
		}
		catch(Exception ex)
		{
			fail("for vectors that not zero vector does not need throw an exception");
		}
		
		
	}

}
