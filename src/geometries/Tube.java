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
	public Vector getNormal(Point3D point) throws Exception 
	{
		double t=axis.getDir().dotProduct(point.subtract(axis.getP0()));
		Point3D pointO =axis.getP0().add(axis.getDir().scale(t));
		Vector myVec=new Vector(point.subtract(pointO).getHead());
		return myVec.normalize();
		//Point3D p0=axis.getP0();
		//Vector v=axis.getDir();
		//double t=point.subtract(p0).dotProduct(v);
		//Point3D  o=p0.add(v.scale(t));
		//return point.subtract(o).normalize();
		
	}

}
