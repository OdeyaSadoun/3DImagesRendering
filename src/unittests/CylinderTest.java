/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Cylinder;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author Home
 *
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
			Ray myRay=new Ray(new Point3D(1, 1, 2), new Vector(6, -2, 9));
			Cylinder myCylinder=new Cylinder(3,myRay,4);
			Vector normal=new Vector(385d/660.322, -115d/660.322, 524d/660.322);
			assertTrue("ERROR: getNormal() function creates an Incorrect normal", myCylinder.getNormal(new Point3D(5,2,6))==normal );
		}
		catch(Exception ex)
		{
			
		}
		
	}

}
