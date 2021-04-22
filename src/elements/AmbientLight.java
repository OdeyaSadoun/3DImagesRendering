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
	
	public Color Ia;
	public double Ka;
	public Color intensity;
	
	public AmbientLight(Color Ia,double Ka ) 
	{
		this.intensity = Ia.scale(Ka);
	}


	public void setIntensity(Color intensity) 
	{
		this.intensity = intensity;
	}

}
