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
	public void setBackground(Color background) 
	{
		this.background = background;
	}
	

	/**
	 * @param ambientLight the ambientLight to set
	 */
	public void setAmbientLight(AmbientLight ambientLight) 
	{
		this.ambientLight = ambientLight;
	}
	

	/**
	 * @param geometries the geometries to set
	 */
	public void setGeometries(Geometries geometries) 
	{
		this.geometries = geometries;
	}
	

}
