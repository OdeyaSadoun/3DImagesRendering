/**
 * 
 */
package elements;

import primitives.Color;

/**
 * @author Tamar Gavrieli & Odeya Sadoun
 * 
 *
 */
public class AmbientLight
{

	/**
	 * 
	 */
	
	private Color Ia;
	private double Ka;
	private Color intensity;
	
	/**
	 * @param Ia Color value
	 * @param Ka double value
	 */
	public AmbientLight(Color Ia,double Ka ) 
	{
		this.intensity = Ia.scale(Ka);
	}

	/**
	 * @return the intensity
	 */
	public Color getIntensity() 
	{
		return intensity;
	}



}
