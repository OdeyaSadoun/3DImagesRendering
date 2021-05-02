
package renderer;

import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

/**
 * class RayTracerBasic in package renderer
 * 
 * @author Tamar Gavrieli & Odeya Sadoun
 */
public class RayTracerBasic extends RayTracerBase 
{

	/**
	 * constructor
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param myscene Scene value
	 */
	public RayTracerBasic(Scene myscene) 
	{
		super(myscene);
		//return null;
		
	}
	
	/**
	 * Function that calculates the color for the nearest intersection point, 
	 * if no intersection points are returned the color of the background	
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param ray Ray value
	 * @return Color
	 * @throws Exception

	 *  */
	public Color traceRay(Ray ray) throws Exception
	{
			List<GeoPoint> intersections = myscene.geometries.findGeoIntersections(ray);
			if(intersections == null)
				return  myscene.background;
			GeoPoint closestPoint = ray.getClosestGeoPoint(intersections);
			return calcColor(closestPoint);
	}
	
	/**
	 * Function for calculating a point color	
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param point Point3D value
	 * @return Color
	 * */
	private Color calcColor(GeoPoint intersection) 
	{
		return myscene.ambientLight.getIntensity().add(intersection.geometry.getEmission());

	}

}
