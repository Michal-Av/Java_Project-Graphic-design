package UnitTests;
import Primitives.*;
import Geometries.Sphere;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

public class SphereTest {

	@Test
	public void testGetNormal() {
		Sphere sphere=new Sphere(4.2, new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)));
		Vector actual= sphere.getNormal(new Point3D(new Coordinate(0),new Coordinate(5), new Coordinate(10)));
		Vector expected=new Vector(new Point3D(new Coordinate(-3),new Coordinate(3), new Coordinate(9))).normalize();
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void intersectionPointsTest()
	{
		// creating the expected values
		ArrayList<Point3D> answerList1 = new ArrayList<Point3D>();
		ArrayList<Point3D> answerList2 = new ArrayList<Point3D>();
	
		Point3D answerPoint1 = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-200));
		Point3D answerPoint2 = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-600));
		
		answerList2.add(answerPoint1);
		answerList2.add(answerPoint2);
		
		
		// building the spheres
		
		Point3D p1 = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-400));
		Point3D p2 = new Point3D(p1);		
		Point3D centerPoint = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0));
		
		Vector direction1 = new Vector(new Point3D(new Coordinate(50), new Coordinate(-50), new Coordinate(-50)));
		Vector direction2 = new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-5)));
		Sphere sphere1 = new Sphere(Color.white, 200, p1);
		Sphere sphere2 = new Sphere(Color.white, 200, p2);
		
		// building the ray that will intersect the spheres
		
		Ray ray1 = new Ray(centerPoint, direction1);
		Ray ray2 = new Ray(centerPoint, direction2);
		
		// testing the findIntersection functions
		ArrayList<Point3D> list1 = new ArrayList<Point3D>();
		list1 = sphere1.findIntersections(ray1);
		assertEquals(answerList1, list1);
		
		ArrayList<Point3D> list2 = new ArrayList<Point3D>();
		list2 = sphere2.findIntersections(ray2);
		assertEquals(answerList2, list2);
		
	}
	
	@Test
	public void testFindIntersectionEdgeCase()//Check when camera is inside the sphere
	{
		Sphere sphere=new Sphere(3, new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(-2)));
		ArrayList<Point3D> actual=sphere.findIntersections(new Ray(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)),
				new Vector(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(-1)))));
		ArrayList<Point3D> expected=new ArrayList<Point3D>();
		expected.add(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(-5)));
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindIntersectionEdgeCase2()//Check when there are no intersections
	{
		Sphere sphere=new Sphere(1, new Point3D(new Coordinate(0),new Coordinate(2), new Coordinate(-2)));
		ArrayList<Point3D> actual=sphere.findIntersections(new Ray(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)),
				new Vector(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(-1)))));
		ArrayList<Point3D> expected=new ArrayList<Point3D>();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindIntersection()//Check when there are two intersections
	{
		Sphere sphere=new Sphere(1, new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(-3)));
		ArrayList<Point3D> actual=sphere.findIntersections(new Ray(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)),
				new Vector(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(-1)))));
		ArrayList<Point3D> expected=new ArrayList<Point3D>();
		expected.add(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(-2)));
		expected.add(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(-4)));
		assertEquals(expected, actual);
	}
	
}
