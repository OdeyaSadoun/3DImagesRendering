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
public class RayTracerBasic extends RayTracerBase 
{

	/**
	 * @param myscene Scene value
	 * 
	 */
	public RayTracerBasic(Scene myscene) 
	{
		super(myscene);
		//return null;
		
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
		catch (Exception ex) 
		{
			// TODO Auto-generated catch block
		
		}
		return null;
	}
	
	/**
	 * @param point Point3D value
	 * @return Color
	 * Function for calculating a point color
	 */
	private Color calcColor(Point3D point)
	{
		return myscene.ambientLight.getIntensity();
	}

}
