package geometries;
import primitives.Point3D;
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


}
