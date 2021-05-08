/**
 * 
 */
package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * @author Home
 *
 */
public interface LightSource 
{
	public Color getIntensity(Point3D p) throws IllegalArgumentException;
	
	public Vector getL(Point3D p) throws IllegalArgumentException;
}
