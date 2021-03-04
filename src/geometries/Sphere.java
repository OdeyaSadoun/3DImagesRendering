package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere implements Geometry
{
	private Point3D center;
	private double radius;
	
	public Sphere(Point3D p, double r)
	{
		center = p;
		radius = r;
	}

	
	public Point3D getCenter() 
	{
		return center;
	}


	public double getRadius() 
	{
		return radius;
	}

	@Override
	public String toString() 
	{
		return "Sphere: center=" + center + ", radius=" + radius;
	}


	@Override
	public Vector getNormal(Point3D point) 
	{
		return null;
	}

}
