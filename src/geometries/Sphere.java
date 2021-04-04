package geometries;
import java.util.ArrayList;
import java.util.List;
import static primitives.Util.*;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
/**
 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 * Class for Sphere
 */
public class Sphere implements Geometry
{
	//The filed of this class are point of center and radius
	private Point3D center;
	private double radius;
	
	/**
	 * Constructor that receives point to the center and double to the radius
	 * 
	 * @param p Point3D
	 * @param r double
	 * */
	public Sphere(Point3D p, double r)
	{
		center = p;
		radius = r;
	}

	/**
	 * A getter function for the field center
	 * 
	 * @return Point3D value for center
	 * */
	public Point3D getCenter() 
	{
		return center;
	}

	/**
	 * A getter function for the field radius
	 * 
	 *  @return double value for radius
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

	@Override
	public List<Point3D> findIntersections(Ray ray) throws Exception 
	{
		
		if (ray.getP0().equals(center)) // if the begin of the ray in the center, the point, is on the radius
			return List.of(ray.getPoint(radius));
		//List<Point3D> rayPoints = new ArrayList<Point3D>();
		Vector u = center.subtract(ray.getP0());
		double tM = alignZero(ray.getDir().dotProduct(u));
		double d = alignZero(Math.sqrt(u.length()*u.length()- tM * tM));
		double tH = alignZero(Math.sqrt(radius*radius - d*d));
		double t1 = alignZero(tM+tH);
		double t2 = alignZero(tM-tH);
		
		
		if (d > radius)
			return null; // there are no instructions

		
		if(isZero(d-radius))
			return null;
		
		if (t1 <=0 && t2<=0)
			return null;
		
		if (t1 > 0 && t2 >0)
			return List.of(ray.getPoint(t1),ray.getPoint(t2));
		if (t1 > 0)
		{
			return List.of(ray.getPoint(t1));
		}

		else
			return List.of(ray.getPoint(t2));

	}


}
