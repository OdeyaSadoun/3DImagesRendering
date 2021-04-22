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
 * @author Tamar Gavrieli & Odeya Sadoun
 *
 */
public abstract class RayTracerBase 
{

	protected Scene myscene;
	
	/**
	 * @param myscene Scene value
	 *
	 */
	public  RayTracerBase(Scene myscene)
	{
		this.myscene=myscene;
	}
	
	/**
	 * @param ray Ray value
	 * @throws Exception
	 *
	 */
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
		catch (Exception ex) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
