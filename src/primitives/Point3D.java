
package primitives;


/**
 * @author Home
 *
 */


public class Point3D
{
	//The fields of this class are 3 coordinates
	Coordinate x;
	Coordinate y;
	Coordinate z;
	
	/**
	 * A constant that represents the zero point
	 * */
	public static final Point3D ZERO= new Point3D(0,0,0);

	/**
	 * Constructor that receives 3 coordinates
	 * */
	public Point3D(Coordinate x, Coordinate y, Coordinate z)
	{
		this.x = x;
		this.y = y;
		this.z = z;	
	}
	
	/**
	 * Constructor that receives 3 double numbers and make from them 3 coordinates
	 * */
	public Point3D(double a, double b, double c)
	{
		x = new Coordinate(a);
		y = new Coordinate(b);
		z = new Coordinate(c);
	}
	
	/**
	 * A function that receives a vector and adds it to the point of the class
	 * @param v Vector value
	 * */
	public Point3D add(Vector v)
	{
		double myX=x.coord+v.head.x.coord;
		double myY=y.coord+v.head.y.coord;
		double myZ=z.coord+v.head.z.coord;
		Point3D p=new Point3D(myX, myY, myZ);		
		return p;
	}
	
	/**
	 * A function that subtracts point from the existing point, the result is basically a new vector
	 * @param p Point3D value
	 * */
	public Vector subtract(Point3D p)
	{
		Vector newVec=new Vector(x.coord-p.x.coord, y.coord-p.y.coord, z.coord-p.z.coord);
		return newVec;
		/*
		try
		{
		newVec= new Vector(x.coord-p.x.coord, y.coord-p.y.coord, z.coord-p.z.coord);	
		return newVec;
		}
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		*/
		
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
		return Math.sqrt(distanceSquared(p));
	}
	
	/*********************************************************************/
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Point3D)) return false;
		Point3D other = (Point3D)obj;
		return this.x.equals(other.x) && this.y.equals(other.y)&& this.z.equals(other.z);
	}
	
	@Override
	public String toString() 
	{
		return "Point: ("+ x + ","+ y+"," + z+")";
	}
	


}
