
package geometries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import geometries.Intersectable.GeoPoint;
import primitives.Point3D;
import primitives.Ray;

/**
 * Class for the Collection of Bodies in the Scene
 * 
 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
 */
public class Geometries extends Borderable
{
	//field:
	private List<Borderable> geometriesInScene;

	/**
	 * A default constructor that create new empty arrayList
	 * 
	 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
	 */
	public Geometries()
	{
		//we chosen in ArrayList because this class works better when the application demands storing the data and accessing it.
		geometriesInScene = new ArrayList<Borderable>();
	}
	
	/**
	 * Constructor that recives list of geomeries and put them in new arrayList
	 * 
	 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
	 * @param geometries
	 * */
	public Geometries(Borderable... geometries)
	{
		geometriesInScene =  new ArrayList<Borderable>(Arrays.asList(geometries));
	}
	
	/**
	 * Iterator function
	 * 
	 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
	 * */
	public  Iterator<Borderable> iterator()
	{
		return geometriesInScene.iterator();
	}
	
	/**
	 * A function that add the geometries the receive to the list.
	 * 
	 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
	 * @param geometries 
	 * */
	public void add(Borderable... geometries)
	{
		if (geometries != null)
		{
			geometriesInScene.addAll(Arrays.asList(geometries));
		}
	}

	
	/**
	 * A getter function for geometriesInScene
	 * 
	 * @author Tamar Gavrieli 322533977 and Odeya Sadoun 212380406
	 * @return List<Intersectable> value for geometriesInScene
	 * */
	public List<Borderable> getIntsersectionPoints() 
	{
		return geometriesInScene;
	}
	
	/***********************************************************************************/

	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geometriesInScene == null) ? 0 : geometriesInScene.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Geometries other = (Geometries) obj;
		if (geometriesInScene == null) {
			if (other.geometriesInScene != null)
				return false;
		} else if (!geometriesInScene.equals(other.geometriesInScene))
			return false;
		return true;
	}

//	@Override
//	public List<GeoPoint> findGeoIntersections(Ray ray) throws IllegalArgumentException 
//	{
//
//		List<GeoPoint> temp = new ArrayList<GeoPoint>();
//		for (Intersectable intersectable : geometriesInScene) 
//		{
//			List<GeoPoint> intersection = intersectable.findGeoIntersections(ray);
//			if (intersection != null)
//				temp.addAll(intersection); 
//		}
//		
//		if (temp.isEmpty())
//			return null;
//		return temp;	
//
//	}

	@Override
	protected void findMinMaxParticular() 
	{

		minX = Double.POSITIVE_INFINITY;
		maxX = Double.NEGATIVE_INFINITY;
		minY = Double.POSITIVE_INFINITY;
		maxY = Double.NEGATIVE_INFINITY;
		minZ = Double.POSITIVE_INFINITY;
		maxZ = Double.NEGATIVE_INFINITY;
	
//		for (Intersectable intersectable : geometriesInScene) 
//		{
//			if (intersectable < maxX)
//				maxX = intersectable;
//			if (intersectable > minX)
//				minX = intersectable;
//			if (intersectable < maxY)
//				maxY = intersectable;
//			if (intersectable > minY)
//				minY = intersectable;
//			if (intersectable < maxZ)
//				maxZ = intersectable;
//			if (intersectable > minZ)
//				minZ = intersectable;
//			
//
//		}
		/**
	     * find the minimum and the maximum of the geometry border
	     */

	        for (Borderable g : geometriesInScene) {
	            g.findMinMax();

	            //calc min
	            if (g.minX < minX)
	                minX = g.minX;
	            if (g.minY < minY)
	                minY = g.minY;
	            if (g.minZ < minZ)
	                minZ = g.minZ;

	            //calc max
	            if (g.maxX > maxX)
	                maxX = g.maxX;
	            if (g.maxY > maxY)
	                maxY = g.maxY;
	            if (g.maxZ > maxZ)
	                maxZ = g.maxZ;
	        }

	    }
		
	

	@Override
	public List<GeoPoint> findGeoIntersectionsParticular(Ray ray)
	{
		List<GeoPoint> temp = new ArrayList<GeoPoint>();
		for (Intersectable intersectable : geometriesInScene) 
		{
			List<GeoPoint> intersection = intersectable.findGeoIntersections(ray);
			if (intersection != null)
				temp.addAll(intersection); 
		}
		
		if (temp.isEmpty())
			return null;
		return temp;	
	}

}
