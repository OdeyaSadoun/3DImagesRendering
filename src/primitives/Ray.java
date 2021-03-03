/**
 * 
 */
package primitives;

/**
 * @author Home
 *
 */
public class Ray {
	Point3D p0;
	Vector dir;
	public Ray(Point3D p0, Vector dir)
	{
		this.p0=p0;
		this.dir=dir;
		dir.normalize();
	}
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
	public String toString() {
		return "p0=" + p0 + ", dir=" + dir + "";
	}
	
}

