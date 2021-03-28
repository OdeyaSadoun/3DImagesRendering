
package primitives;


/**
 * class for the functions in vector class
 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public class Vector
{
	//The filed of this class is point that indicates the vector
	Point3D head;
	
	/**
	 * Constructor that receives point
	 * 
	 * @param head Point3D value
	 * @throws Exception
	 * */
	public Vector(Point3D head) throws Exception
	{
		this.head=head;		
		if (head.equals(Point3D.ZERO))
			throw new IllegalArgumentException("This vector is equals to zero vector");
	}
	
	/**
	 * Constructor that receives 3 coordinates and check if this is the ZERO point throws exception
	 * 
	 * @param x Coordinate value
	 * @param y Coordinate value
	 * @param z Coordinate value
	 * @throws Exception
	 * */
	public Vector(Coordinate x, Coordinate y, Coordinate z)  throws Exception
	{
		head.x = x;
		head.y = y;
		head.z = z;	
		if (head.equals(Point3D.ZERO))
			throw new IllegalArgumentException("This vector is equals to zero vector");
	}
	
	/**
	 * Constructor that receives 3 double numbers and check if this is the ZERO point throws exception
	 * 
	 * @param a double value
	 * @param b double value
	 * @param c double value
	 * @throws Exception
	 * */
	public Vector(double a, double b, double c) throws Exception
	{
		head = new Point3D(a,b,c);
		if (head.equals(Point3D.ZERO))
			throw new IllegalArgumentException("This vector is equals to zero vector");
	}
	
	/**
	 * A getter function for the field head
	 * 
	 * @return Point3D value for head
	 * */
	public Point3D getHead()
	{
		return head;
	}
	
	/**
	 * A function that performs a vector connection
	 * 
	 * @param v Vector value
	 * @return new Vector for the result of add between two vectors
	 * @throws Exception
	 * */
	public Vector add(Vector v)  throws Exception
	{
		return new Vector(head.add(v));		
	}
	
	/**
	 * A function that performs vector subtraction
	 * 
	 * @param v Vector value
	 * @return new Vector for the result of subtract between two vectors
	 * @throws Exception
	 * */
	public Vector subtract(Vector v) throws Exception
	{
		return new Vector(head.subtract(v.head).head);	
	}
	
	/**
	 * A function that performs vector multiplication in a scalar
	 * 
	 * @param scalar double value
	 * @return new Vector for the result of scale between vector and scalar
	 * @throws Exception
	 * */
	public Vector scale(double scalar) throws Exception
	{			
		return new Vector(head.x.coord*scalar, head.y.coord*scalar, head.z.coord*scalar);
	}
	
	/**
	 * A function that performs a cross product
	 * 
	 * @param v Vector value
	 * @return new Vector for the result of crossProduct between two vectors
	 * @throws Exception
	 * */
	public Vector crossProduct(Vector v) throws Exception
	{
		return new Vector(head.y.coord*v.head.z.coord-head.z.coord*v.head.y.coord, head.z.coord*v.head.x.coord-head.x.coord*v.head.z.coord, head.x.coord*v.head.y.coord-head.y.coord*v.head.x.coord);
	}
	
	/**
	 * A function that performs a dot product
	 * 
	 * @param v Vector value
	 * @return double value for the result of dotProduct between two vectors
	 * */
	public double dotProduct(Vector v)
	{
		 return head.x.coord*v.head.x.coord+head.y.coord*v.head.y.coord+head.z.coord*v.head.z.coord;
	}
	
	/**
	 * A function that calculates the vector length squared
	 * 
	 * @return double value for the result of lengthSquared for the vector
	 * */
	public double lengthSquared()
	{
		return head.x.coord*head.x.coord+head.y.coord*head.y.coord+head.z.coord*head.z.coord;
	}
	
	/**
	 * A function that calculates vector length
	 * 
	 * @return double value for the result of length for the vector
	 * */
	public double length()
	{
		return Math.sqrt(lengthSquared());
	}
	
	/**
	 * The vector normalization operation that will change the vector itself,
	 * the function will also return the vector for the purpose of chaining the operations if necessary
	 * 
	 * @return the vector this after normalize 
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
	 * 
	 * @return new Vector that same to this vector but done normalize
	 * */
	public Vector normalized() throws Exception
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
