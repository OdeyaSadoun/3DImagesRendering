
package renderer;

import java.util.List;

import elements.LightSource;
import geometries.Intersectable.GeoPoint;
import primitives.*;
import static primitives.Util.*;


import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;
import scene.Scene;

/**
 * class RayTracerBasic in package renderer
 * 
 * @author Tamar Gavrieli & Odeya Sadoun
 */
public class RayTracerBasic extends RayTracerBase 
{
	//private static final double DELTA = 0.1;


	/**
	 * Limiting the recursion depth
	 * */
	private static final int MAX_CALC_COLOR_LEVEL = 10;
	
	/**
	 * 
	 * */
	private static final double MIN_CALC_COLOR_K = 0.001;

	private static final double INITIAL_K = 1.0;
	
	/**
	 * constructor of RayTracerBasic
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param myscene Scene value
	 */
	public RayTracerBasic(Scene myscene) 
	{
		super(myscene);
	}
	
	/**
	 * Function that calculates the color for the nearest intersection point, 
	 * if no intersection points are returned the color of the background	
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param ray Ray value
	 * @return Color

	 *  */
	public Color traceRay(Ray ray) 
	{

			GeoPoint closestPoint = findClosestIntersection(ray);
			return closestPoint == null ? myscene.background : calcColor(closestPoint, ray);
	}
	
	
	
	   /**
     * @param rays List of surrounding rays
     * @return average color
     */
    protected Color traceRay(List<Ray> rays) 
    {
    	if(rays == null)
    		return myscene.background;
        Color color = Color.BLACK;
        Color bkg = myscene.background;
        for (Ray ray : rays) 
        {
        	GeoPoint gp = findClosestIntersection(ray);
        	color = color.add(gp == null ? bkg : calcColor(gp, ray, MAX_CALC_COLOR_LEVEL, 1d));
        }
        color = color.add(myscene.ambientLight.getIntensity());
        int size = rays.size();
        return (size == 1) ? color : color.reduce(size);
//        color = color.add(calcColor(rays));
////        for (Ray ray : rays) 
////        {
////            GeoPoint gp = findClosestIntersection(ray);
////            if(gp!=null)
////            {}
////            color = color.add(gp == null ? myscene.background : calcColor(gp, ray));
////        }
//        color = color.add(myscene.ambientLight.getIntensity());
////        int size = rays.size();
//        return (rays.size() == 1) ? color : color.reduce(rays.size());
//       // return color;
    }
	

	private Color calcColor(GeoPoint geopoint, Ray ray) 
	{
		return calcColor(geopoint, ray, MAX_CALC_COLOR_LEVEL, INITIAL_K).add(myscene.ambientLight.getIntensity());
	}
	
	/**
	 * Function for calculating a point color - recursive function	
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param point Point3D value
	 * @return Color
	 * @throws IllegalArgumentException 
	 * */
	private Color calcColor(GeoPoint intersection, Ray ray, int level, double k) throws IllegalArgumentException 
	{
		/*𝑰𝑷 = 𝒌𝑨 ∙ 𝑰𝑨 + 𝑰𝑬 + (𝒌𝑫 ∙ |𝒍 ∙ 𝒏| + 𝒌𝑺 ∙ (−𝒗 ∙ 𝒓)^ 𝒏𝒔𝒉)) ∙ 𝑰L*/
		Color Ie = intersection.geometry.getEmission(); 
		Color color = Ie.add(calcLocalEffects(intersection, ray,k));
		return 1 == level ? color : color.add(calcGlobalEffects(intersection, ray, level, k , intersection.geometry.getNormal(intersection.point)));

	}
	
 
	
