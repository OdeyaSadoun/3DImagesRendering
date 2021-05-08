package primitives;
import java.util.List;
import geometries.Intersectable.GeoPoint;
/**
 * class for ray in package primitives
 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public class Ray 
{
	//The fields of this class are point and direction - vector
	Point3D p0;
	Vector dir;
	
	/**
	 * Constructor that receives point and vector
	 * in addition the c-tor normalize the vector
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @param p0 Point3D value
	 * @param dir Vector value
	 * */
	public Ray(Point3D p0, Vector dir)
	{
		this.p0=p0;
		this.dir=dir;
		dir.normalize();
	}
	
	/**
	 * A getter function for the field p0
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return Point3D value for p0
	 * */
	public Point3D getP0() 
	{
		return p0;
	}
	
	/**
	 * A getter function for the field dir
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return Vector value for the direction
	 * */
	public Vector getDir() 
	{
		return dir.normalize();
	}

	/**
	 * The function do p0+t*v
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @param t double value
	 * @return Point3D value
	 * @throws Exception
	 * */
	public Point3D getPoint(double t) throws IllegalArgumentException
	{
		return p0.add(dir.scale(t));
	}
	
	/**
	 * The function returns the point closest to the beginning of the beam
	 * from all the intersection points of the resulting list.
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @param points List<Point3D> value
	 * @return Point3D value
	 * */
	public Point3D findClosestPoint (List<Point3D> points)
	{
		if(points == null)
			return null;
		Point3D closet = points.get(0);
		for (Point3D point3d : points) 
		{
			if(point3d.distance(p0) < closet.distance(p0))
				closet= point3d;
		}
		return closet;
	}

	public GeoPoint getClosestGeoPoint(List<GeoPoint> intersections)
	{
		
		if(intersections == null)
			return null;
		GeoPoint closet = intersections.get(0);
		for (GeoPoint geoPoint : intersections) 
		{
			if(geoPoint.point.distance(p0) < closet.point.distance(p0))
				closet= geoPoint;
			
		}
		return closet;
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

