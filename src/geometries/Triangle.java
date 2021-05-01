package geometries;
import static primitives.Util.*;

import java.util.ArrayList;
import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
/**
 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 * Class for Triangle
 */
public class Triangle extends Polygon 
{
	/**
	 * Constructor that receives 3 points and calls to the constructor of the base class
	 * 
	 * @param p1 Point3D
	 * @param p2 Point3D
	 * @param p3 Point3D
	 * @throws Exception 
	 * */
	public Triangle(Point3D p1,Point3D p2,Point3D p3) throws Exception 
	{
		super(p1,p2,p3);
		
	}

	/************************************************************/
	
	@Override
	public String toString() 
	{
		return "Triangle: "+super.toString();
	}

	@Override
	public List<Point3D> findIntersections(Ray ray) throws Exception 
	{
		List<Point3D> rayPoints = plane.findIntersections(ray);
		if (rayPoints == null)
			return null;
		//check if the point in out or on the triangle:
		Vector v1 = vertices.get(0).subtract(ray.getP0());
		Vector v2 = vertices.get(1).subtract(ray.getP0());
		Vector v3 = vertices.get(2).subtract(ray.getP0());
		
		Vector n1 = v1.crossProduct(v2).normalize();
		Vector n2 = v2.crossProduct(v3).normalize();
		Vector n3 = v3.crossProduct(v1).normalize();

		
		//The point is inside if all 𝒗 ∙ 𝑵𝒊 have the same sign (+/-)
		
		if (alignZero(n1.dotProduct(ray.getDir())) > 0 && alignZero(n2.dotProduct(ray.getDir())) > 0 && alignZero(n3.dotProduct(ray.getDir())) > 0)
		{
			return rayPoints;
		}
		else if (alignZero(n1.dotProduct(ray.getDir())) < 0 && alignZero(n2.dotProduct(ray.getDir())) < 0 && alignZero(n3.dotProduct(ray.getDir())) < 0)
		{
			return rayPoints;
		}
		if (isZero(n1.dotProduct(ray.getDir())) || isZero(n2.dotProduct(ray.getDir())) || isZero(n3.dotProduct(ray.getDir())))
			return null; //there is no instruction point
		return null;
	}
	

	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray) throws Exception 
	{

		
		List<GeoPoint> rayPoints = plane.findGeoIntersections(ray);
		if (rayPoints == null)
			return null;
		for (GeoPoint geoPoint : rayPoints) 
		{
			geoPoint.geometry = this;
		}
		//check if the point in out or on the triangle:
		Vector v1 = vertices.get(0).subtract(ray.getP0());
		Vector v2 = vertices.get(1).subtract(ray.getP0());
		Vector v3 = vertices.get(2).subtract(ray.getP0());
		
		Vector n1 = v1.crossProduct(v2).normalize();
		Vector n2 = v2.crossProduct(v3).normalize();
		Vector n3 = v3.crossProduct(v1).normalize();

		
		//The point is inside if all 𝒗 ∙ 𝑵𝒊 have the same sign (+/-)
		
		if (alignZero(n1.dotProduct(ray.getDir())) > 0 && alignZero(n2.dotProduct(ray.getDir())) > 0 && alignZero(n3.dotProduct(ray.getDir())) > 0)
		{
			return rayPoints;
		}
		else if (alignZero(n1.dotProduct(ray.getDir())) < 0 && alignZero(n2.dotProduct(ray.getDir())) < 0 && alignZero(n3.dotProduct(ray.getDir())) < 0)
		{
			return rayPoints;
		}
		if (isZero(n1.dotProduct(ray.getDir())) || isZero(n2.dotProduct(ray.getDir())) || isZero(n3.dotProduct(ray.getDir())))
			return null; //there is no instruction point
		return null;
		
	}
}
