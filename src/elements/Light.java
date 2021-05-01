/**
 * 
 */
package elements;

import primitives.Color;

/**
 * @author Home
 *
 */
 abstract class Light 
 {

	/**
	 * 
	 */
	 
	private Color intensity;
	/**
	 * @return the intensity
	 * 
	 */
	
	protected Light(Color intensity)
	{
		this.intensity=intensity;
	}
 
	public Color getIntensity() 
	{
		return intensity;
	}
	public Light() 
	{
		// TODO Auto-generated constructor stub
	}

}
