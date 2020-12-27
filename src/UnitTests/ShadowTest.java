package UnitTests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Elements.PointLight;
import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Coordinate;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

import org.junit.Test;

public class ShadowTest {

	@Test
	public void testShadow(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		
		Sphere sphere = new Sphere (new Color(0,0,100),500, new Point3D(0,0,-1000));
		
		Material m = new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Color (0, 0, 100),
										 new Point3D(-125, -225, -260),
										 new Point3D(-225, -125, -260),
										 new Point3D(-225, -225, -270)
									);
		
		Material m1=new Material();
		m1.set_nShininess(4);
		triangle.set_material(m);
		scene.addGeometry(triangle);
	
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					  0.1, 0.00001, 0.000005,   new Vector(new Point3D(2, 2, -3))));
	

		ImageWriter imageWriter = new ImageWriter("ShadowTest", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToImage();
	}
	
	@Test
	public void testShadow1(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		
		Sphere sphere = new Sphere (new Color(80,0,100),500, new Point3D(0,0,-1000));
		
		Material m = new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Color (0, 20, 175),
										 new Point3D(-100, -200, -235),
										 new Point3D(-200, -100, -235),
										 new Point3D(-200, -200, -245)
									);
		
		Material m1=new Material();
		m1.set_nShininess(4);
		triangle.set_material(m);
		scene.addGeometry(triangle);
	
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					  0.1, 0.00001, 0.000005,   new Vector(new Point3D(2, 2, -3))));
	

		ImageWriter imageWriter = new ImageWriter("ShadowTest1", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToImage();
	}
	
	@Test
	public void testShadow2(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		
		Sphere sphere = new Sphere (new Color(0,0,100),500, new Point3D(0,0,-1000));
		
		Material m = new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Color (0, 0, 100),
										 new Point3D(-125, -225, -260),
										 new Point3D(-225, -125, -260),
										 new Point3D(-225, -225, -270)
									);
		
		Material m1=new Material();
		m1.set_nShininess(4);
		triangle.set_material(m);
		scene.addGeometry(triangle);
	
		scene.addLight(new SpotLight(new Color(255, 50, 80), new Point3D(-250, -250, -200), 
					  0.1, 0.00001, 0.000005,   new Vector(new Point3D(2, 2, -3))));
	

		ImageWriter imageWriter = new ImageWriter("ShadowTest2", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToImage();
	}
	
	@Test
	public void testShadow3(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		
		Sphere sphere = new Sphere (new Color(0,0,100),500, new Point3D(0,0,-1000));
		
		Material m = new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Color (0, 0, 100),
										 new Point3D(-125, -225, -260),
										 new Point3D(-225, -125, -260),
										 new Point3D(-225, -225, -270)
									);
		
		Material m1=new Material();
		m1.set_nShininess(4);
		triangle.set_material(m);
		scene.addGeometry(triangle);
	
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-150, -150, -100), 
					  0.1, 0.00001, 0.000005,   new Vector(new Point3D(2, 2, -3))));
	

		ImageWriter imageWriter = new ImageWriter("ShadowTest3", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToImage();
	}
	

	@Test
	public void testShadow4(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		
		Sphere sphere = new Sphere (new Color(0,0,100),500, new Point3D(0,0,-1000));
		
		Material m = new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Color (0, 0, 100),
										 new Point3D(-125, -225, -260),
										 new Point3D(-225, -125, -260),
										 new Point3D(-225, -225, -270)
									);
		
		Material m1=new Material();
		m1.set_nShininess(4);
		triangle.set_material(m);
		scene.addGeometry(triangle);
	
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					  0.1, 0.00001, 0.000005,   new Vector(new Point3D(56,34,-1))));
	

		ImageWriter imageWriter = new ImageWriter("ShadowTest4", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToImage();
	}
	

}
