/**
 * 
 */
package unittests;

import static org.junit.Assert.*;


import org.junit.Test;

import geometries.Cylinder;
import geometries.Geometries;
import geometries.Sphere;
import geometries.Triangle;
import geometries.Tube;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import static primitives.Util.*;



/**
 * Unit tests for geometries.Geometries class
 * 
 * @author אודיה סעדון
 *
 */
public class GeometriesTests 
{

	/**
	 * Test method for {@link geometries.Geometries#add(geometries.Intersectable[])}.
	 */
	@Test
	public void testAdd() 
	{
		try 
		{
			Triangle triangle = new Triangle(new Point3D(1,0,0),new Point3D(1,1,0),new Point3D(1,0,1));
			Sphere sphere = new Sphere(new Point3D(1, 0, 0), 1);
			Tube tube = new Tube(1.5, new Ray(new Point3D(1, 2, 3),new Vector(new Point3D(5, -3, 0))));
			Cylinder cylinder = new Cylinder(2, new Ray(new Point3D(1, 4, -2),new Vector(new Point3D(1, 0, 2))), 15);
			
			Geometries collection= new Geometries(triangle,sphere,tube,cylinder);
			
			collection.add(new Triangle(new Point3D(1,8,-6),new Point3D(1,0,0),new Point3D(1,0,2)));
			
			assertEquals("the length of the list is worng", 5, collection.getIntsersectionPoints().toArray().length);
			
			collection.add(null); // add 0 things
			
			assertEquals("the length of the list is worng", 5, collection.getIntsersectionPoints().toArray().length);
			
			
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("dont need throws exceptions!!!");
		}
		
	}

	/**
	 * Test method for {@link geometries.Geometries#findIntsersections(primitives.Ray)}.
	 */
	@Test
	public void testFindIntsersections() 
	{
		
		try 
		{
			//=====Empty body collection (BVA)=====//
			Geometries collection= new Geometries();
			assertEquals("An empty body collection must return null", new Geometries(), collection);
			
			//=====No cut shape (BVA)=====//
			Sphere sphere = new Sphere(new Point3D(1, 0, 0), 1); 
			Triangle triangle = new Triangle(new Point3D(-4,0,0), new Point3D(0, 0, 5), new Point3D(0, -5, 0));
			Tube tube = new Tube(1, new Ray(new Point3D(0,-3, 0), new Vector(5.01,-7.74,6.21)));
			Cylinder cylinder = new Cylinder(0.9, new Ray(new Point3D(0, 3, 0), new Vector(-4.11,-7.28,0)), 8.360053828);
			
			collection.add(sphere, triangle, tube ,cylinder);
		
			assertEquals("No cut shape must return 0", 0,collection.findIntersections(new Ray(new Point3D(10.45, 1.89, 0), new Vector(-20.24,-0.2,0))).toArray().length);
			
			//=====Only one shape is cut (BVA)=====//
			sphere = new Sphere(new Point3D(1, 0, 0), 1); //cut - 2 intersections
			triangle = new Triangle(new Point3D(-4,0,0), new Point3D(0, 0, 5), new Point3D(0, -5, 0));
			tube = new Tube(1, new Ray(new Point3D(0,-3, 0), new Vector(5.01,-7.74,6.21)));
			cylinder = new Cylinder(0.9, new Ray(new Point3D(0, 3, 0), new Vector(-4.11,-7.28,0)), 8.360053828);
			collection= new Geometries(sphere, triangle, tube ,cylinder);
			assertEquals("wrong number of intersactions", 2, collection.findIntersections(new Ray(new Point3D(-8.26, 7.66, 1), new Vector(10.85,-8.79,-1))).toArray().length);

			
			//=====All shapes are cut (BVA)=====//
			sphere = new Sphere(new Point3D(1, 0, 0), 2.5);//2
			triangle = new Triangle(new Point3D(4.19,0,0), new Point3D(-1.03, 0, 1.46), new Point3D(0, -3, 0));//1
			tube = new Tube(0.5, new Ray(new Point3D(1, 0, 0), new Vector(1,1,1)));//2
			cylinder = new Cylinder(0.9, new Ray(new Point3D(-2.13, 4.34, 0), new Vector(1,1,1)), 7);//2
			
			collection= new Geometries(sphere, triangle, tube ,cylinder);
			assertEquals("wrong number of intersactions", 7, collection.findIntersections(new Ray(new Point3D(-4, 6, 0), new Vector(2.13,-7.34,0))).toArray().length);

			
			//=====Some (but not all) shapes are cut (EP)=====//
			sphere = new Sphere(new Point3D(1, 0, 0), 2.5);//cut 2
			triangle = new Triangle(new Point3D(4,0,0), new Point3D(0, 0, 3), new Point3D(4, 4, 0));
			tube = new Tube(0.5, new Ray(new Point3D(1, 0, 0), new Vector(1,1,1)));// cut 2
			cylinder = new Cylinder(1, new Ray(new Point3D(1, 0, 0), new Vector(1,1,1)), 7);
			
			collection= new Geometries(sphere, triangle, tube ,cylinder);
			assertEquals("wrong number of intersactions", 4, collection.findIntersections(new Ray(new Point3D(1.87, 8.49, 0), new Vector(-1.54,-16.82,0))).toArray().length);
		
			
			

		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			fail("dont need throws exceptions!!!");
			//e.printStackTrace();
		}
	
	}

}
