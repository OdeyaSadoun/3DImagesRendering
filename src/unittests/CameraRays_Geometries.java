/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import elements.Camera;
import geometries.Geometries;
import geometries.Intersectable;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author Home
 *
 */
public class CameraRays_Geometries 

{
	/**
	 * A function that create 9 rays from vp 3x3
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return List<Ray> value for the rays 
	 * */
	public List<Ray> Creat9RaysToVeiwPlane(Camera camera)
	{
		List<Ray> raysFromCamera = new ArrayList<Ray>();
		for (int i = 0; i < 3; i++)
		{
			for (int j = i; j < 3; j++)
			{
				raysFromCamera.add(camera.constructRayThroughPixel(3, 3, j, i));
			}
		}
		return raysFromCamera;
	}
	
	/**
	 * A function that return list of intersection points
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return List<Point3D> value for the intersection points 
	 * */
	public List<Point3D> findIntersectionPoints(Camera camera, Intersectable geomety)
	{
		List<Ray> raysList = Creat9RaysToVeiwPlane(camera);
		
		List<Point3D> intersectionPoints = new ArrayList<Point3D>();
		for (Ray ray : raysList) 
		{
			List<Point3D> temp;
			try 
			{
				temp = geomety.findIntersections(ray);
		
				if (temp != null)
					{
						intersectionPoints.addAll(temp);
					}
			}
			catch (Exception e) 
			{
				//e.printStackTrace();
				fail("dont need exception here");
			}
		}
		return intersectionPoints;
	}

	@Test
	public void constructRayThroughPixelSphere() 
	{
		try
		{
		
			//TC01:2 intersection points
			Sphere sphere=new Sphere(new Point3D(0,0,-3), 1);
			Camera camera = new Camera(new Point3D(0,0,0), new Vector(0,0,-1), new Vector(0,1,0)).setDistance(1).setViewPlaneSize(3, 3);
			assertEquals("The count of intersections are not correct", 2, findIntersectionPoints(camera, sphere).size());

		
			//TC02:18 intersection points
			sphere=new Sphere(new Point3D(0,0,-2.5), 2.5);
			camera = new Camera(new Point3D(0,0,0.5), new Vector(0,0,-1), new Vector(0,1,0)).setDistance(1).setViewPlaneSize(3, 3);	
			assertEquals("The count of intersections are not correct", 18, findIntersectionPoints(camera, sphere).size());
		
			//TC03:10 intersection points
			sphere=new Sphere(new Point3D(0,0,-2), 2);
			//same camera like tc02
			assertEquals("The count of intersections are not correct", 10, findIntersectionPoints(camera, sphere).size());
		
			//TC04:9 intersection points
			sphere = new Sphere(Point3D.ZERO, 4);
			camera = new Camera(Point3D.ZERO, new Vector(0,0,-1), new Vector(0,1,0)).setDistance(1).setViewPlaneSize(3, 3);
			assertEquals("The count of intersections are not correct", 9, findIntersectionPoints(camera, sphere).size());	
		
			//TC05:0 intersection points
			sphere=new Sphere(new Point3D(0,0,1), 0.5);
			camera = new Camera(new Point3D(0,0,0.5), new Vector(0,0,-1), new Vector(0,1,0)).setDistance(1).setViewPlaneSize(3, 3);	
			assertNull("The count of intersections are not correct", findIntersectionPoints(camera, sphere).size());
		
		}
		catch(Exception ex)
		{
			fail("dont need throws exception");
		}

	}
	
	@Test
	public void constructRayThroughPixelPlane() 
	{	
		try 
		{
			//TC01:9 intersection points
			Plane plane =new Plane(new Point3D(2,0,0), new Vector(0,1,0));
			Camera camera =new Camera(Point3D.ZERO, new Vector(0,1,0) , new Vector(0,-1,0));
			assertEquals("The count of intersections are not correct", 9, findIntersectionPoints(camera, plane).size());	

			//TC02:9 intersection points	
			assertEquals("The count of intersections are not correct", 9, findIntersectionPoints(camera, plane).size());	

			//TC03:6 intersection points
			assertEquals("The count of intersections are not correct", 6, findIntersectionPoints(camera, plane).size());	
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
			fail("dont need throws exception");
		}

	}
	
	@Test
	public void constructRayThroughPixelTriangle() 
	{
		try 
		{
			//TC01:1 intersection points
			Triangle triangle=new Triangle(new Point3D(0,1,-2),new Point3D(1,-1,-2),new Point3D(-1,-1,-2));
			Camera camera=new Camera(Point3D.ZERO, new Vector(0,0,-1), new Vector(0,1,0)).setDistance(1).setViewPlaneSize(3, 3);
			assertEquals("The count of intersections are not correct", 1, findIntersectionPoints(camera, triangle).size());	
			
			//TC02:2 intersection points
			triangle=new Triangle(new Point3D(0,20,-2),new Point3D(1,-1,-2),new Point3D(-1,-1,-2));
			//same camera
			assertEquals("The count of intersections are not correct", 2, findIntersectionPoints(camera, triangle).size());	
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
			fail("dont need throws exception");
		}
			
	}

}
