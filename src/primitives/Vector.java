
package primitives;


/**
 * @author Home
 *
 */
public class Vector
{
	//The filed of this class is point that indicates the vector
	Point3D head;
	
	/**
	 * Constructor that receives point
	 * */
	public Vector(Point3D head)
	{
		this.head=head;		
		if (head.equals(Point3D.ZERO))
			throw new IllegalArgumentException("This vector is equals to zero vector");
	}
	
	/**
	 * Constructor that receives 3 coordinates and check if this is the ZERO point throws exception
	 * */
	public Vector(Coordinate x, Coordinate y, Coordinate z) 
	{
		head.x = x;
		head.y = y;
		head.z = z;	
		if (head.equals(Point3D.ZERO))
			throw new IllegalArgumentException("This vector is equals to zero vector");
	}
	
	/**
	 * Constructor that receives 3 double numbers and check if this is the ZERO point throws exception
	 * */
	public Vector(double a, double b, double c)
	{
		head = new Point3D(a,b,c);
		if (head.equals(Point3D.ZERO))
			throw new IllegalArgumentException("This vector is equals to zero vector");
	}
	
	/**
	 * A getter function for the field head
	 * */
	public Point3D getHead()
	{
		return head;
	}
	
	/**
	 * A function that performs a vector connection
	 * @param v Vector value
	 * */
	public Vector add(Vector v)
	{
		return new Vector(head.add(v));		
	}
	
	/**
	 * A function that performs vector subtraction
	 * @param v Vector value
	 * */
	public Vector subtract(Vector v)
	{
		Vector newVec= new Vector(head.subtract(v.head).head);
		return newVec;		
	}
	
	/**
	 * A function that performs vector multiplication in a scalar
	 * @param scalar double value
	 * */
	public Vector scale(double scalar)
	{			
		return new Vector(head.x.coord*scalar, head.y.coord*scalar, head.z.coord*scalar);
	}
	
	/**
	 * A function that performs a cross product
	 * @param v Vector value
	 * */
	public Vector crossProduct(Vector v)
	{
		Vector newVec=new Vector(head.y.coord*v.head.z.coord-head.z.coord*v.head.y.coord, head.z.coord*v.head.x.coord-head.x.coord*v.head.z.coord, head.x.coord*v.head.y.coord-head.y.coord*v.head.x.coord);
		return newVec;
	}
	
	/**
	 * A function that performs a dot product
	 * @param v Vector value
	 * */
	public double dotProduct(Vector v)
	{
		double count=head.x.coord*v.head.x.coord+head.y.coord*v.head.y.coord+head.z.coord*v.head.z.coord;
		return count;
	}
	
	/**
	 * A function that calculates the vector length squared
	 * */
	public double lengthSquared()
	{
		double sum=head.x.coord*head.x.coord+head.y.coord*head.y.coord+head.z.coord*head.z.coord;
		return sum;
	}
	
	/**
	 * A function that calculates vector length
	 * */
	public double length()
	{
		return Math.sqrt(lengthSquared());
	}
	
	/**
	 * The vector normalization operation that will change the vector itself,
	 * the function will also return the vector for the purpose of chaining the operations if necessary
	 * */
	public Vector normalize()
	{
		double sum=length();
		head.x = new Coordinate (head.x.coord/sum);
		head.y = new Coordinate (head.y.coord/sum);
		head.z = new Coordinate (head.z.coord/sum);	
		return this;
	}
	
	/**
	 * A normalization operation that returns a new normalized vector in the same direction as the original vector
	 * */
	public Vector normalized()
	{
		Vector temp=this;
		Vector newVec= new Vector(normalize().head);
		this.head=temp.head;
		return newVec;		
	}
	
	/*****************************************************************************/
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Vector)) return false;
		Vector other = (Vector)obj;
		return this.head.equals(other.head);
	}
	
	@Override
	public String toString()
	{
		return "The vector head=" + head + "";
	}
	   

	

}
