package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere implements Geometry
{
	//The filed of this class are point of center and radius
	private Point3D center;
	private double radius;
	
	/**
	 * Constructor that receives point to the center and double to the radius
	 * */
	public Sphere(Point3D p, double r)
	{
		center = p;
		radius = r;
	}

	/**
	 * A getter function for the field center
	 * */
	public Point3D getCenter() 
	{
		return center;
	}

	/**
	 * A getter function for the field radius
	 * */
	public double getRadius() 
	{
		return radius;
	}

	/********************************************************************/
	
	@Override
	public String toString() 
	{
		return "Sphere: center=" + center + ", radius=" + radius;
	}

	@Override
	public Vector getNormal(Point3D point) throws Exception
	{
		
		Point3D myCenter=getCenter();
		Vector myVec=new Vector(point.subtract( myCenter).getHead());
		return myVec.normalize();
	}


}
