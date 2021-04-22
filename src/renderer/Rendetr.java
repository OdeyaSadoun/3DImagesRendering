
package renderer;

import java.util.MissingResourceException;

import elements.Camera;
import primitives.Color;
import scene.Scene;




/**
 * class for render the image
 * 
 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
 *
 */
public class Rendetr 
{
	private Scene scene;
	private Camera camera;
	private ImageWriter imageWriter;
	private RayTracerBase rayTracer;

	/**
	 * The function transfers beams from camera to pixel, tracks the beam
	 *  and receives the pixel color from the point of intersection
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * */
	public void renderImage()
	{
		if (scene == null)
			throw new MissingResourceException("this function must have values in all the fileds", "Scene", "scene");
		if (camera == null)
			throw new MissingResourceException("this function must have values in all the fileds", "Camera", "camera");
		if (imageWriter == null)
			throw new MissingResourceException("this function must have values in all the fileds", "ImageWriter", "imageWriter");
		if (rayTracer == null)
			throw new MissingResourceException("this function must have values in all the fileds", "RayTracerBase", "rayTracer");
		
	

	}

	
	/**
	 * A function that creates a grid of lines
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * @param interval int value
	 * @param color Color value
	 * */
	public void printGrid(int interval, Color color)
	{
		if (imageWriter == null)
			throw new MissingResourceException("this function must have values in all the fileds", "ImageWriter", "imageWriter");
		

		for (int i = 0; i < camera.getWidth(); i++)
		{
			for (int j = 0; j < camera.getHeight(); j++)	
			{
				if(i % imageWriter.getNx() == 0 || j % imageWriter.getNy() == 0)
					imageWriter.writePixel(i, j, new Color(189,56,126)); 

			}
		}

	}
	
	
	/**
	 * A function that finally creates the image.
	 * This function delegates the function of a class imageWriter
	 * 
	 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
	 * */
	public void writeToImage()
	{
		if (imageWriter == null)
			throw new MissingResourceException("this function must have values in all the fileds", "ImageWriter", "imageWriter");
		
		imageWriter.writeToImage();
	}
}
