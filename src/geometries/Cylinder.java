package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube 
{

	private double height;
	
	public Cylinder(double radius, Ray axis, double height)
	{
		super(radius,axis);
		this.height = height;
	}
	
	public double getHeight() 
	{
		return height;
	}


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
