
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
	private List<Intersectable> intsersectionPoints;

	/**
	 * 
	 */
	public Geometries()
	{
		//we chosen in ArrayList because this class works better when the application demands storing the data and accessing it.
		intsersectionPoints = new ArrayList<Intersectable>();
	}
	
	public Geometries(Intersectable... geometries)
	{
		intsersectionPoints = Arrays.asList(geometries);
//		intsersectionPoints = new ArrayList<Intersectable>();
//		for (int i = 0; i < geometries.length; i++) {
//			intsersectionPoints.add(geometries[i]);
//		}
	}
	public  Iterator<Intersectable> iterator()
	{
		return intsersectionPoints.iterator();
	}
	
	public void add(Intersectable... geometries)
	{
		for(int i = 0; i< geometries.length; i++) 
		{
			intsersectionPoints.add(geometries[i]);
		}	
	}
	
	/*******************************************************/

	@Override
	public List<Point3D> findIntersections(Ray ray) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
