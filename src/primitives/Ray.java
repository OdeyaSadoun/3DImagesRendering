
package primitives;

/**
 * @author Home
 *
 */
public class Ray 
{
	//The fields of this class are point and direction - vector
	Point3D p0;
	Vector dir;
	
	/**
	 * Constructor that receives point and vector
	 * in addition the c-tor normalize the vector
	 * */
	public Ray(Point3D p0, Vector dir)
	{
		this.p0=p0;
		this.dir=dir;
		dir.normalize();
	}
	
	/**
	 * A getter function for the field p0
	 * */
	public Point3D getP0() 
	{
		return p0;
	}
	
	/**
	 * A getter function for the field dir
	 * */
	public Vector getDir() 
	{
		return dir;
	}




	/***********************************************************/
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) return true;
	    if (obj == null) return false;
	    if (!(obj instanceof Ray)) return false;
	    Ray other = (Ray)obj;
	    return this.p0.equals(other.p0) && this.dir.equals(other.dir);
	}
	
	@Override
	public String toString() 
	{
		return "Ray: p0=" + p0 + ", dir=" + dir + "";
	}
	
}

