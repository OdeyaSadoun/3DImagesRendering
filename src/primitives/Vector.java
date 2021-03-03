/**
 * 
 */
package primitives;
import static primitives.Coordinate.*;
/**
 * @author Home
 *
 */
public class Vector {
	
	Point3D head;
	public Vector(Point3D head)
	{
		this.head=head;
	}
	public Vector(Coordinate x, Coordinate y, Coordinate z)
	{
		head.x = x;
		head.y = y;
		head.z = z;	
	}
	public Vector(double a, double b, double c)
	{
		head.x=new Coordinate(a);		
		head.y=new Coordinate(b);
		head.z=new Coordinate(c);
			
	}
	
	public Point3D getHead() {
		return head;
	}
	
	
	public Vector add(Vector v)
	{
		return new Vector(head.add(v));		
	}
	
	public Vector subtract(Vector v)
	{
		return new Vector(head.subtract(v));		
	}
	public Vector scale(double scalar)
	{			
		return new Vector(head.scale(scalar));
	}
	public Vector crossProduct(Vector v)
	{
		Vector newVec=new Vector(head.y.coord*v.head.z.coord-head.z.coord*v.head.y.coord, head.z.coord*v.head.x.coord-head.x.coord*v.head.z.coord, head.x.coord*v.head.y.coord-head.y.coord*v.head.x.coord);
		return newVec;
	}
	
	public double dotProduct(Vector v)
	{
		double count=head.x.coord*v.head.x.coord+head.y.coord*v.head.y.coord+head.z.coord*v.head.z.coord;
		return count;
	}
	public double lengthSquared()
	{
		double sum=head.x.coord*head.x.coord+head.y.coord*head.y.coord+head.z.coord*head.z.coord;
		return sum;
	}
	public double length()
	{
		return Math.sqrt(lengthSquared());
	}
	public Vector normalize()
	{
		double sum=length();
		head.x = new Coordinate (head.x.coord/sum);
		head.y = new Coordinate (head.y.coord/sum);
		head.z = new Coordinate (head.z.coord/sum);	
		return this;
	}
	public Vector normalized()
	{
		Vector temp=this;
		Vector newVec=normalize();
		this.head=temp.head;
		return newVec;		
	}
	   @Override
	   public boolean equals(Object obj) {
	      if (this == obj) return true;
	      if (obj == null) return false;
	      if (!(obj instanceof Vector)) return false;
	      Vector other = (Vector)obj;
	      return this.head.equals(other.head);
	   }

	

}
