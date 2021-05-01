package geometries;
import primitives.Vector;
import primitives.Color;
import primitives.Point3D;

/**
 * interface Geometry for all the geometries that have normal
 * 
 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
 * */
public abstract class Geometry implements Intersectable
{
	/**
	 * A function that return the normal of the geometry
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @param point
	 * @return Vector value
	 * */
	protected  Color emmission = Color.BLACK;
	public abstract Vector getNormal(Point3D point) throws Exception; // function get normal
	
	/**
	 * getter function for the color filed in geometry class
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return emmission Color value
	 * */
	public Color getEmmission() 
	{
		return emmission;
	}
	
	/**
	 * setter function for the color filed and return this- geometry class
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return the geometry-this
	 * */
	public Geometry setEmmission(Color emmission) 
	{
		this.emmission = emmission;
		return this;
	}

}
