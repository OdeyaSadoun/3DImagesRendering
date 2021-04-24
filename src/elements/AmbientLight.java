/**
 * 
 */
package elements;

import primitives.Color;

/**
 * class to AmbientLight - the basic light in the scene
 * 
 * @author Tamar Gavrieli & Odeya Sadoun
 */
public class AmbientLight
{

	private Color Ia;
	private double Ka;
	private Color intensity;
	
	/**
	 * constructor
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param Ia Color value
	 * @param Ka double value
	 */
	public AmbientLight(Color Ia,double Ka ) 
	{
		this.intensity = Ia.scale(Ka);
	}

	/**
	 * getter function for the intensity filed
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @return the intensity
	 */
	public Color getIntensity() 
	{
		return intensity;
	}



}
