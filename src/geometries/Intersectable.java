package geometries;

import primitives.Ray;

import java.util.List;
import java.util.stream.Collectors;

import primitives.Point3D;
/**
 * Interface for Intsersections
 * 
 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public interface Intersectable 
{
	/**
	 * A function that return all the intersection point with geometry
	 * 
	 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
	 * @param ray
	 * @return List<Point3D>
	 * @throws Exception
	 * */
	default List<Point3D> findIntersections(Ray ray) throws Exception 
	{
	    var geoList = findGeoIntersections(ray);
	    return geoList == null ? null
	                           : geoList.stream().map(gp -> gp.point).collect(Collectors.toList());
	}

	
	List<GeoPoint> findGeoIntersections (Ray ray) throws Exception;
	
	
	/**
	 * Static Internal Auxiliary Department (as a completely passive data structure - PDS)
	 * 
	 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
	 * @param geometry Geometry value
	 * @param point Point3D value
	 * */
	public static class GeoPoint 
	{
	    public Geometry geometry;
	    public Point3D point;
	    
	    
	    /**
	     * constructor for geo point
	     * 
	     * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
	     * @param geometry Geometry
	     * @param point Point3D
	     * */
	    public GeoPoint(Geometry geometry,Point3D point)
	    {
	    	this.geometry = geometry;
	    	this.point = point;
	    }
	    
		@Override
		public boolean equals(Object obj) 
		{
			if (this == obj) return true;
			if (obj == null) return false;
			if (!(obj instanceof GeoPoint)) return false;
			GeoPoint other = (GeoPoint)obj;
			return this.geometry.equals(other.geometry) && this.point.equals(other.point);
		}
		
	}


}
