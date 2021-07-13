package unittests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.DirectionalLight;
import elements.PointLight;
import elements.SpotLight;
import geometries.Geometries;
import geometries.Geometry;
import geometries.Plane;
import geometries.Polygon;
import geometries.Sphere;
import geometries.Triangle;
import kMeans.Cluster;
import kMeans.KMeans;
import kMeans.Point;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.RayTracerBasic;
import renderer.Render;
import scene.Scene;

public class geometriesWithAllEffects 
{
	private Scene scene = new Scene("Test scene");


	@Test
	public void manyGeometries() 
	{
		Camera camera = new Camera(new Point3D(0, 0, 10000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(2500, 2500).setDistance(10000); //

		scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));
		scene.setBackground(new Color(141,182,243));
		scene.geometries.add( 
				
//				new Sphere(new Point3D(900, 850, 950), 750) //
//						.setEmission(new Color(java.awt.Color.yellow )) //
//						.setMaterial(new Material().setKD(0.25).setKS(0.95).setnShininess(20)).setMaterial(new Material().setnShininess(500).setKR(0.18)),
//						
				new Triangle(new Point3D(-930, -1500, -1000), new Point3D(-1250, -804, -1000),new Point3D(-1500, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(-500, -1500, -1050), new Point3D(-750, -780, -1000),new Point3D(-1000, -1500, -2000)).setEmission(new Color(20, 190, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(0, -1500, -1000), new Point3D(-250, -800, -1000),new Point3D(-500, -1500, -2000)).setEmission(new Color(20, 185, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(500, -1500, -1000), new Point3D(250, -880, -1000),new Point3D(0, -1500, -2000)).setEmission(new Color(20, 195, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(1000, -1500, -1008), new Point3D(750, -842, -1000),new Point3D(500, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
			//	new Polygon(new Point3D(-1500, -1000, -2000),new Point3D(-1500, -1500, -1000),new Point3D(-1000, -1500, -1000),new Point3D(-1000, -1000, -2000)) ,
				new Triangle(new Point3D(1400, -1500, -1095), new Point3D(1250, -839, -1000),new Point3D(1050, -1500, -2000)).setEmission(new Color(20, 180, 20)).setMaterial(new Material().setKR(0.36)),
				
				
				new Triangle(new Point3D(-750, -1500, -1000), new Point3D(-1000, -960, -1000),new Point3D(-1250, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(-250, -1500, -1000), new Point3D(-500, -895, -1000),new Point3D(-700, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(250, -1500, -1000), new Point3D(0, -950, -1000),new Point3D(-250, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(750, -1500, -1000), new Point3D(500, -900, -1000),new Point3D(250, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(1250, -1500, -1000), new Point3D(1000, -950, -1000),new Point3D(750, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),

				new Sphere(new Point3D(-1000, -960, -1000), 50).setMaterial(new Material().setKD(0.25).setKR(0.025).setKS(0.95).setnShininess(25)).setEmission(new Color(200,12,59)),
				new Sphere(new Point3D(250, -900, -1000), 50).setEmission(new Color(200,12,59)).setMaterial(new Material().setKD(0.30).setKR(0.1).setKS(0.40).setnShininess(5)),
				new Sphere(new Point3D(-120, -1180, -1000), 50).setEmission(new Color(200,12,59)).setMaterial(new Material().setKD(0.1).setKR(0.001).setKS(0.54).setnShininess(12)),
				new Sphere(new Point3D(1100, -1150, -1000), 50).setEmission(new Color(200,12,59)).setMaterial(new Material().setKD(0.8).setKR(0.0005).setKS(0.7).setnShininess(40)),

				
				new Triangle(new Point3D(-100, -35, -150), new Point3D(150, -150, -150), new Point3D(75, 75, -150)).setEmission(new Color(10,0,255)).setMaterial(new Material().setKD(0.5).setKS(0.5).setnShininess(300).setKR(0.5)), //
				new Triangle( new Point3D(-600, -300, -600), new Point3D(-500, 400, -500), new Point3D(75, 75, -150)).setEmission(new Color(10,0,255)).setMaterial(new Material().setKD(0.5).setKS(0.25).setnShininess(500).setKR(0.26)),
				new Triangle( new Point3D(400, 100, 600), new Point3D(-500, 400, -500), new Point3D(75, 75, -150)).setEmission(new Color(10,0,255)).setMaterial(new Material().setKD(0.68).setKR(0.30).setKS(0.2).setnShininess(300)),
				new Sphere(new Point3D(750, 730, 760), 370) //
				.setEmission(new Color(java.awt.Color.RED)) //
				.setMaterial(new Material().setKD(0.4).setKS(0.3).setnShininess(100).setKT(0.3)),
		new Sphere(new Point3D(720, 700, 450), 250) //
				.setEmission(new Color(java.awt.Color.YELLOW)) //
				.setMaterial(new Material().setKD(0.5).setKS(0.5).setnShininess(100)));

		
		scene.lights.add(new DirectionalLight(new Color(990, 869, 100), new Vector(1000, 850, 950)));
		scene.lights.add(new SpotLight(new Color(720, 400, 400), new Point3D(-100, -100, -150), new Vector(1, 10, -4)) //
				.setKL(0.00001).setKQ(0.000005));

		scene.lights.add(new PointLight(new Color(500, 300, 0), new Point3D(700, 700, 950))//
				.setKL(0.00001).setKQ(0.000001));
		scene.lights.add(new PointLight(new Color(100, 300, 0), new Point3D(-1400, -1400, 1000))//
				.setKL(0.00001).setKQ(0.000001));
		ImageWriter imageWriter = new ImageWriter("imageWithGeometries1", 500, 500);
		Render render = new Render().setNumOfRays(81).setMultithreading(3) //
				.setImageWriter(imageWriter) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene).setBVH());

		render.renderImage();
		render.writeToImage();
	}
	
	
	
	
	
	@Test
	public void manyGeometries2() 
	{
		Camera camera = new Camera(new Point3D(0, 0, 10000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(2500, 2500).setDistance(10000); //

		scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));
		scene.setBackground(new Color(141,182,243));
		Geometries g1 = new Geometries(
		
//				new Sphere(new Point3D(900, 850, 950), 750) //
//						.setEmission(new Color(java.awt.Color.yellow )) //
//						.setMaterial(new Material().setKD(0.25).setKS(0.95).setnShininess(20)).setMaterial(new Material().setnShininess(500).setKR(0.18)),
//						
				new Triangle(new Point3D(-930, -1500, -1000), new Point3D(-1250, -804, -1000),new Point3D(-1500, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(-500, -1500, -1050), new Point3D(-750, -780, -1000),new Point3D(-1000, -1500, -2000)).setEmission(new Color(20, 190, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(0, -1500, -1000), new Point3D(-250, -800, -1000),new Point3D(-500, -1500, -2000)).setEmission(new Color(20, 185, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(500, -1500, -1000), new Point3D(250, -880, -1000),new Point3D(0, -1500, -2000)).setEmission(new Color(20, 195, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(1000, -1500, -1008), new Point3D(750, -842, -1000),new Point3D(500, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
			//	new Polygon(new Point3D(-1500, -1000, -2000),new Point3D(-1500, -1500, -1000),new Point3D(-1000, -1500, -1000),new Point3D(-1000, -1000, -2000)) ,
				new Triangle(new Point3D(1400, -1500, -1095), new Point3D(1250, -839, -1000),new Point3D(1050, -1500, -2000)).setEmission(new Color(20, 180, 20)).setMaterial(new Material().setKR(0.36)),
				
				
				new Triangle(new Point3D(-750, -1500, -1000), new Point3D(-1000, -960, -1000),new Point3D(-1250, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(-250, -1500, -1000), new Point3D(-500, -895, -1000),new Point3D(-700, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(250, -1500, -1000), new Point3D(0, -950, -1000),new Point3D(-250, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(750, -1500, -1000), new Point3D(500, -900, -1000),new Point3D(250, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),
				new Triangle(new Point3D(1250, -1500, -1000), new Point3D(1000, -950, -1000),new Point3D(750, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36)),

				new Sphere(new Point3D(-1000, -960, -1000), 50).setMaterial(new Material().setKD(0.25).setKR(0.025).setKS(0.95).setnShininess(25)).setEmission(new Color(200,12,59)),
				new Sphere(new Point3D(250, -900, -1000), 50).setEmission(new Color(200,12,59)).setMaterial(new Material().setKD(0.30).setKR(0.1).setKS(0.40).setnShininess(5)),
				new Sphere(new Point3D(-120, -1180, -1000), 50).setEmission(new Color(200,12,59)).setMaterial(new Material().setKD(0.1).setKR(0.001).setKS(0.54).setnShininess(12)),
				new Sphere(new Point3D(1100, -1150, -1000), 50).setEmission(new Color(200,12,59)).setMaterial(new Material().setKD(0.8).setKR(0.0005).setKS(0.7).setnShininess(40)));
	
				
		
		Geometries g2 = new Geometries(
				new Triangle(new Point3D(-100, -35, -150), new Point3D(150, -150, -150), new Point3D(75, 75, -150)).setEmission(new Color(10,0,255)).setMaterial(new Material().setKD(0.5).setKS(0.5).setnShininess(300).setKR(0.5)), //
				new Triangle( new Point3D(-600, -300, -600), new Point3D(-500, 400, -500), new Point3D(75, 75, -150)).setEmission(new Color(10,0,255)).setMaterial(new Material().setKD(0.5).setKS(0.25).setnShininess(500).setKR(0.26)),
				new Triangle( new Point3D(400, 100, 600), new Point3D(-500, 400, -500), new Point3D(75, 75, -150)).setEmission(new Color(10,0,255)).setMaterial(new Material().setKD(0.68).setKR(0.30).setKS(0.2).setnShininess(300)));
		Geometries g3 = new Geometries(		
				new Sphere(new Point3D(750, 730, 760), 370).setEmission(new Color(java.awt.Color.RED)).setMaterial(new Material().setKD(0.4).setKS(0.3).setnShininess(100).setKT(0.3)),
				new Sphere(new Point3D(720, 700, 450), 250).setEmission(new Color(java.awt.Color.YELLOW)).setMaterial(new Material().setKD(0.5).setKS(0.5).setnShininess(100)));
		scene.geometries.add(g1,g2,g3);
		
		scene.lights.add(new DirectionalLight(new Color(990, 869, 100), new Vector(1000, 850, 950)));
		scene.lights.add(new SpotLight(new Color(720, 400, 400), new Point3D(-100, -100, -150), new Vector(1, 10, -4)) //
				.setKL(0.00001).setKQ(0.000005));

		scene.lights.add(new PointLight(new Color(500, 300, 0), new Point3D(700, 700, 950))//
				.setKL(0.00001).setKQ(0.000001));
		scene.lights.add(new PointLight(new Color(100, 300, 0), new Point3D(-1400, -1400, 1000))//
				.setKL(0.00001).setKQ(0.000001));
		ImageWriter imageWriter = new ImageWriter("imageWithGeometries2", 500, 500);
		Render render = new Render().setNumOfRays(81).setMultithreading(3) //
				.setImageWriter(imageWriter) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene).setBVH());

		render.renderImage();
		render.writeToImage();
	}
	
	
	
	
	@Test
	public void manyGeometries3() 
	{
		Camera camera = new Camera(new Point3D(0, 0, 10000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(2500, 2500).setDistance(10000); //

		scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));
		scene.setBackground(new Color(141,182,243));
		
		List<Point> points = new LinkedList<Point>();
				
		points.add(	new Point(new Triangle(new Point3D(-930, -1500, -1000), new Point3D(-1250, -804, -1000),new Point3D(-1500, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36))));
		points.add(new Point(new Triangle(new Point3D(-500, -1500, -1050), new Point3D(-750, -780, -1000),new Point3D(-1000, -1500, -2000)).setEmission(new Color(20, 190, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36))));
		points.add(new Point(new Triangle(new Point3D(0, -1500, -1000), new Point3D(-250, -800, -1000),new Point3D(-500, -1500, -2000)).setEmission(new Color(20, 185, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36))));
		points.add(new Point(new Triangle(new Point3D(500, -1500, -1000), new Point3D(250, -880, -1000),new Point3D(0, -1500, -2000)).setEmission(new Color(20, 195, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36))));
		points.add(new Point(new Triangle(new Point3D(1000, -1500, -1008), new Point3D(750, -842, -1000),new Point3D(500, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36))));
		points.add(new Point(new Triangle(new Point3D(1400, -1500, -1095), new Point3D(1250, -839, -1000),new Point3D(1050, -1500, -2000)).setEmission(new Color(20, 180, 20)).setMaterial(new Material().setKR(0.36))));
		points.add(new Point(new Triangle(new Point3D(-750, -1500, -1000), new Point3D(-1000, -960, -1000),new Point3D(-1250, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36))));
		points.add(new Point(new Triangle(new Point3D(-250, -1500, -1000), new Point3D(-500, -895, -1000),new Point3D(-700, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36))));
		points.add(new Point(new Triangle(new Point3D(250, -1500, -1000), new Point3D(0, -950, -1000),new Point3D(-250, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36))));
		points.add(new Point(new Triangle(new Point3D(750, -1500, -1000), new Point3D(500, -900, -1000),new Point3D(250, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36))));
		points.add(new Point(new Triangle(new Point3D(1250, -1500, -1000), new Point3D(1000, -950, -1000),new Point3D(750, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setKR(0.5).setKR(0.36))));
		points.add(new Point(new Sphere(new Point3D(-1000, -960, -1000), 50).setMaterial(new Material().setKD(0.25).setKR(0.025).setKS(0.95).setnShininess(25)).setEmission(new Color(200,12,59))));
		points.add(new Point(new Sphere(new Point3D(250, -900, -1000), 50).setEmission(new Color(200,12,59)).setMaterial(new Material().setKD(0.30).setKR(0.1).setKS(0.40).setnShininess(5))));
		points.add(new Point(new Sphere(new Point3D(-120, -1180, -1000), 50).setEmission(new Color(200,12,59)).setMaterial(new Material().setKD(0.1).setKR(0.001).setKS(0.54).setnShininess(12))));
		points.add(new Point(new Sphere(new Point3D(1100, -1150, -1000), 50).setEmission(new Color(200,12,59)).setMaterial(new Material().setKD(0.8).setKR(0.0005).setKS(0.7).setnShininess(40))));
	
				
		points.add(new Point(new Triangle(new Point3D(-100, -35, -150), new Point3D(150, -150, -150), new Point3D(75, 75, -150)).setEmission(new Color(10,0,255)).setMaterial(new Material().setKD(0.5).setKS(0.5).setnShininess(300).setKR(0.5))));
		points.add(new Point(new Triangle( new Point3D(-600, -300, -600), new Point3D(-500, 400, -500), new Point3D(75, 75, -150)).setEmission(new Color(10,0,255)).setMaterial(new Material().setKD(0.5).setKS(0.25).setnShininess(500).setKR(0.26))));
		points.add(new Point(new Triangle( new Point3D(400, 100, 600), new Point3D(-500, 400, -500), new Point3D(75, 75, -150)).setEmission(new Color(10,0,255)).setMaterial(new Material().setKD(0.68).setKR(0.30).setKS(0.2).setnShininess(300))));
		points.add(new Point(new Sphere(new Point3D(750, 730, 760), 370).setEmission(new Color(java.awt.Color.RED)).setMaterial(new Material().setKD(0.4).setKS(0.3).setnShininess(100).setKT(0.3))));
		points.add(new Point(new Sphere(new Point3D(720, 700, 450), 250).setEmission(new Color(java.awt.Color.YELLOW)).setMaterial(new Material().setKD(0.5).setKS(0.5).setnShininess(100))));
		KMeans Kmeans = new KMeans();
		Kmeans.init(points);
		Kmeans.calculate();
		List<Cluster> clusters = Kmeans.getClusters(); // Divide all the geometries into 3 clusters
		for (Cluster c : clusters)
		{ // Put all of the geometries in this cluster in one box
			Geometries geos = new Geometries();
			for (Point p : c.getPoints()) 
			{
				geos.add(p.getGeometry());
			}
			scene.geometries.add(geos);

		}
		
		scene.lights.add(new DirectionalLight(new Color(990, 869, 100), new Vector(1000, 850, 950)));
		scene.lights.add(new SpotLight(new Color(720, 400, 400), new Point3D(-100, -100, -150), new Vector(1, 10, -4)) //
				.setKL(0.00001).setKQ(0.000005));

		scene.lights.add(new PointLight(new Color(500, 300, 0), new Point3D(700, 700, 950))//
				.setKL(0.00001).setKQ(0.000001));
		scene.lights.add(new PointLight(new Color(100, 300, 0), new Point3D(-1400, -1400, 1000))//
				.setKL(0.00001).setKQ(0.000001));
		ImageWriter imageWriter = new ImageWriter("imageWithGeometries3", 500, 500);
		Render render = new Render().setNumOfRays(81).setMultithreading(3) //
				.setImageWriter(imageWriter) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene).setBVH());

		render.renderImage();
		render.writeToImage();
	}
	
}
