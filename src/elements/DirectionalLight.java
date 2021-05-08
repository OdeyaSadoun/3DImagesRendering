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
public class DirectionalLight extends Light implements LightSource
{

	
	private Vector direction;
	/**
	 * @param intensity
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
		return direction.normalize();
	}

}
