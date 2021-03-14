/**
 * 
 */
package unittests;

import static org.junit.Assert.*;
import static primitives.Util.*;
import org.junit.Test;

import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;

/**
 * @author Home
 *
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
			//Triangle myTriangle = new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
			
			//Vector v = new Vector(new Point3D(0, 0, 1).subtract(new Point3D(1, 0, 0)).getHead());
			
			//Vector normal=new Vector(1, 1, 1);
			//assertEquals("bad normal to triangle", isZero(myTriangle.getNormal(new Point3D(0, 0, 1)).dotProduct(v)));

			
				   Triangle pl;
					pl = new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
					double sqrt3 = Math.sqrt(1d / 3);
				    assertEquals("Bad normal to trinagle", new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)));
					
			
			
			//assertFalse("ERROR: getNormal() function creates an Incorrect normal", myTriangle.getNormal(new Point3D(0, 0, 1)) !=v);
		}
		catch(Exception ex) 
		{
			fail("for vectors that not zero vector does not need throw an exception");
		}
	}

}
