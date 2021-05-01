/**
 * 
 */
package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * @author Home
 *
 */
public class PointLight extends Light implements LightSource
{

	private Point3D position;
	private double KC;
	private double KL;
	private double KQ;
	/**
	 * @param intensity
	 */
	public PointLight(Color intensity, Point3D position, double KC, double KL, double KQ) 
	{
		super(intensity);
		// TODO Auto-generated constructor stub
		this.position=position;
		this.KC=KC;
		this.KL=KL;
		this.KQ=KQ;
		
	}

	/**
	 * 
	 */
	public PointLight() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public Color getIntensity(Point3D p)
	{
		return super.getIntensity();
		
	}
	
	public Vector getL(Point3D p)
	{
		return null;
		
	}

}
