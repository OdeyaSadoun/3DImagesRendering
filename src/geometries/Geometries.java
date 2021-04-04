
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
		//intsersectionPoints.addAll(List.of(geometries));
		for (Intersectable intersectable : geometries) 
		{
			intsersectionPoints.add(intersectable);
		}
//		for(int i = 0; i< geometries.length; i++) 
//		{
//			intsersectionPoints.add(geometries[i]);
//		}	
	}
	
	/**
	 * @throws Exception *****************************************************/

	@Override
	public List<Point3D> findIntersections(Ray ray) throws Exception 
	{
		List<Point3D> temp = new ArrayList<Point3D>();
		for (Intersectable intersectable : intsersectionPoints) 
		{
			temp.addAll(intersectable.findIntersections(ray)); 
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
		result = prime * result + ((intsersectionPoints == null) ? 0 : intsersectionPoints.hashCode());
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
		if (intsersectionPoints == null) {
			if (other.intsersectionPoints != null)
				return false;
		} else if (!intsersectionPoints.equals(other.intsersectionPoints))
			return false;
		return true;
	}

	public List<Intersectable> getIntsersectionPoints() 
	{
		return intsersectionPoints;
	}

	
	

}
