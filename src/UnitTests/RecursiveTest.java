package UnitTests;

import java.awt.Color;

import org.junit.Test;

import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

import org.junit.Test;

public class RecursiveTest {


	@Test
	public void recursiveTest1(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		
		Sphere sphere = new Sphere(new Color(0,0, 100), 500, new Point3D(0.0, 0.0, -1000));	
		Material material = new Material();		
		material.set_nShininess(20); 
		material.set_Kt(0.5);
		sphere.set_material(new Material(material));
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Color (100, 20, 20), 250, new Point3D(0.0, 0.0, -1000));
		material.set_Kt(0);	
		sphere2.set_material(new Material(material));
		scene.addGeometry(sphere2);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
							   0.1, 0.00001, 0.000005,  new Vector(new Point3D(2, 2, -3)))); // NOW
				
		ImageWriter imageWriter = new ImageWriter("RecursiveTest1", 500, 500, 500, 500);
		
		Render render = new Render( scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToImage();
		
	}
	
	
	
	@Test
	public void recursiveTest2(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		
		Sphere sphere = new Sphere(Color.RED, 500, new Point3D(0.0, 0.0, -1000));
		Material material = new Material();
		material.set_nShininess(20);
		material.set_Kt(0.5);
		sphere.set_material(new Material(material));	
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(Color.BLUE, 250, new Point3D(0.0, 0.0, -1000));
		material.set_Kt(0);
		sphere2.set_material(new Material(material));
		scene.addGeometry(sphere2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					    0.1, 0.00001, 0.000005, new Vector(new Point3D(2, 2, -3))));
			
		ImageWriter imageWriter = new ImageWriter("RecursiveTest2", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToImage();
	}
	
	
	@Test
	public void recursiveTest3(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		Sphere sphere = new Sphere(new Color(0, 0, 100), 300, new Point3D(-550, -500, -1000));
		Material material = new Material();
		material.set_nShininess(20); 
		material.set_Kt(0.5);
		sphere.set_material(new Material(material));
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Color(100, 20, 20), 150, new Point3D(-550, -500, -1000));
		Material material2 = new Material();
		material2.set_nShininess(20);
		material2.set_Kt(0);		
		sphere2.set_material(new Material(material2));
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Color(20, 20, 20), new Point3D(  1500, -1500, -1500),
				 new Point3D( -1500,  1500, -1500),
				 new Point3D(  200,  200, -375));

		Triangle triangle2 = new Triangle(new Color(0, 20, 20), new Point3D(  1500, -1500, -1500),
				  new Point3D( -1500,  1500, -1500),
				  new Point3D( -1500, -1500, -1500));

		
	
		Material material3 = new Material();		
		material3.set_Kr(1);		
		triangle.set_material(new Material(material3));
		
		Material material4 = new Material();		
		material4.set_Kr(0.5);		
		triangle2.set_material(new Material(material4));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);


		scene.addLight(new SpotLight(new Color(255, 100, 150),  new Point3D(200, 200, -150), 
				   0.1, 0.00001, 0.000005,  new Vector(new Point3D(-2, -2, -3))));
	
		ImageWriter imageWriter = new ImageWriter("RecursiveTest3", 500, 500, 500, 500);
		
		Render render = new Render( scene, imageWriter);
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToImage();		
	}

	@Test
	public void recursiveTest4(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		Sphere sphere = new Sphere(new Color(0, 0, 100), 300, new Point3D(-550, -500, -1000));
		Material material = new Material();
		material.set_nShininess(20); 
		material.set_Kt(0.5);
		sphere.set_material(new Material(material));
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Color(100, 20, 20), 150, new Point3D(-550, -500, -1000));
		Material material2 = new Material();
		material2.set_nShininess(20);
		material2.set_Kt(0);		
		sphere2.set_material(new Material(material2));
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Color(20, 20, 20), new Point3D(  1500, -1500, -1500),
				 new Point3D( -1500,  1500, -1500),
				 new Point3D(  200,  200, -375));

		Triangle triangle2 = new Triangle(new Color(0, 20, 20), new Point3D(  1500, -1500, -1500),
				  new Point3D( -1500,  1500, -1500),
				  new Point3D( -1500, -1500, -1500));

		
	
		Material material3 = new Material();		
		material3.set_Kr(1);		
		triangle.set_material(new Material(material3));
		
		Material material4 = new Material();		
		material4.set_Kr(0.5);		
		triangle2.set_material(new Material(material4));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);


		scene.addLight(new SpotLight(new Color(150, 100, 200),  new Point3D(200, 200, -150), 
				   0.1, 0.00001, 0.000005,  new Vector(new Point3D(-2, -2, -3))));
	
		ImageWriter imageWriter = new ImageWriter("RecursiveTest4", 500, 500, 500, 500);
		
		Render render = new Render( scene, imageWriter);
		render.renderImage();
		render.printGrid(50);
		imageWriter.writeToImage();		
	}
}
