/**
 * 
 */
package scene;

import elements.AmbientLight;
import geometries.Geometries;
import primitives.Color;

/**
 * @author Home
 *
 */
public class Scene 
{
	public String name;
	public Color background;
	public AmbientLight ambientLight;
	public Geometries geometries;
	
	public Scene(String name)
	{
		geometries = new Geometries();
	}
	

	
	/**
	 * @param background the background to set
	 */
	public Scene setBackground(Color background) 
	{
		this.background = background;
		return this;
	}
	

	/**
	 * @param ambientLight the ambientLight to set
	 */
	public Scene setAmbientLight(AmbientLight ambientLight) 
	{
		this.ambientLight = ambientLight;
		return this;
		
	}
	

	/**
	 * @param geometries the geometries to set
	 */
	public Scene setGeometries(Geometries geometries) 
	{
		this.geometries = geometries;
		return this;
	}
	

}
