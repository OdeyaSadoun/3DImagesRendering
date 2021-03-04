package geometries;


import primitives.Vector;
import primitives.Point3D;

public interface Geometry 
{
	Vector getNormal(Point3D point);

}
