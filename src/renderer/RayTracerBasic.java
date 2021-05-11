
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
	
	private static final double DELTA = 0.1;

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
			List<GeoPoint> intersections = myscene.geometries.findGeoIntersections(ray);
			if(intersections == null)
				return  myscene.background;
			GeoPoint closestPoint = ray.getClosestGeoPoint(intersections);
			return calcColor(closestPoint, ray);
	}
	
	/**
	 * Function for calculating a point color	
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param point Point3D value
	 * @return Color
	 * @throws IllegalArgumentException 
	 * */
	private Color calcColor(GeoPoint intersection, Ray ray) throws IllegalArgumentException 
	{
		/*נ�‘°נ�‘· = נ�’�נ�‘¨ גˆ™ נ�‘°נ�‘¨ + נ�‘°נ�‘¬ + (נ�’�נ�‘« גˆ™ |נ�’� גˆ™ נ�’�| + נ�’�נ�‘÷ גˆ™ (גˆ’נ�’— גˆ™ נ�’“)^ נ�’�נ�’”נ�’‰)) גˆ™ נ�‘°L*/
		Color KaIa = myscene.ambientLight.getIntensity();
		Color Ie = intersection.geometry.getEmission(); 

		return KaIa.add(Ie).add(calcLocalEffects(intersection, ray));
	}
	
	/**
	 * help function that calculate the local color
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param intersection GeoPoint value
	 * @param ray Ray value
	 * */
	private Color calcLocalEffects(GeoPoint intersection, Ray ray) 
	{
		Vector v = ray.getDir().normalize();
		Vector n = intersection.geometry.getNormal(intersection.point);
		double nv = alignZero(n.dotProduct(v));
		if (nv == 0) //׳�׳� ׳¨׳•׳�׳™׳� ׳�׳× ׳”׳ ׳§׳•׳“׳” ׳¢׳�׳™׳” ׳”׳�׳•׳¨ ׳�׳©׳₪׳™׳¢ ׳�׳—׳–׳™׳¨ ׳©׳—׳•׳¨
			return Color.BLACK;
		//׳¨׳•׳¦׳™׳� ׳�׳‘׳“׳•׳§ ׳�׳× ׳”׳”׳©׳₪׳¢׳” ׳©׳� ׳”׳�׳•׳¨ ׳¢׳�׳™ ׳�׳₪׳™ ׳¡׳•׳’ ׳”׳—׳•׳�׳¨ ׳�׳�׳ ׳• ׳”׳’׳•׳£ ׳¢׳©׳•׳™
		Material material = intersection.geometry.getMaterial();
		int nShininess = material.nShininess;
		double kd = material.KD;
		double ks = material.KS;
		Color color = Color.BLACK; //׳¢׳•׳“ ׳�׳� ׳™׳•׳“׳¢׳™׳� ׳”׳©׳₪׳¢׳•׳×
		for (LightSource lightSource : myscene.lights) //׳¢׳•׳‘׳¨׳™׳� ׳›׳¢׳� ׳›׳� ׳�׳§׳•׳¨ ׳�׳•׳¨ ׳‘׳¡׳¦׳ ׳” ׳•׳‘׳•׳“׳§׳™׳� ׳�׳™׳� ׳”׳•׳� ׳�׳©׳₪׳™׳¢ ׳¢׳� ׳”׳¦׳‘׳¢ ׳‘׳ ׳§׳•׳“׳” ׳”׳�׳¡׳•׳™׳™׳�׳×
		{
			Vector l = lightSource.getL(intersection.point);//׳•׳§׳˜׳•׳¨ ׳�׳�׳§׳•׳¨ ׳�׳•׳¨ ׳¢׳“ ׳�׳ ׳§׳•׳“׳”
			double nl = alignZero(n.dotProduct(l));//׳¨׳•׳¦׳™׳� ׳�׳“׳¢׳× ׳©׳�׳ ׳™ ׳‘׳�׳•׳×׳• ׳›׳™׳•׳•׳� ׳›׳™ ׳�׳� ׳�׳� ׳�׳� ׳¨׳•׳�׳™׳� ׳�׳× ׳”׳”׳©׳₪׳¢׳•׳×
			if (nl * nv > 0) 
			{ 
				// sign(nl) == sing(nv)
				Color lightIntensity = lightSource.getIntensity(intersection.point);
				color = color.add(lightIntensity.scale((calcDiffusive(kd, l, n)+calcSpecular(ks, l, n, v, nShininess))));
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
	 * @param nShininess int value
	 * @param lightIntensity Color value
	 * @throws IllegalArgumentException
	 * */
	private double calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess) throws IllegalArgumentException 
	{
		//נ�’“ = נ�’� גˆ’ נ��� גˆ™( נ�’� גˆ™ נ�’�) גˆ™n 
		Vector r = l.subtract(n.scale(alignZero(2*(l.dotProduct(n))))).normalize();
		double RV = alignZero(r.dotProduct(v));
		double minusRV = RV*(-1);
		if (minusRV <= 0)
			return 0; //׳�׳§׳“׳� ׳‘׳©׳‘׳™׳� ׳¦׳‘׳¢ ׳©׳—׳•׳¨
		return alignZero(Math.pow(minusRV, nShininess))*ks;
	}

	/**
	 * help function that calculate the difusive effect
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param kd double value
	 * @param l Vector value
	 * @param n Vector value
	 * @param lightIntensity Color value
	 * */
	private double calcDiffusive(double kd, Vector l, Vector n) 
	{
		double ln = alignZero(l.dotProduct(n));
		return alignZero(Math.abs(ln)*kd);
	}
	
	
	private boolean unshaded(Vector l, Vector n, GeoPoint gp)
	{
		Vector lightDirection = l.scale(-1); // from point to light source
		Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : - DELTA);
		Point3D point = gp.point.add(delta);
		Ray lightRay = new Ray(point, lightDirection);
		List<GeoPoint> intersections = myscene.geometries.findGeoIntersections(lightRay);
		return intersections == null;
		
	}

}
