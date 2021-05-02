package elements;
import primitives.Color;

/**
 * class to AmbientLight - the basic light in the scene
 * An ambient light source represents a fixed-intensity
 * and fixedcolor light source that affects all objects in the scene equally.
 * 
 * @author Tamar Gavrieli & Odeya Sadoun
 */
public class AmbientLight extends Light
{
	private Color Ia; //the color
	private double Ka; //מקדם ההנחתה

	
	/**
	 * constructor that save the intensity=Ia*Ka
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param Ia Color value
	 * @param Ka double value
	 */
	public AmbientLight(Color Ia,double Ka ) 
	{
		super(Ia.scale(Ka));
		
	}

	/**
	 * getter function for the intensity filed
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @return the intensity
	 */




}
