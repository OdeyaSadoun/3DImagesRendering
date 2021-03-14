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
public class CylinderTest {

	/**
	 * Test method for {@link geometries.Cylinder#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() 
	{		
		try
		{
		double radius =3;
		Point3D p=new Point3D(1, 7, 4);
		Vector v=new Vector(p);
		Ray myRay=new Ray(p, v);
		double height=4;
		Cylinder myCylinder=new Cylinder(radius,myRay,height);
		assertFalse("ERROR: getNormal() function creates an Incorrect vector", myCylinder.getNormal(p) !=v);
		}
		catch(Exception ex)
		{
			
		}
		
	}

}