	/**
	 * A function that calculate the globals effects of the color
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param intersection GeoPoint value
	 * @param ray Ray value
	 * @param level int value
	 * @param k double value
	 * @param n Vector value
	 * @return Color
	 * */
	private Color calcGlobalEffects(GeoPoint intersection, Ray ray, int level, double k , Vector n)
	{
		if (level == 1 || k < MIN_CALC_COLOR_K)
		{
			return Color.BLACK;
		}
		Color color = Color.BLACK;
		Material material = intersection.geometry.getMaterial();
		double kr = material.KR;
		double kkr = k * kr;
		if (kkr > MIN_CALC_COLOR_K) 
		{
			Ray reflectedRay = constructReflectedRay(n, intersection.point, ray);
			GeoPoint reflectedPoint = findClosestIntersection(reflectedRay);
			if (reflectedPoint != null)
				color = color.add(calcColor(reflectedPoint, reflectedRay, level - 1, kkr).scale(kr));
			else
				color = color.add(myscene.background.scale(kr));
		}
		double kt = material.KT;
		double kkt = k * kt;
		if (kkt > MIN_CALC_COLOR_K) 
		{
			Ray refractedRay = constructRefractedRay(n, intersection.point, ray);
			GeoPoint refractedPoint = findClosestIntersection(refractedRay);
			if (refractedPoint != null)
				color = color.add(calcColor(refractedPoint, refractedRay, level - 1, kkt).scale(kt));
			else
				color = color.add(myscene.background.scale(kt));
		}
		return color;
	}

//	  /**
//     * @param rays List of surrounding rays
//     * @return average color
//     */
//    private Color calcColor(List<Ray> rays)
//    {
//        Color bkg = myscene.background;
//        Color color = Color.BLACK;
//        for (Ray ray : rays) {
//            GeoPoint gp = findClosestIntersection(ray);
//            color = color.add(gp == null ? bkg : calcColor(gp, ray, MAX_CALC_COLOR_LEVEL, 1d));
//        }
//        color = color.add(myscene.ambientLight.getIntensity());
//        int size = rays.size();
//        return (size == 1) ? color : color.reduce(size);
//    }
	
	/**
	 * A function that find the most closet point to the ray
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param ray Ray value
	 * @return the closet point
	 * */
	private GeoPoint findClosestIntersection(Ray ray)
	{
		List<GeoPoint> intersections = myscene.geometries.findGeoIntersections(ray);
		if(intersections == null)
			return  null;
		return ray.getClosestGeoPoint(intersections);
	}

	/**
	 * A function that calculates the refracted rays.
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param normal Vector value
	 * @param point Point3D value
	 * @param ray Ray value
	 * @return ray for refracted
	 * */
	private Ray constructRefractedRay(Vector normal, Point3D point, Ray ray) //שקיפות
	{
		Vector v = ray.getDir();
		return new Ray(point, v ,normal);
	}

	
	
	/**
	 * A function that calculates the reflected rays.
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param normal Vector value
	 * @param point Point3D value
	 * @param ray Ray value
	 * @return ray for reflected
	 * */
	private Ray constructReflectedRay(Vector normal, Point3D point, Ray ray) //השתקפות
	{
		// 𝒓 = 𝒗 − 𝟐 ∙ (𝒗 ∙ 𝒏) ∙ n
		Vector v = ray.getDir();
		double nv = alignZero(normal.dotProduct(v));
		if (isZero(nv))
			return null;
		Vector r = v.subtract(normal.scale(nv*2));
		return new Ray(point, r, normal);
	}

	/**
	 * help function that calculate the local color
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param intersection GeoPoint value
	 * @param ray Ray value
	 * */
	private Color calcLocalEffects(GeoPoint intersection, Ray ray, double k) 
	{
		Vector v = ray.getDir().normalize();
		Vector n = intersection.geometry.getNormal(intersection.point);
		double nv = alignZero(n.dotProduct(v));
		if (nv == 0) //לא רואים את הנקודה עליה האור משפיע מחזיר שחור
			return Color.BLACK;
		//רוצים לבדוק את ההשפעה של האור עלי לפי סוג החומר ממנו הגוף עשוי
		Material material = intersection.geometry.getMaterial();
		int nShininess = material.nShininess;
		double kd = material.KD;
		double ks = material.KS;
		Color color = Color.BLACK; //עוד לא יודעים השפעות
		for (LightSource lightSource : myscene.lights) //עוברים כעל כל מקור אור בסצנה ובודקים איך הוא משפיע על הצבע בנקודה המסויימת
		{
			Vector l = lightSource.getL(intersection.point);//וקטור ממקור אור עד לנקודה
			double nl = alignZero(n.dotProduct(l));//רוצים לדעת שאני באותו כיוון כי אם לא לא רואים את ההשפעות
			if (nl * nv > 0) 
			{ 
				double ktr = transparency(lightSource, l, n, intersection);
				if (ktr * k > MIN_CALC_COLOR_K) 
				{
				// sign(nl) == sing(nv)

					Color lightIntensity = lightSource.getIntensity(intersection.point).scale(ktr);;
					color = color.add(lightIntensity.scale((calcDiffusive(kd, nl)+calcSpecular(ks, l, n, nl, v, nShininess))));
				}
			}
		}
		return color;
	}

