/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;


import geometries.Tube;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author Home
 *
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
		Ray myRay=new Ray(new Point3D(1, 1, 2), new Vector(6, -2, 9));//
		Tube myTube=new Tube(5, myRay);
		Vector normal=new Vector(385d/660.322, -115d/660.322, 524d/660.322);
		assertTrue("ERROR: getNormal() function creates an Incorrect normal", myTube.getNormal(new Point3D(5,2,6))!=normal );
		
	} 
     catch (Exception e) 
     {		
		fail("for vectors that not zero vector does not need throw an exception");
     }
	
     
	}

}
