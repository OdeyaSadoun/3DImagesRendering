
package elements;
import static primitives.Util.*;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * class camera in the package elements
 * The purpose of the class is to create rays from the camera towards the various geometries of the scene.
 * 
 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
 */
public class Camera 
{
	private Point3D p0; //location of the camera
	private Vector vUp;
	private Vector vTo;
	private Vector vRight;
	private double width;
	private double height;
	private double distance;

	/**
	 * This constructor that creat new camera
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 2212380406
	 * @param vTo Vector value
	 * @param vUp Vector value
	 * @param p0 Point3D value
	 * @return Camera
	 * @throws Exception 
	 */
	public Camera(Point3D p0, Vector vTo, Vector vUp) throws IllegalArgumentException 
	{
		if(!isZero(vTo.dotProduct(vUp))) // if vTo doesn't orthogonal to vUp
			throw new IllegalArgumentException("vUp doesnt ortogonal to vTo");
		
		//all the vectors need to be normalize:
		this.vTo = vTo.normalize();
		this.vUp = vUp.normalize();
		vRight = (vTo.crossProduct(vUp)).normalize();
		
		this.p0 = p0;

	}
	
	/**
	 * Update function for View Plane size  
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @param width double value
	 * @param height double value
	 * @return Camera	 
	 */
	public Camera setViewPlaneSize(double width, double height)
	{
		this.width = width;
		this.height = height;
		return this;
	}
	
	
	/**
	 * Update function for distance
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @param distance double value
	 * @return Camera	 
	 */
	public Camera setDistance(double distance)
	{
		this.distance = distance;
		return this;
	}

	/**
	 * The function is responsible for creating the rays from the camera
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @param nX int value - resolution of pixel in X
	 * @param nY int value - resolution of pixel in Y
	 * @param j int value - index of column
	 * @param i int value - index of row
	 * @return Ray that created	 
	 * @throws Exception 
	 */
	public Ray constructRayThroughPixel(int nX, int nY, int j, int i ) 
	{
		Point3D Pc;
		if (isZero(distance))
			Pc=p0;
		else
			Pc=p0.add(vTo.scale(distance));
		
		double Ry= height/nY;
		double Rx=width/nX;
		double Yi=(i-(nY-1)/2d)*Ry;
		double Xj=(j-(nX-1)/2d)*Rx;
		
		if(isZero(Xj) && isZero(Yi))
			return new Ray (p0, Pc.subtract(p0));
		
		Point3D Pij = Pc;
		
		if(!isZero(Xj))
			Pij = Pij.add(vRight.scale(Xj));
		
		if(!isZero(Yi))
			Pij = Pij.add(vUp.scale(-Yi));
		
		Vector Vij = Pij.subtract(p0);
		
		if(Pij.equals(p0))
			return new Ray(p0, new Vector(Pij));
		return new Ray(p0, Vij);

	}

	/**
	 * Getter for p0
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return Point3D value for p0	 
	 */
	public Point3D getP0() 
	{
		return p0;
	}

	/**
	 * Getter for vUp
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return Vector value for vUp	 
	 */
	public Vector getvUp() 
	{
		return vUp;
	}

	/**
	 * Getter for vTo
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return Vector value for vTo	 
	 */
	public Vector getvTo() 
	{
		return vTo;
	}
	
	/**
	 * Getter for vRight
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return Vector value for vRight	 
	 */
	public Vector getvRight() 
	{
		return vRight;
	}

	/**
	 * Getter for width
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return double value for width	 
	 */
	public double getWidth() 
	{
		return width;
	}

	/**
	 * Getter for height
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return double value for height	 
	 */
	public double getHeight() 
	{
		return height;
	}

	/**
	 * Getter for distance
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return double value for distance	 
	 */
	public double getDistance() 
	{
		return distance;
	}

	

}
