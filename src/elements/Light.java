package elements;
import primitives.Color;


/**
 * class for light - abstract class
 * 
 * @author Tamar Gavrieli & Odeya Sadoun
 */
 abstract class Light 
 {

	protected Color intensity;
	
	
	/**
	 * constructor for light
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @return the intensity
	 */
	protected Light(Color intensity)
	{
		this.intensity=intensity;
	}
 
	/**
	 * getter to intensity
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @return intensity Color 
	 * */
	public Color getIntensity() 
	{
		return intensity;
	}

}
