package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Plane implements Geometry 
{
	private Point3D p;
	private Vector normal;
	public Plane(Point3D p1, Point3D p2, Point3D p3)
	{
		normal = null;
		p = p1;
	}
	
	public Plane(Point3D p, Vector normal)
	{
		this.p = p;
		this.normal = normal;
	}

	public Point3D getP() 
	{
		return p;
	}


	public Vector getNormal() 
	{
		return normal;
	}

	@Override
	public String toString() 
	{
		return "p=" + p + ", normal=" + normal;
	}
	
	@Override
	public Vector getNormal(Point3D p)
	{
		return null;
	}
	


}
