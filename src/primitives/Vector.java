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
		Coordinate aa=new Coordinate(a);
		head.x=aa;
		Coordinate bb=new Coordinate(b);
		head.y=bb;
		Coordinate cc=new Coordinate(c);
		head.z=cc;
			
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
	public double crossProduct(Vector v)
	{
		
	}
	
	public double dotProduct(Vector v)
	{
		double sum=head.x.coord*v.head.x.coord+head.y.coord*v.head.y.coord+head.z.coord*v.head.z.coord;
		return sum;
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
		head.x.coord = head.x.coord/sum;
		head.y.coord = head.y.coord/sum;
		head.z.coord = head.z.coord/sum;	
		return new Vector(head.x.coord/sum, head.y.coord/sum, head.z.coord/sum );
	}
	public Vector normalized()
	{
		
	}
	public bool equals(Object obj)
	{
		
	}
	

}
