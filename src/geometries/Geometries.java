
package geometries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import primitives.Point3D;
import primitives.Ray;

/**
 * @author אודיה סעדון
 *
 */
public class Geometries implements Intersectable 
{
	private List<Intersectable> geometriesInScene;

	/**
	 * 
	 */
	public Geometries()
	{
		//we chosen in ArrayList because this class works better when the application demands storing the data and accessing it.
		geometriesInScene = new ArrayList<Intersectable>();
	}
	
	public Geometries(Intersectable... geometries)
	{
		geometriesInScene =  new ArrayList<Intersectable>(Arrays.asList(geometries));
//		intsersectionPoints = new ArrayList<Intersectable>();
//		for (int i = 0; i < geometries.length; i++) {
//			intsersectionPoints.add(geometries[i]);
//		}
	}
	public  Iterator<Intersectable> iterator()
	{
		return geometriesInScene.iterator();
	}
	
	public void add(Intersectable... geometries)
	{
		if (geometries != null)
		{
			geometriesInScene.addAll(Arrays.asList(geometries));

		}
	
	}
	
	/**
	 * @throws Exception *****************************************************/

	@Override
	public List<Point3D> findIntersections(Ray ray) throws Exception 
	{
		List<Point3D> temp = new ArrayList<Point3D>();
		for (Intersectable intersectable : geometriesInScene) 
		{
			List<Point3D> intersection = intersectable.findIntersections(ray);
			if (intersection != null)
				temp.addAll(intersection); 
		}
		
		if (temp.isEmpty())
			return null;
		return temp;
		
		
		
	}
	
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

	public List<Intersectable> getIntsersectionPoints() 
	{
		return geometriesInScene;
	}

	
	

}
