package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
/**
 *   Class for  Cylinder
 *   @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public class Cylinder extends Tube 
{
	//The field of this class is height
	private double height;
	
	/**
	 * Constructor that receives radius, ray and height, and use in the constructor of the base class
	 * 
	 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
	 * @param radius double value
	 * @param axis Ray value
	 * @param height double value
	 * */
	public Cylinder(double radius, Ray axis, double height)
	{
		super(radius,axis);
		this.height = height;
	}
	
	/**
	 * A getter function for the field height that return double value for height
	 * 
	 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
	 * @return double value for height
	 * */
	public double getHeight() 
	{
		return height;
	}

	/******************************************************************/
	
	@Override
	public String toString() 
	{
		return "Cylinder: "+super.toString()+" height=" + height;
	}

	@Override
	public Vector getNormal(Point3D point) 
	{
		//bonus
		return null;
	}

}
