package geometries;
import primitives.Vector;
import primitives.Point3D;

/**
 * interface Geometry for all the geometries that have normal
 * 
 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
 * */
public interface Geometry extends Intersectable
{
	/**
	 * A function that return the normal of the geometry
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @param point
	 * @return Vector value
	 * */
	Vector getNormal(Point3D point) throws Exception; // function get normal

}
