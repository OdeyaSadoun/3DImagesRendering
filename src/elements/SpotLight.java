
package elements;

import static primitives.Util.alignZero;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * class SpotLight that extends from class PointLight
 * 
 * @author Tamar Gavrieli & Odeya Sadoun
 */
public class SpotLight extends PointLight 
{
	private Vector direction;

//	/**
//	 * constructor for spotlight that receives all the params
//	 * 
//	 * @author Tamar Gavrieli & Odeya Sadoun
//	 * @param direction Vector value 
//	 * @param intensity Color value
//	 * @param position Point3D value
//	 * @param KC double value
//	 * @param KL double value
//	 * @param KQ double value
//	 */
//	public SpotLight(Color intensity, Point3D position, double KC, double KL, double KQ, Vector direction) 
//	{
//		super(intensity, position, KC, KL, KQ);
//		this.direction=direction.normalize();
//	}

	/**
	 * constructor for spotlight that receives 3 params
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param direction Vector value 
	 * @param intensity Color value
	 * @param position Point3D value
	 */
	public SpotLight(Color intensity, Point3D position, Vector direction)  
	{
		super(intensity, position);
		this.direction=direction.normalize();
	}
	
	
	/*******************************************************************************/
	@Override
	public Color getIntensity(Point3D p) throws IllegalArgumentException
	{
		double pl = alignZero(direction.dotProduct(getL(p)));
		if(getL(p) == null)
			return Color.BLACK;
		if (pl <= 0)
			return Color.BLACK;
		return super.getIntensity(p).scale(pl);
	}
}
