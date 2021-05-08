
package scene;

import java.util.LinkedList;
import java.util.List;

import elements.AmbientLight;
import elements.LightSource;
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
	public Color background = Color.BLACK;
	public AmbientLight ambientLight = new AmbientLight();
	public Geometries geometries;
	public List<LightSource>lights=new LinkedList<LightSource>() ;
	/**
	 * @param lights the lights to set
	 */
	public Scene setLights(List<LightSource> lights) 
	{
		this.lights = lights;
		return this;
	}



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
