
package scene;

import elements.AmbientLight;
import geometries.Geometries;
import primitives.Color;

/**
 * class Scene for PDS
 * 
 * @author Tamar Gavrieli & Odeya Sadoun
 */
public class Scene 
{
	public String name;
	public Color background;
	public AmbientLight ambientLight;
	public Geometries geometries;
	
	/**
	 * constructor 
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * */
	public Scene(String name)
	{
		geometries = new Geometries();
	}
	

	
	/**
	 * setter, and return this for builder pattern
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param background the background to set
	 */
	public Scene setBackground(Color background) 
	{
		this.background = background;
		return this;
	}
	

	/**
	 * setter, and return this for builder pattern
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param ambientLight the ambientLight to set
	 */
	public Scene setAmbientLight(AmbientLight ambientLight) 
	{
		this.ambientLight = ambientLight;
		return this;
		
	}
	

	/**
	 * setter, and return this for builder pattern
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param geometries the geometries to set
	 */
	public Scene setGeometries(Geometries geometries) 
	{
		this.geometries = geometries;
		return this;
	}
	

}
