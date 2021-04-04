
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Plane;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 *   Unit tests for geometries.Plane class
 *   @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public class PlaneTest
{
	@Test
	public void testPlaneConstructor()
	{
		try
		{
			Point3D p1=new Point3D(1,2,3);
			Point3D p2=new Point3D(1,2,3);
			Point3D p3=new Point3D(1,7,5);
			Plane myPlane =new Plane(p1, p2 , p3);
			//assertThrows("failure text", IllegalArgumentException.class, () -> function call);
			fail ("The points coalesce and the constructor should send an exception");
		}
		catch(Exception ex) {}
		
		try
		{
			Point3D p1=new Point3D(1,2,3);
			Point3D p2=new Point3D(2,4,6);
			Point3D p3=new Point3D(1,7,5);
			Plane myPlane =new Plane(p1, p2 , p3);
			//assertThrows("failure text", IllegalArgumentException.class, () -> function call);
			fail ("The dots are on the same line");
		}
		catch(Exception ex) {}
		
	}

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point3D)}.
	 * 
	 * @throws Exception
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
			// =============== Boundary Values Tests ==================
		
		}
		catch(Exception ex)
		{
			fail("for vectors that not zero vector does not need throw an exception");
		}
	}
	
	/**
	 * Test method for {@link geometries.Cylinder#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testfindIntersections() 
	{
		try
		{
			Plane myPlane = new Plane(new Point3D(0,5,0), new Point3D(-5,0,0), new Point3D(0,0,3));
			// =============== Boundary Values Tests ==================
			
			//Ray is parallel to the plane
			// TC01: the ray included in the plane
			Ray myRay= new Ray(new Point3D(0,5,0), new Vector(-5,0,0));//the plane include this ray
			assertEquals("A included ray has zero intersection points", null, myPlane.findIntersections(myRay));
			// TC02: the ray not included in the plane
			myRay= new Ray(new Point3D(0,-5,0), new Vector(5,0,0));//the plane un included this ray
			assertEquals("An un included ray has zero intersection points", null, myPlane.findIntersections(myRay));
			
			//Ray is orthogonal to the plane
			// TC03:𝑃0 before the plane
			myRay= new Ray(new Point3D(2,4,0), new Vector(-3,3,5));//the ray is orthogonal to the plane
			assertEquals("Ray is orthogonal to the plane and starts before the plane",1, myPlane.findIntersections(myRay));
			// TC04:𝑃0 at the plane
			myRay= new Ray(new Point3D(-5,0,0), new Vector(-3,3,5));//the ray is orthogonal to the plane
			assertEquals("Ray is orthogonal to the plane and starts at the plane",null, myPlane.findIntersections(myRay));
			// TC05:𝑃0 after the plane
			myRay= new Ray(new Point3D(-7,2,4), new Vector(-3,3,5));//the ray is orthogonal to the plane
			assertEquals("Ray is orthogonal to the plane and starts after the plane",null, myPlane.findIntersections(myRay));
			
			//Ray is neither orthogonal nor parallel to and begins at the plane
			// TC06:
			myRay= new Ray(new Point3D(-10.25,0.01,-3.16), new Vector(3.46,1.14,3.16));//the ray isnt orthogonal or parallel to the plane
			assertEquals("Ray is neither orthogonal nor parallel to and begins at reference point in the plane",null, myPlane.findIntersections(myRay));
			
			//Ray is neither orthogonal nor parallel to the plane and begins in
			//the same point which appears as reference point in the plane
			// TC07:
			myRay= new Ray(new Point3D(0,0,3), new Vector(-5,4,-3));//the ray isnt orthogonal or parallel to the plane but not intersects the plane
			assertEquals("Ray is neither orthogonal nor parallel to and begins at the plane",null, myPlane.findIntersections(myRay));
			
			// ============ Equivalence Partitions Tests ==============
			// TC08: The Ray must be neither orthogonal nor parallel to the plane
			//Ray does not intersect the plane
			myRay= new Ray(new Point3D(1,2,0), new Vector(-3,-7,0));
			assertEquals("Ray is neither orthogonal nor parallel but doesnt intersects the plane",null, myPlane.findIntersections(myRay));
			
			// TC09:
			// Ray intersects the plane
			myRay= new Ray(new Point3D(4,3,0), new Vector(-5.75,3.57,0));//the ray isnt orthogonal or parallel to the plane and intersects the plane
			assertEquals("Ray is neither orthogonal nor parallel and intersects the plane ",1, myPlane.findIntersections(myRay));
		}
		catch(Exception ex)
		{
			
		}
	}
		
	
	
	

}
