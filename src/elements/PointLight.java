
package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * class PointLight that extends from class light
 * and implement the interface LightSource
 * 
 * @author Tamar Gavrieli & Odeya Sadoun
 */
public class PointLight extends Light implements LightSource
{

	private Point3D position;
	private double KC = 1;
	private double KL = 0;
	private double KQ = 0;
	
	
	
	/**
	 * constructor of PointLight that receives all the params
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param intensity Color value
	 * @param position Point3D value
	 * @param KC double value
	 * @param KL double value
	 * @param KQ double value
	 */
	public PointLight(Color intensity, Point3D position, double KC, double KL, double KQ) 
	{
		super(intensity);
		this.position=position;
		this.KC=KC;
		this.KL=KL;
		this.KQ=KQ;
	}
	
	/**
	 * constructor of PointLight that receives two params
	 * kc,kl,kq are with default value
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param intensity Color value
	 * @param position Point3D value
	 */
	public PointLight(Color intensity, Point3D position)
	{
		super(intensity);
		this.position = position;
	}
	
	
	
	/**
	 * @param position the position to set
	 */
	public PointLight setPosition(Point3D position) 
	{
		this.position = position;
		return this;
	}


	/**
	 * @param kC the kC to set
	 */
	public PointLight setKC(double kC) 
	{
		KC = kC;
		return this;
	}

	/**
	 * @param kL the kL to set
	 */
	public PointLight setKL(double kL) 
	{
		KL = kL;
		return this;
	}


	/**
	 * @param kQ the kQ to set
	 */
	public PointLight setKQ(double kQ) 
	{
		KQ = kQ;
		return this;
	}

	/**************************************************************************************/
	@Override
	public Color getIntensity(Point3D p) throws IllegalArgumentException
	{
		return getIntensity().reduce((KC + KL * p.distance(position)+ KQ * p.distanceSquared(position)));	
	}
	
	@Override
	public Vector getL(Point3D p) throws IllegalArgumentException 
	{	
		if (p.equals(position))
			return null; //In order not to reach a state of exception due to the zero vector
		return p.subtract(position).normalize();		
	}
	
	

}
