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
import geometries.Sphere;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author Home
 *
 */
public class CameraRays_Geometries 
{
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
	public void IntegrationSphere() 
	{
		try
		{
		
		//TC01:2 intersection points
		
		Sphere sphere=new Sphere(new Point3D(0,0,-3), 1);
		Camera camera = new Camera(new Point3D(0,0,0), new Vector(0,0,-1), new Vector(0,1,0)).setDistance(1).setViewPlaneSize(3, 3);
		assertEquals("the intersections are dont correct", findIntersectionPoints(camera, sphere).size() , camera.constructRayThroughPixel(3, 3, 0, 0));

		
		//TC02:18 intersection points
		
		sphere=new Sphere(new Point3D(0,0,-2.5), 2.5);
		camera = new Camera(new Point3D(0,0,0.5), new Vector(0,0,-1), new Vector(0,1,0)).setDistance(1).setViewPlaneSize(3, 3);	
		
		//TC03:10 intersection points
		
		sphere=new Sphere(new Point3D(0,0,-2), 2);
		
		//TC04:0 intersection points
		
		sphere=new Sphere(new Point3D(0,0,1), 0.5);
		
		//TC05:9 intersection points
		
		sphere=new Sphere(new Point3D(0,0,-2), 4);//?????

		
		}
		catch(Exception ex)
		{
			
		}

		fail("Not yet implemented");
	}

}
