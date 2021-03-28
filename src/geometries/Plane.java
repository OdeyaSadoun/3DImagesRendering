package geometries;

import primitives.Point3D;
import primitives.Vector;
/**
 *   Class for Plane
 *   @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public class Plane implements Geometry 
{
	//The filed of this class are point and normal
	private Point3D point;
	private Vector normal;
	
	/**
	 * Constructor that receives 3 points
	 * 
	 * @param p1 Point3D
	 * @param p2 Point3D
	 * @param p3 Point3D
	 * @throws Exception
	 * */
	public Plane(Point3D p1, Point3D p2, Point3D p3)throws Exception
	{
		Vector myVec1=(p2.subtract(p1));
		Vector myVec2=(p3.subtract(p1));		
		normal = myVec1.crossProduct(myVec2).normalize();
		point = p1;
	}
	
	/**
	 * Constructor that receives point and normal
	 * 
	 * @param p Point3D
	 * @param normal Vector
	 * */
	public Plane(Point3D p, Vector normal)
	{
		this.point = p;
		this.normal = normal;
	}

	/**
	 * A getter function for the field point
	 * 
	 * @return Point3D value for point
	 * */
	public Point3D getP() 
	{
		return point;
	}

	/**
	 * A getter function for the field normal that return normal
	 * 
	 * @return Vector value for normal
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
		return normal;
	}

}
