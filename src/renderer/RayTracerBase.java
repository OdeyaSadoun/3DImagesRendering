/**
 * 
 */
package renderer;
import java.util.List;

import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

/**
 * @author Home
 *
 */
public abstract class RayTracerBase 
{

	protected Scene myscene;
	public  RayTracerBase(Scene myscene)
	{
		this.myscene=myscene;
	}
	
	public Color traceRay(Ray ray)
	{
		try 
		{
			List<Point3D> intersections = myscene.geometries.findIntersections(ray);
			if(intersections==null)
				return  myscene.background;
			Point3D closestPoint = ray.findClosestPoint(intersections);
			return calcColor(closestPoint);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
