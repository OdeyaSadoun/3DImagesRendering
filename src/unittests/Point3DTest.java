/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Point3D;
import primitives.Vector;

/**
 * Test class for Point3D
 * @author Tamar Gavrieli & Odeya Sadoun
 *
 */
public class Point3DTest 
{

	/**
	 * Test method for {@link primitives.Point3D#add(primitives.Vector)}.
	 */
	@Test
	public void testAdd() 
	{
		try 
		{
			Point3D point=new Point3D(1,1,1);
			Vector vector = new Vector(1,2,3);
			assertEquals("Function add doesnt work correct", new Point3D(2,3,4), point.add(vector));
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			fail("No need to throw exception");
		}
		
		try 
		{
			Point3D point=new Point3D(1,1,1);
			assertEquals("Function add doesnt work correct", point, point.add(new Vector(Point3D.ZERO)));
			fail("No need to throw exception");
		} 
		catch (Exception e) {}
		
		
		
	}

	/**
	 * Test method for {@link primitives.Point3D#subtract(primitives.Point3D)}.
	 */
	@Test
	public void testSubtract() 
	{
		try 
		{
			Point3D point1=new Point3D(1,1,1);
			Point3D point2=new Point3D(1,2,3);
			assertEquals("Function subtract doesnt work correct", new Vector(0,-1,-2), point1.subtract(point2));
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			fail("No need to throw exception");
		}
		
		try 
		{
			Point3D point=new Point3D(1,1,1);
			assertEquals("Function subtract doesnt work correct", new Vector(point), point.subtract(Point3D.ZERO));
		} 
		catch (Exception e) {}
	}

	/**
	 * Test method for {@link primitives.Point3D#distanceSquared(primitives.Point3D)}.
	 */
	@Test
	public void testDistanceSquared() 
	{
		Point3D point1=new Point3D(0,0,3);
		Point3D point2=new Point3D(0,4,0);
		assertEquals("Function distanceSquared doesnt work correct",25, point1.distanceSquared(point2), 0.0001);
	}

	/**
	 * Test method for {@link primitives.Point3D#distance(primitives.Point3D)}.
	 */
	@Test
	public void testDistance() 
	{
		Point3D point1=new Point3D(0,0,3);
		Point3D point2=new Point3D(0,4,0);
		assertEquals("Function distance doesnt work correct",5, point1.distance(point2), 0.0001);
	}

}
