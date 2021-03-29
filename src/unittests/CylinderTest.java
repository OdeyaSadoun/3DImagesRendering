
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Cylinder;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 *   Unit tests for geometries.Cylinder class
 *   @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public class CylinderTest 
{

	/**
	 * Test method for {@link geometries.Cylinder#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() 
	{		
		try
		{
			// ============ Equivalence Partitions Tests ==============
			
			Ray myRay=new Ray(new Point3D(4, 0, 0), new Vector(0, 3, 0));
			
			Cylinder myCylinder=new Cylinder(3,myRay,4);
			Vector normal=new Vector(-4d/5, 3d/5, 0);
			assertEquals("bad normal to cylinder", myCylinder.getNormal(new Point3D(5,2,6)), normal);
			//assertTrue("ERROR: getNormal() function creates an Incorrect normal", myCylinder.getNormal(new Point3D(5,2,6))==normal );
		}
		catch(Exception ex)
		{
			
		}
		
	}

	
	

}
