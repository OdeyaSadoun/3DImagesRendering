/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import elements.Camera;
import geometries.Sphere;
import primitives.Point3D;
import primitives.Vector;

/**
 * @author Home
 *
 */
public class CameraRays_Geometries 
{
	

	@Test
	public void IntegrationSphere() 
	{
		try
		{
		
		//TC01:2 intersection points
		
		Sphere sphere=new Sphere(new Point3D(0,0,-3), 1);
		Camera camera = new Camera(new Point3D(0,0,0), new Vector(0,0,-1), new Vector(0,1,0)).setDistance(1).setViewPlaneSize(3, 3);

		
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
