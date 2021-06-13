
package elements;
import static primitives.Util.*;

import java.util.ArrayList;
import java.util.List;

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
	
	
	
	public List<Ray> constructBeamThroughPixel (int nX, int nY, int j, int i, int raysAmount)
	{
//		//זריקת כמות של קרניים לתוך צורת גריד
//		List<Ray> Rays = new ArrayList<Ray>();
		int numOfRays = (int)Math.floor(Math.sqrt(raysAmount)); //num of rays in each row or column
		
		if (numOfRays==1) 
			return List.of(constructRayThroughPixel(nX, nY, j, i));
//
		Point3D Pc;
		if (isZero(distance))
			Pc=p0;
		else
			Pc=p0.add(vTo.scale(distance));
		
		double Ry= height/nY;
		double Rx=width/nX;
		double Yi=(i-(nY-1)/2d)*Ry;
		double Xj=(j-(nX-1)/2d)*Rx;
//		
//		if(isZero(Xj) && isZero(Yi))
//			return List.of(new Ray (p0, Pc.subtract(p0)));
//		
//		Point3D Pij = Pc;
//		
//		if(!isZero(Xj))
//			Pij = Pij.add(vRight.scale(Xj));
//		
//		if(!isZero(Yi))
//			Pij = Pij.add(vUp.scale(-Yi));
//		
//		Vector Vij = Pij.subtract(p0);
//        
        double PRy = Ry / numOfRays; //height distance between each ray
        double PRx = Rx / numOfRays; //width distance between each ray
//        
//        Point3D tmp = Pij; //center
//        
//        //creating a grid in the pixel:
//        for (int row=0; row<numOfRays; row++) 
//        {
//        	double Pxj = (row - (numOfRays/2d)) * PRx + PRx/2d;
//        	for (int column=0; column<numOfRays; column++)
//        	{
//        		double Pyi = (column - (numOfRays/2d)) * PRy + PRy/2d;
//        		if (Pxj != 0)
//        			Pij = Pij.add(this.vRight.scale(-Pxj));
//        		if (Pyi != 0)
//        			Pij = Pij.add(this.vUp.scale(-Pyi)); 
//        		Rays.add(new Ray(p0, Vij));
//        		Pij = tmp; //restart
//        	}
//        }
//        return Rays;
		
		
	      //The distance between the screen and the camera cannot be 0
        if (isZero(distance))
        {
            throw new IllegalArgumentException("distance cannot be 0");
        }

        List<Ray> sample_rays = new ArrayList<>();
//
//        double Ry = height/nY; //The number of pixels on the y axis
//        double Rx = width/nX;  //The number of pixels on the x axis
//        double yi =  ((i - nY/2d)*Ry); //distance of original pixel from (0,0) on Y axis
////        double xj=   ((j - nX/2d)*Rx); //distance of original pixel from (0,0) on x axis
//        double pixel_Ry = Ry/num_of_sample_rays; //The height of each grid block we divided the parcel into
//        double pixel_Rx = Rx/num_of_sample_rays; //The width of each grid block we divided the parcel into

        for (int row = 0; row < numOfRays; ++row) {//foreach place in the pixel grid
            for (int column = 0; column < numOfRays; ++column) {
                sample_rays.add(constructRaysThroughPixel(PRy,PRx,Yi, Xj, row, column,distance));//add the ray
            }
        }
        sample_rays.add(constructRayThroughPixel(nX, nY, j, i));//add the center screen ray
        return sample_rays;
	}
	
	 /**
     * In this function we treat each pixel like a little screen of its own and divide it to smaller "pixels".
     * Through each one we construct a ray. This function is similar to ConstructRayThroughPixel.
     * @param Ry height of each grid block we divided the pixel into
     * @param Rx width of each grid block we divided the pixel into
     * @param yi distance of original pixel from (0,0) on Y axis
     * @param xj distance of original pixel from (0,0) on X axis
     * @param j j coordinate of small "pixel"
     * @param i i coordinate of small "pixel"
     * @param distance distance of screen from camera
     * @return beam of rays through pixel
     */
    private Ray constructRaysThroughPixel(double Ry,double Rx, double yi, double xj, int j, int i, double distance)
    {
        Point3D Pc = p0.add(vTo.scale(distance)); //the center of the screen point

        double y_sample_i =  (i *Ry + Ry/2d); //The pixel starting point on the y axis
        double x_sample_j=   (j *Rx + Rx/2d); //The pixel starting point on the x axis

        Point3D Pij = Pc; //The point at the pixel through which a beam is fired
        //Moving the point through which a beam is fired on the x axis
        if (!isZero(x_sample_j + xj))
        {
            Pij = Pij.add(vRight.scale(x_sample_j + xj));
        }
        //Moving the point through which a beam is fired on the y axis
        if (!isZero(y_sample_i + yi))
        {
            Pij = Pij.add(vUp.scale(-y_sample_i -yi ));
        }
        Vector Vij = Pij.subtract(p0);
        return new Ray(p0,Vij);//create the ray throw the point we calculate here
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
