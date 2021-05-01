/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import geometries.Geometry;
import geometries.Intersectable.GeoPoint;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
 *
 */
public class RayTest 
{

	/**
	 * Test method for {@link primitives.Ray#getPoint(double)}.
	 */
	@Test
	public void testGetPoint() 
	{
		try 
		{
			Ray ray = new Ray(new Point3D(0,0,1), new Vector(1,0,0));
			assertEquals("The function getPoint dont work correct", new Point3D(2, 0, 1), ray.getPoint(2));
			
			assertEquals("The function getPoint dont work correct", new Point3D(0, 0, 1), ray.getPoint(0));

		}
		catch (Exception e) {}
	}

	/**
	 * Test method for {@link primitives.Ray#findClosestPoint(java.util.List)}.
	 */
	@Test
	public void testFindClosestPoint() 
	{
		try 
		{
			// =============== Boundary Values Tests ==================
			Ray ray = new Ray(new Point3D(0,0,1), new Vector(1,0,0));
			
			Point3D p1 = new Point3D(1,0,0);
			Point3D p2 = new Point3D(2,0,0);
			Point3D p3 = new Point3D(3,0,0);

			//The first point is closest to the beginning of the foundation
			List<Point3D >points = List.of(p1,p2,p3);
			assertEquals("", p1, ray.findClosestPoint(points));
			
			//The last point is closest to the beginning of the foundation
			points = List.of(p2,p3,p1);
			assertEquals("", p1, ray.findClosestPoint(points));
			
			//An empty list
			points = List.of(null);
			assertEquals("", null, ray.findClosestPoint(points));
			
			// ============ Equivalence Partitions Tests ==============
			//A point in the middle of the list is closest to the beginning of the fund
			points = List.of(p2,p1,p3);
			assertEquals("", p1, ray.findClosestPoint(points));
			
			
		}
		catch (Exception e) {}
	}
	
	@Test
	public void testGetClosestGeoPoint() 
	{
		try 
		{
			// =============== Boundary Values Tests ==================
			Ray ray = new Ray(new Point3D(0,0,1), new Vector(1,0,0));
			GeoPoint p1 = new GeoPoint(null, new Point3D(1,0,0));
			GeoPoint p2 = new GeoPoint(null,new Point3D(2,0,0));
			GeoPoint p3 = new GeoPoint(null,new Point3D(3,0,0));
			
			//The first point is closest to the beginning of the foundation
			List<GeoPoint >points = List.of(p1,p2,p3);
			assertEquals("", p1, ray.getClosestGeoPoint(points));
			
			//The last point is closest to the beginning of the foundation
			points = List.of(p2,p3,p1);
			assertEquals("", p1, ray.getClosestGeoPoint(points));
			
			//An empty list
			points = List.of(null);
			assertEquals("", null, ray.getClosestGeoPoint(points));
			
			// ============ Equivalence Partitions Tests ==============
			//A point in the middle of the list is closest to the beginning of the fund
			points = List.of(p2,p1,p3);
			assertEquals("", p1, ray.getClosestGeoPoint(points));
			
		}
		catch (Exception ex) {}
	}

}
