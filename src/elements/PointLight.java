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
	private double KC = 1;
	private double KL = 0;
	private double KQ = 0;
	/**
	 * @param intensity
	 */
	public PointLight(Color intensity, Point3D position, double KC, double KL, double KQ) 
	{
		super(intensity);
		this.position=position;
		this.KC=KC;
		this.KL=KL;
		this.KQ=KQ;
		
	}

	@Override
	public Color getIntensity(Point3D p) throws Exception
	{
		return super.getIntensity();
		
	}
	@Override
	public Vector getL(Point3D p) throws Exception 
	{	
		return position.subtract(p);		
	}

}
