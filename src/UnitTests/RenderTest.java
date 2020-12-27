package UnitTests;

import java.awt.Color;

import org.junit.Test;

import Elements.*;
import Geometries.*;
import Primitives.*;
import Renderer.*;
import Scene.*;

public class RenderTest {
	@Test
	public void renderingTest1(){
        
        Scene scene = new Scene();
         
        scene.addGeometry(new Sphere(50, new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-149))));
         
        Triangle triangle = new Triangle(new Point3D( new Coordinate(100), new Coordinate(0), new Coordinate(-149)),
                                         new Point3D(new Coordinate(0), new Coordinate(100), new Coordinate(-149)),
                                         new Point3D( new Coordinate(100), new Coordinate(100), new Coordinate(-149)));
         
        Triangle triangle2 = new Triangle(new Point3D( new Coordinate(100), new Coordinate(0), new Coordinate(-149)),
                                          new Point3D(new Coordinate(0), new Coordinate(-100), new Coordinate(-149)),
                                          new Point3D( new Coordinate(100), new Coordinate(-100), new Coordinate(-149)));
         
        Triangle triangle3 = new Triangle(new Point3D(new Coordinate(-100), new Coordinate(0), new Coordinate(-149)),
                                          new Point3D( new Coordinate(0), new Coordinate(100), new Coordinate(-149)),
                                          new Point3D(new Coordinate(-100), new Coordinate(100), new Coordinate(-149)));
         
        Triangle triangle4 = new Triangle(new Point3D(new Coordinate(-100), new Coordinate(0), new Coordinate(-149)),
                                          new Point3D( new Coordinate(0), new Coordinate(-100), new Coordinate(-149)),
                                          new Point3D(new Coordinate(-100), new Coordinate(-100), new Coordinate(-149)));
         
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
         
        ImageWriter imageWriter = new ImageWriter("RenderTest_1", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        render.renderImage();
        render.printGrid(50);
        render.get_imageWriter().writeToImage();
         
    }
	
	@Test
	public void renderingTest2(){
        
        Scene scene = new Scene();
        scene.set_ambientLight(new AmbientLight(Color.blue,0.8));
        
         
        scene.addGeometry(new Sphere(100, new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-149))));
         
        Triangle triangle = new Triangle(new Point3D( new Coordinate(100), new Coordinate(0), new Coordinate(-149)),
                                         new Point3D(new Coordinate(0), new Coordinate(100), new Coordinate(-149)),
                                         new Point3D( new Coordinate(100), new Coordinate(100), new Coordinate(-149)));
         
        Triangle triangle2 = new Triangle(new Point3D( new Coordinate(100), new Coordinate(0), new Coordinate(-149)),
                                          new Point3D(new Coordinate(0), new Coordinate(-100), new Coordinate(-149)),
                                          new Point3D( new Coordinate(100), new Coordinate(-100), new Coordinate(-149)));
         
        Triangle triangle3 = new Triangle(new Point3D(new Coordinate(-100), new Coordinate(0), new Coordinate(-149)),
                                          new Point3D( new Coordinate(0), new Coordinate(100), new Coordinate(-149)),
                                          new Point3D(new Coordinate(-100), new Coordinate(100), new Coordinate(-149)));
         
        Triangle triangle4 = new Triangle(new Point3D(new Coordinate(-100), new Coordinate(0), new Coordinate(-149)),
                                          new Point3D( new Coordinate(0), new Coordinate(-100), new Coordinate(-149)),
                                          new Point3D(new Coordinate(-100), new Coordinate(-100), new Coordinate(-149)));
         
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
         
        ImageWriter imageWriter = new ImageWriter("RenderTest_2", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        render.renderImage();
        render.printGrid(10);
        render.get_imageWriter().writeToImage();
         
    }
	

	@Test
	public void renderingTest3(){
        
        Scene scene = new Scene();
        scene.set_ambientLight(new AmbientLight(Color.white,0.1));
        
         
        scene.addGeometry(new Sphere(50, new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-150))));
         
        Triangle triangle = new Triangle(Color.red,new Point3D( new Coordinate(100), new Coordinate(0), new Coordinate(-149)),
                                         new Point3D(new Coordinate(0), new Coordinate(100), new Coordinate(-149)),
                                         new Point3D( new Coordinate(100), new Coordinate(100), new Coordinate(-149)));
         
        Triangle triangle2 = new Triangle(Color.green,new Point3D( new Coordinate(100), new Coordinate(0), new Coordinate(-149)),
                                          new Point3D(new Coordinate(0), new Coordinate(-100), new Coordinate(-149)),
                                          new Point3D( new Coordinate(100), new Coordinate(-100), new Coordinate(-149)));
         
        Triangle triangle3 = new Triangle(Color.orange,new Point3D(new Coordinate(-100), new Coordinate(0), new Coordinate(-149)),
                                          new Point3D( new Coordinate(0), new Coordinate(100), new Coordinate(-149)),
                                          new Point3D(new Coordinate(-100), new Coordinate(100), new Coordinate(-149)));
         
        Triangle triangle4 = new Triangle(Color.pink,new Point3D(new Coordinate(-100), new Coordinate(0), new Coordinate(-149)),
                                          new Point3D( new Coordinate(0), new Coordinate(-100), new Coordinate(-149)),
                                          new Point3D(new Coordinate(-100), new Coordinate(-100), new Coordinate(-149)));
         
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
         
        ImageWriter imageWriter = new ImageWriter("RenderTest_3", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        render.renderImage();
        render.printGrid(55);
        render.get_imageWriter().writeToImage();
         
    }
	
	@Test
	public void renderingTest4(){
        
        Scene scene = new Scene();
        scene.set_ambientLight(new AmbientLight(Color.red,0.3));
        
         
        scene.addGeometry(new Sphere(50, new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-150))));
         
        Triangle triangle = new Triangle(new Point3D( new Coordinate(100), new Coordinate(0), new Coordinate(-149)),
                                         new Point3D(new Coordinate(0), new Coordinate(100), new Coordinate(-149)),
                                         new Point3D( new Coordinate(100), new Coordinate(100), new Coordinate(-149)));
         
        Triangle triangle2 = new Triangle(Color.green,new Point3D( new Coordinate(100), new Coordinate(0), new Coordinate(-149)),
                                          new Point3D(new Coordinate(0), new Coordinate(-100), new Coordinate(-149)),
                                          new Point3D( new Coordinate(100), new Coordinate(-100), new Coordinate(-149)));
         
        Triangle triangle3 = new Triangle(Color.orange,new Point3D(new Coordinate(-100), new Coordinate(0), new Coordinate(-149)),
                                          new Point3D( new Coordinate(0), new Coordinate(100), new Coordinate(-149)),
                                          new Point3D(new Coordinate(-100), new Coordinate(100), new Coordinate(-149)));
         
        Triangle triangle4 = new Triangle(Color.pink,new Point3D(new Coordinate(-100), new Coordinate(0), new Coordinate(-149)),
                                          new Point3D( new Coordinate(0), new Coordinate(-100), new Coordinate(-149)),
                                          new Point3D(new Coordinate(-100), new Coordinate(-100), new Coordinate(-149)));
         
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
         
        ImageWriter imageWriter = new ImageWriter("RenderTest_4", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        render.renderImage();
        render.printGrid(55);
        render.get_imageWriter().writeToImage();
         
    }
	
	@Test
	public void testAddingLightSources(){
		
		PointLight pl = new PointLight(new PointLight(new Color(255,100,100), new Point3D(new Coordinate(-200), new Coordinate(-200), new Coordinate(-100)), 
							   0, 0.000001, 0.0000005));
		SpotLight sl = new SpotLight(new SpotLight(new Color(255, 100, 100), new Point3D(new Coordinate(-200), new Coordinate(-200), new Coordinate(-100)), 
				0, 0.00001, 0.000005,  new Vector()));
		
		DirectionalLight dl = new DirectionalLight(new Color(255, 100, 100),new Vector());
		
	}

}