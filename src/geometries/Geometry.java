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
	Vector getNormal(Point3D point) throws Exception; // function get normal

}
