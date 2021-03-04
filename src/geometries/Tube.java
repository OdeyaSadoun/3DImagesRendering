package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Tube implements Geometry
{
	//The fields of this class are radius and ray
	protected double radius;
	protected Ray axis;
	
	/**
	 * Constructor that receives radius and ray
	 * */
	public Tube(double radius, Ray axis)
	{
		this.axis = axis;
		this.radius = radius;
	}
	
	/**
	 *  A getter function for the field radius
	 * */
	public double getRadius() 
	{
		return radius;
	}

	/**
	 *  A getter function for the field axis
	 * */
	public Ray getAxis() 
	{
		return axis;
	}

	/***************************************************************/

	@Override
	public String toString() 
	{
		return "Tube: radius=" + radius + ", axis=" + axis;
	}

	@Override
	public Vector getNormal(Point3D point) 
	{
		return null;
	}

}
