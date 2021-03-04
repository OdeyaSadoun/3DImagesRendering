package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Tube implements Geometry
{

	protected double radius;
	protected Ray axis;
	
	public Tube(double radius, Ray axis)
	{
		this.axis = axis;
		this.radius = radius;
	}
	
	
	public double getRadius() 
	{
		return radius;
	}


	public Ray getAxis() 
	{
		return axis;
	}



	@Override
	public String toString() {
		return "Tube: radius=" + radius + ", axis=" + axis;
	}


	@Override
	public Vector getNormal(Point3D point) 
	{
		return null;
	}

}
