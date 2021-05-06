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
public class SpotLight extends PointLight 
{

	/**
	 * @param intensity
	 * @param position
	 * @param KC
	 * @param KL
	 * @param KQ
	 */
	private Vector direction;
	
	public SpotLight(Color intensity, Point3D position, double KC, double KL, double KQ, Vector direction) 
	{
		super(intensity, position, KC, KL, KQ);
		this.direction=direction;
	}



}
