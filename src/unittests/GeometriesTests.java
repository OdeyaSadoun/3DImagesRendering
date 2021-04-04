/**
 * 
 */
package unittests;

import static org.junit.Assert.*;


import org.junit.Test;

import geometries.Cylinder;
import geometries.Geometries;
import geometries.Plane;
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
			Plane plane = new Plane (new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(4, 0, 2));
			//Tube tube = new Tube(1.5, new Ray(new Point3D(1, 2, 3),new Vector(new Point3D(5, -3, 0))));
			//Cylinder cylinder = new Cylinder(2, new Ray(new Point3D(1, 4, -2),new Vector(new Point3D(1, 0, 2))), 15);
			
			Geometries collection= new Geometries(triangle,sphere , plane/*,tube,cylinder*/);
			
			collection.add(null); // add 0 things
			
			assertEquals("the length of the list is worng", 3, collection.getIntsersectionPoints().size());
			Triangle t = new Triangle(new Point3D(1,8,-6),new Point3D(1,0,0),new Point3D(1,0,2));
			//collection.add(t);
			
			//assertEquals("the length of the list is worng", 4, collection.getIntsersectionPoints().size());
			
			
			
			
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			Plane plane = new Plane (new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(4, 0, 2));
			//Tube tube = new Tube(1, new Ray(new Point3D(0,-3, 0), new Vector(5.01,-7.74,6.21)));
			//Cylinder cylinder = new Cylinder(0.9, new Ray(new Point3D(0, 3, 0), new Vector(-4.11,-7.28,0)), 8.360053828);
			
			collection.add(sphere, triangle, plane/*, tube ,cylinder*/);
		
			assertNull("No cut shape must return 0",collection.findIntersections(new Ray(new Point3D(0, -8, 0), new Vector(-10,-1,0))));
			
			//=====Only one shape is cut (BVA)=====//
			sphere = new Sphere(new Point3D(1, 0, 0), 1); 
			triangle = new Triangle(new Point3D(-4,0,0), new Point3D(0, 0, 5), new Point3D(0, -5, 0));
			plane = new Plane (new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(4, 0, 2));//cut
			//tube = new Tube(1, new Ray(new Point3D(0,-3, 0), new Vector(5.01,-7.74,6.21)));
			//cylinder = new Cylinder(0.9, new Ray(new Point3D(0, 3, 0), new Vector(-4.11,-7.28,0)), 8.360053828);
			collection= new Geometries(sphere, triangle, plane/*, tube ,cylinder*/);
			assertEquals("wrong number of intersactions", 1, collection.findIntersections(new Ray(new Point3D(0, -2, 0), new Vector(-4,-1,0))).size());

			
			//=====All shapes are cut (BVA)=====//
			sphere = new Sphere(new Point3D(1, 0, 0), 2.5);//2
			triangle = new Triangle(new Point3D(4.19,0,0), new Point3D(-1.03, 0, 1.46), new Point3D(0, -3, 0));//1
			plane = new Plane (new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(4, 0, 2));//1
			//tube = new Tube(0.5, new Ray(new Point3D(1, 0, 0), new Vector(1,1,1)));//2
			//cylinder = new Cylinder(0.9, new Ray(new Point3D(-2.13, 4.34, 0), new Vector(1,1,1)), 7);//2
			
			collection= new Geometries(sphere, triangle, plane/*, tube ,cylinder*/);
			assertEquals("wrong number of intersactions", 4, collection.findIntersections(new Ray(new Point3D(-2, -3, 0), new Vector(2.13,2.2,0))).size());

			
			//=====Some (but not all) shapes are cut (EP)=====//
			sphere = new Sphere(new Point3D(1, 0, 0), 2.5);
			triangle = new Triangle(new Point3D(4,0,0), new Point3D(0, 0, 3), new Point3D(4, 4, 0));//cut
			plane = new Plane (new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(4, 0, 2));//cut

			//tube = new Tube(0.5, new Ray(new Point3D(1, 0, 0), new Vector(1,1,1)));// cut 2
			//cylinder = new Cylinder(1, new Ray(new Point3D(1, 0, 0), new Vector(1,1,1)), 7);
			
			collection= new Geometries(sphere, triangle,plane/*, tube ,cylinder*/);
			assertEquals("wrong number of intersactions", 2, collection.findIntersections(new Ray(new Point3D(-10, -3, 0), new Vector(8.21,2.68,2.44))).size());
		
			
			

		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("dont need throws exceptions!!!");
		}
	
	}

}
