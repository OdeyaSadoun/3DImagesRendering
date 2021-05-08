package geometries;
import primitives.Vector;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;

/**
 * abstract class Geometry for all the geometries that have normal
 * 
 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
 * */
public abstract class Geometry implements Intersectable
{
	/**
	 * A function that return the normal of the geometry
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @param point
	 * @return Vector value
	 * */
	protected  Color emission = Color.BLACK;
	public abstract Vector getNormal(Point3D point) throws IllegalArgumentException; // function get normal
	private Material material=new Material();
	
	
	/**
	 * @return the material
	 */


	
	/**
	 * getter function for the color filed in geometry class
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return emission Color value
	 * */
	public Color getEmission() 
	{
		return emission;
	}
	
	/**
	 * @return the material
	 */
	public Material getMaterial() 
	{
		return material;
	}

	/**
	 * @param material the material to set
	 */
	public Geometry setMaterial(Material material) 
	{
		this.material = material;
		return this;
	}

	/**
	 * setter function for the color filed and return this- geometry class
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @return the geometry-this
	 * */
	public Geometry setEmission(Color emission) 
	{
		this.emission = emission;
		return this;
	}

}
