package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.List;

/**
 * this class represent the option of border-able for the geometries
 */
public abstract class Borderable implements Intersectable 
{
    static protected boolean borderEnabled = false;

    public static void setEnabled() 
    {
        borderEnabled = true;
    }

    protected boolean boxed = false;

    /**
     * this values represent the minimum point of the geometry
     */
    public double minX;
    public double minY;
    public double minZ;

    /**
     * this values represent the maximum point of the geometry
     */
    public double maxX;
    public double maxY;
    public double maxZ;

    /**
     * find the minimum and the maximum of the geometry border
     */
    public final synchronized void findMinMax() 
    {
        if (!boxed)
        {
            findMinMaxParticular();
            boxed = true;
        }
    }

    protected abstract void findMinMaxParticular();

    protected boolean intersectBorderHelper(Ray ray) 
    {
        if (!boxed)
            findMinMax();
        return intersectBorder(ray);
    }

    /**
     * this function calculate if the ray trace the border of the geometry
     * https://www.scratchapixel.com/lessons/3d-basic-rendering/minimal-ray-tracer-rendering-simple-shapes/ray-box-intersection
     *
     * @param ray the crosses ray
     * @return true for intersection, false for not intersection
     */
    protected boolean intersectBorder(Ray ray)
    {
        Point3D origin = ray.getP0();
        double originX = origin.getX();
        double originY = origin.getY();
        double originZ = origin.getZ();
        Vector dir = ray.getDir();
        double dirX = dir.getHead().getX();
        double dirY = dir.getHead().getY();
        double dirZ = dir.getHead().getZ();

        // Initially will receive the values of tMinX and tMaxX
        double tMin;
        double tMax;

        if (Util.alignZero(dirX) >= 0) {
            tMin = (minX - originX) / dirX;
            tMax = (maxX - originX) / dirX;
        } else {
            tMin = (maxX - originX) / dirX;
            tMax = (minX - originX) / dirX;
        }

        double tMinY;
        double tMaxY;
        if (Util.alignZero(dirY) >= 0) {
            tMinY = (minY - originY) / dirY;
            tMaxY = (maxY - originY) / dirY;
        } else {
            tMinY = (maxY - originY) / dirY;
            tMaxY = (minY - originY) / dirY;
        }

        // If either the max value of Y is smaller than overall min value, or min value of Y is bigger than the overall
        // max, we can already return false.
        // Otherwise we'll update the overall min and max values and perform the same check on the Z values.
        if ((tMin > tMaxY) || (tMinY > tMax))
            return false;

        if (tMinY > tMin)
            tMin = tMinY;

        if (tMaxY < tMax)
            tMax = tMaxY;

        double tMinZ;
        double tMaxZ;

        if (Util.alignZero(dirZ) >= 0) {
            tMinZ = (minZ - originZ) / dirZ;
            tMaxZ = (maxZ - originZ) / dirZ;
        } else {
            tMinZ = (maxZ - originZ) / dirZ;
            tMaxZ = (minZ - originZ) / dirZ;
        }

        // If either the max value of Z is smaller than overall min value, or min value of Z is bigger than the overall
        // max, we can already return false. Otherwise we can return true since no other coordinate checks are needed.
        return tMin <= tMaxZ && tMinZ <= tMax;
    }

    public List<GeoPoint> findGeoIntersections(Ray ray) 
    {
        return borderEnabled && !intersectBorderHelper(ray) ? null : findGeoIntersectionsParticular(ray);
    }




  


}
