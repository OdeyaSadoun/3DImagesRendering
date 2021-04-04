package geometries;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
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
		if (p1.equals(p2)|| p2.equals(p3)|| p3.equals(p1))//Check if two points coalesce
			throw new IllegalArgumentException("Two points converge");
		
		Vector myVec1=(p2.subtract(p1));// vector p2p1
		Vector myVec2=(p3.subtract(p1));//vector p3p1	
		
		if(myVec1.getHead().getX()/myVec2.getHead().getX() == myVec1.getHead().getY()/myVec2.getHead().getY() & myVec1.getHead().getZ()/myVec2.getHead().getZ() == myVec1.getHead().getY()/myVec2.getHead().getY())
			throw new IllegalArgumentException("Two points or more exist in one line");
		
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

	@Override
	public List<Point3D> findIntersections(Ray ray) throws Exception 
	{
		double nv = normal.dotProduct(ray.getDir());
		if (isZero(nv))
		{
			throw new IllegalArgumentException("cannot divide in 0");
		}
		
		Vector pSubtractP0 = point.subtract(ray.getP0());
		if (pSubtractP0.getHead().equals(Point3D.ZERO))
		{
			throw new IllegalArgumentException("The subtraction creates the zero vector, which will cause the calculation to be reset.");
		}
		
		double t = alignZero((normal.dotProduct(pSubtractP0))/nv);

		if(t <= 0)
		{
			return null;
		}
			
		
//		List<Point3D> rayPoints = new ArrayList<Point3D>();
//		rayPoints.add(ray.getPoint(t));
//		return rayPoints;
		return List.of(ray.getPoint(t));
	}

}
