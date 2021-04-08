
package elements;
import static primitives.Util.*;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author אודיה סעדון
 *
 */
public class Camera 
{
	// TODO Auto-generated constructor stub
	private Point3D p0;//location
	private Vector vUp;
	private Vector vTo;
	private Vector vRight;
	private double width;
	private double height;
	private double distance;

	/**
	 * This constructor that creat new camera
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param vTo Vector value
	 * @param vUp Vector value
	 * @param p0 Point3D value
	 * @return Camera
	 * @throws Exception 
	 */
	public Camera(Vector vTo, Vector vUp, Point3D p0) throws Exception 
	{
		if(!isZero(vTo.dotProduct(vUp)))
			throw new IllegalArgumentException("vUp doesnt ortogonal to vTo");
		
		this.vTo = vTo.normalize();
		this.vUp = vUp.normalize();
		vRight = (vTo.crossProduct(vUp)).normalize();	
		this.p0 = p0;

	}
	
	/**
	 * Update function for View Plane size  
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param width double value
	 * @param height double value
	 * @return Camera	 
	 */
	public Camera setViewPlaneSize(double width, double height)
	{
		return this;
	}
	
	
	/**
	 * Update function for distance
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param distance double value
	 * @return Camera	 
	 */
	public Camera setDistance(double distance)
	{
		return this;
	}

	/**
	 * ??
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param nX int value
	 * @param nY int value
	 * @param j int value
	 * @param i int value
	 * @return null	 
	 */
	public Ray constructRayThroughPixel(int nX, int nY, int j, int i)
	{
		return null;
	}

	/**
	 * Getter for p0
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @return p0	 
	 */
	public Point3D getP0() 
	{
		return p0;
	}

	/**
	 * Getter for vUp
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @return vUp	 
	 */
	public Vector getvUp() 
	{
		return vUp;
	}

	/**
	 * Getter for vTo
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @return vTo	 
	 */
	public Vector getvTo() 
	{
		return vTo;
	}
	
	/**
	 * Getter for vRight
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @return vRight	 
	 */
	public Vector getvRight() 
	{
		return vRight;
	}

	/**
	 * Getter for width
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @return width	 
	 */
	public double getWidth() 
	{
		return width;
	}

	/**
	 * Getter for height
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @return height	 
	 */
	public double getHeight() 
	{
		return height;
	}

	/**
	 * Getter for distance
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @return distance	 
	 */
	public double getDistance() 
	{
		return distance;
	}

	

}
