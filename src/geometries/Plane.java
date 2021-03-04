package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Plane implements Geometry 
{
	//The filed of this class are point and normal
	private Point3D point;
	private Vector normal;
	
	/**
	 * Constructor that receives 3 points
	 * */
	public Plane(Point3D p1, Point3D p2, Point3D p3)
	{
		normal = null;
		point = p1;
	}
	
	/**
	 * Constructor that receives point and normal
	 * */
	public Plane(Point3D p, Vector normal)
	{
		this.point = p;
		this.normal = normal;
	}

	/**
	 * A getter function for the field point
	 * */
	public Point3D getP() 
	{
		return point;
	}

	/**
	 * A getter function for the field normal
	 * */
	public Vector getNormal() 
	{
		return normal;
	}

	/*************************************************************/
	
	@Override
	public String toString() 
	{
		return "p=" + point + ", normal=" + normal;
	}
	
	@Override
	public Vector getNormal(Point3D p)
	{
		return null;
	}

}
