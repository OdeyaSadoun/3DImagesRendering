package renderer;
import java.util.List;

import geometries.Borderable;
import geometries.Geometries;
import renderer.RayTracerBasic;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

/**
 * class RayTracerBase of renderer package
 * 
 * @author Tamar Gavrieli & Odeya Sadoun
 */
public abstract class RayTracerBase 
{

	protected Scene myscene;
	
	/**
	 * constructor 
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param myscene Scene value	
	 */
	public  RayTracerBase(Scene myscene)
	{
		this.myscene=myscene;
	}
	
	
	public  RayTracerBase setBVH()
	{
		Borderable.setEnabled();
		//divideGeometries();
		return this;
	}
	



	/**
	 * Statement of an abstract function that calculates the color for the nearest intersection point, 
	 * if no intersection points are returned the color of the background	
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param ray Ray value
	 * @throws Exception
	 * @return Color
	 *  */
	public abstract Color traceRay(Ray ray) throws IllegalArgumentException ;

	protected abstract Color traceRay(List<Ray> rays);

//	protected abstract Color traceRay(List<Ray> rays);
}
