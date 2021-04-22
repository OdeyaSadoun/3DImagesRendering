
package renderer;

import java.util.MissingResourceException;

import elements.Camera;
import primitives.Color;
import primitives.Ray;
import scene.Scene;




/**
 * class for render the image
 * 
 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
 *
 */
public class Render 
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
	 * @throws Exception 
	 * */
	public void renderImage() throws Exception
	{
		if (scene == null)
			throw new MissingResourceException("this function must have values in all the fileds", "Scene", "scene");
		if (camera == null)
			throw new MissingResourceException("this function must have values in all the fileds", "Camera", "camera");
		if (imageWriter == null)
			throw new MissingResourceException("this function must have values in all the fileds", "ImageWriter", "imageWriter");
		if (rayTracer == null)
			throw new MissingResourceException("this function must have values in all the fileds", "RayTracerBase", "rayTracer");
		
		for (int i = 0; i < camera.getWidth(); i++)
		{
			for (int j = 0; j < camera.getHeight(); j++)	
			{
				Ray ray = camera.constructRayThroughPixel((int)camera.getWidth(), (int)camera.getHeight(), j, i);
				Color rayColor = rayTracer.traceRay(ray);
				imageWriter.writePixel(i, j, rayColor); 
			}
		}
		
	

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

	

	public Render setScene(Scene scene) 
	{
		this.scene = scene;
		return this;
	}

	
	public Render setCamera(Camera camera)
	{
		this.camera = camera;
		return this;
	}



	public Render setImageWriter(ImageWriter imageWriter) 
	{
		this.imageWriter = imageWriter;
		return this;
	}



	public Render setRayTracer(RayTracerBase rayTracer)
	{
		this.rayTracer = rayTracer;
		return this;
	}
	
	
	
}
