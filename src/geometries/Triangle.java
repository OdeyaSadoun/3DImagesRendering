package geometries;
import primitives.Point3D;
/**
 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 * Class for Triangle
 */
public class Triangle extends Polygon implements Geometry
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

}
