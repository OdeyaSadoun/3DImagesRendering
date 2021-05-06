
package renderer;

import java.util.MissingResourceException;

import elements.Camera;
import primitives.Color;
import primitives.Ray;
import scene.Scene;


/**
 * class for render the image in package renderer
 * 
 * @author Tamar Gavrieli 322533977 & Odeya Sadoun 212380406
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
		
		for (int i = 0; i < imageWriter.getNx(); i++)
		{
			for (int j = 0; j < imageWriter.getNy(); j++)	
			{
				Ray ray = camera.constructRayThroughPixel(imageWriter.getNx(), imageWriter.getNy(), j, i);
				Color rayColor = rayTracer.traceRay(ray);
				imageWriter.writePixel(j, i, rayColor); 
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
		

		for (int i = 0; i < imageWriter.getNx(); i++)
		{
			for (int j = 0; j < imageWriter.getNy(); j++)	
			{
				if(i % interval == 0 || j % interval == 0)
					imageWriter.writePixel(i, j, color); 
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

	

	/**
	 * A seter function for parameter scene
	 * this function return the object - this for builder pattern
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param scene Scene value
	 * */
	public Render setScene(Scene scene) 
	{
		this.scene = scene;
		return this;
	}

	/**
	 * A seter function for parameter camera
	 * this function return the object - this for builder pattern
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param camera Camera value
	 * */
	public Render setCamera(Camera camera)
	{
		this.camera = camera;
		return this;
	}


	/**
	 * A seter function for parameter imageWriter
	 * this function return the object - this for builder pattern
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param imageWriter ImageWriter value
	 * */
	public Render setImageWriter(ImageWriter imageWriter) 
	{
		this.imageWriter = imageWriter;
		return this;
	}


	/**
	 * A seter function for parameter rayTracer
	 * this function return the object - this for builder pattern
	 * 
	 * @author Tamar Gavrieli & Odeya Sadoun
	 * @param rayTracer RayTracerBase value
	 * */
	public Render setRayTracer(RayTracerBase rayTracer)
	{
		this.rayTracer = rayTracer;
		return this;
	}
	
	
	
}
