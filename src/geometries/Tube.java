package geometries;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
/**
 * Class for Tube in geometries package
 * 
 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public class Tube extends Geometry
{
	//The fields of this class are radius and ray
	protected double radius;
	protected Ray axis;
	
	/**
	 * Constructor that receives radius and ray
	 * 
	 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
	 * @param radius double
	 * @param axis Ray
	 * */
	public Tube(double radius, Ray axis)
	{
		this.axis = axis;
		this.radius = radius;
	}
	
	/**
	 *  A getter function for the field radius 
	 *  
	 *  @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
	 *  @return double value for radius
	 * */
	public double getRadius() 
	{
		return radius;
	}

	/**
	 *  A getter function for the field axis
	 *  
	 *  @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
	 *  @return Ray value for axis
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
	public Vector getNormal(Point3D point) throws IllegalArgumentException 
	{
		double t=axis.getDir().dotProduct(point.subtract(axis.getP0()));
		Point3D pointO =axis.getP0().add(axis.getDir().scale(t));
		Vector myVec=point.subtract(pointO);
		return myVec.normalize();
		
	}

	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray)
	{
		return null;
	}

	@Override
	protected void findMinMaxParticular() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GeoPoint> findGeoIntersectionsParticular(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point3D getPositionPoint() {
		// TODO Auto-generated method stub
		return null;
	}

}
