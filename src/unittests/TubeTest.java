
package unittests;

import static org.junit.Assert.*;
import static primitives.Util.*;
import org.junit.Test;


import geometries.Tube;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 *   Unit tests for geometries.Tube class
 *   @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public class TubeTest 
{

	/**
	 * Test method for {@link geometries.Tube#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() 
	{	
		try 
		{
			// ============ Equivalence Partitions Tests ==============
			Ray myRay=new Ray(new Point3D(1, 0, 0), new Vector(0, 1, 0));
			Tube myTube=new Tube(5, myRay);
			Vector normal = new Vector(1,0,0);
			assertEquals("Bad normal to tube", normal , myTube.getNormal(new Point3D(3,1,0)));
		
		} 
		catch (Exception e) 
		{		
			fail("for vectors that not zero vector does not need throw an exception");
		}
	
     
	}

}
