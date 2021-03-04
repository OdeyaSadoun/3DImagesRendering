package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube 
{
	//The field of this class is height
	private double height;
	
	/**
	 * Constructor that receives radius, ray and height, and use in the constructor of the base class
	 * */
	public Cylinder(double radius, Ray axis, double height)
	{
		super(radius,axis);
		this.height = height;
	}
	
	/**
	 * A getter function for the field height
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
		return null;
	}

}