	/**
	 * help function that calculate the specolar effect
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param ks double value
	 * @param l Vector value
	 * @param n Vector value
	 * @param v Vector value
	 * @param nl double value
	 * @param nShininess int value
	 * @param lightIntensity Color value
	 * @throws IllegalArgumentException
	 * */
	private double calcSpecular(double ks, Vector l,Vector n, double nl, Vector v, int nShininess) throws IllegalArgumentException 
	{
		//𝒓 = 𝒍 − 𝟐 ∙( 𝒍 ∙ 𝒏) ∙n 
		Vector r = l.subtract(n.scale(alignZero(2*nl))).normalize();
		double RV = alignZero(r.dotProduct(v));
		double minusRV = RV*(-1);
		if (minusRV <= 0)
			return 0; //מקדם בשביל צבע שחור
		return alignZero(Math.pow(minusRV, nShininess))*ks;
	}

	/**
	 * help function that calculate the difusive effect
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param kd double value
	 * @param nl double value
	 * @param lightIntensity Color value
	 * @return double value for calcDiffusive
	 * */
	private double calcDiffusive(double kd, double nl) 
	{
		return alignZero(Math.abs(nl)*kd);
	}

	/**
	 * A function that check if there is shaded or not
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param light LightSource value
	 * @param l Vector value
	 * @param n Vector value
	 * @param geopoint GeoPoint value
	 * @return true or false
	 * */
	private boolean unshaded(Vector l, Vector n, GeoPoint geopoint , LightSource light)
	{
		Vector lightDirection = l.scale(-1); // from point to light source
//		Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : -DELTA);// where we need to move the point
//		Point3D point = geopoint.point.add(delta);// moving the point
		Ray lightRay = new Ray(geopoint.point, lightDirection, n); // refactored ray head move
		List<GeoPoint> intersections = myscene.geometries.findGeoIntersections(lightRay);
		if (intersections == null) 
			return true;
		double lightDistance = light.getDistance(geopoint.point);
		for (GeoPoint gp : intersections) 
		{
			if (alignZero(gp.point.distance(geopoint.point) - lightDistance) <= 0 && gp.geometry.getMaterial().KT == 0)
				return false;
		}
		return true;
	}
	
	
	/**
	 * A function that allows partial shading
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param light LightSource value
	 * @param l Vector value
	 * @param n Vector value
	 * @param geoPoint GeoPoint value
	 * */
	private double transparency(LightSource light, Vector l, Vector n, GeoPoint geoPoint)
	{
		Vector lightDirection = l.scale(-1); // from point to light source
		Ray lightRay = new Ray(geoPoint.point, lightDirection, n); // refactored ray head move

		double lightDistance = light.getDistance(geoPoint.point);
		var intersections = myscene.geometries.findGeoIntersections(lightRay);
		if (intersections == null) 
			return 1.0;
		double ktr = 1.0;
		for (GeoPoint gp : intersections) 
		{
			if (alignZero(gp.point.distance(geoPoint.point) - lightDistance) <= 0)
			{
				ktr *= gp.geometry.getMaterial().KT;
				if (ktr < MIN_CALC_COLOR_K) //החל מאיזו עוצמת צב זה נקרא שיש צל 
					return 0.0;
			}
		}

		return ktr;

	}
}
