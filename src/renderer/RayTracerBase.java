package renderer;
import java.util.List;
import renderer.RayTracerBasic;
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
	 * Color calculation for the nearest point
	 */
	public abstract Color traceRay(Ray ray);
}
