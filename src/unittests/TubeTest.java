/**
 * 
 */
package unittests;

import static org.junit.Assert.*;
import static primitives.Util.*;
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
		//double normalLength= Math.sqrt(385*385+(-115)*(-115)+524*524);
		//Vector normal=new Vector(385d/normalLength, -115d/normalLength, 524d/normalLength);
		//assertTrue("ERROR: getNormal() function creates an Incorrect normal", myTube.getNormal(new Point3D(5,2,6))==normal);
		//assertEquals("ERROR: getNormal() function creates an Incorrect normal", myTube.getNormal(new Point3D(5,2,6)), normal);
		
		//Ray r;
		//r = new Ray(new Point3D(0,0,0),new Vector(0,0,1));
		//Tube t=new Tube(1,r);
		Point3D p=new Point3D(5,2,6);
		Vector normal=myTube.getNormal(p);
		assertTrue("bad normal to tube",isZero(myRay.getDir().dotProduct(normal)));
		

	 } 
     catch (Exception e) 
     {		
		fail("for vectors that not zero vector does not need throw an exception");
     }
	
     
	}

}
