/**
 * 
 */
package primitives;
import static primitives.Coordinate.*;

/**
 * @author Home
 *
 */


public class Point3D
{
	Coordinate x;
	Coordinate y;
	Coordinate z;
	static final Point3D ZERO= new Point3D(0,0,0);

	
	public Point3D(Coordinate x, Coordinate y, Coordinate z)
	{
		this.x = x;
		this.y = y;
		this.z = z;	
	}
	public Point3D(double a, double b, double c)
	{
		x.coord = a;
		y.coord = b;
		z.coord = c;	
	}
	
	public Point3D add(Vector v)
	{
		double myX=x.coord+v.head.x.coord;
		double myY=y.coord+v.head.y.coord;
		double myZ=z.coord+v.head.z.coord;
		Point3D p=new Point3D(myX, myY, myZ);		
		return p;
	}
	
	public Vector substract(Point3D p)
	{
		Vector v;
	}
	
	/**
	 * A function that return the distanceSquared between two vectors
	 * */
	public double distanceSquared(Point3D p)
	{
		double sum;
		sum=(x.coord-p.x.coord)*(x.coord-p.x.coord)+(y.coord-p.y.coord)*(y.coord-p.y.coord)+(z.coord-p.z.coord)*(z.coord-p.z.coord);
		return sum;
	}
	
	/**
	 * A function that return the distance between two vectors
	 * */
	public double distance(Point3D p)
	{
		Math.sqrt(distanceSquared(p));
	}
	
	public bool equals(Object obj)
	{
		
	}
	
	public Point3D scale(double scalar)
	{
		return new Point3D(x.coord*scalar, y.coord*scalar, z.coord*scalar);
	}


}
