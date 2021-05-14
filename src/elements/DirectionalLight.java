package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * class DirectionalLight that extends from class light
 * and implement the interface LightSource
 * @author Tamar Gavrieli & Odeya Sadoun
 */
public class DirectionalLight extends Light implements LightSource
{

	private Vector direction;
	
	
	/**
	 * Constructor for DirectionalLight
	 * this c-tor is normalize the direction vector
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param intensity Color value
	 * @param direction Vector value
	 */
	public DirectionalLight(Color intensity, Vector direction) 
	{
		super(intensity);
		this.direction=direction.normalize();
	}

	/**************************************************************************************/
	@Override
	public Color getIntensity(Point3D p)
	{
		return super.getIntensity();
	}
	
	@Override
	public Vector getL(Point3D p)
	{
		return direction;
	}

	@Override
	public double getDistance(Point3D point) 
	{
		return Double.POSITIVE_INFINITY;
	}

}
