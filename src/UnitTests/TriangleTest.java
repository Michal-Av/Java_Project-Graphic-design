package UnitTests;

import Primitives.*;
import Geometries.Sphere;
import Geometries.Triangle;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void normalTest() {
		
		Triangle tri=new Triangle(new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)),
				new Point3D(new Coordinate(4),new Coordinate(5), new Coordinate(6)),
				new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)));
		Vector actual=tri.getNormal(null);
		System.out.println(actual.toString());
		Vector expected=new Vector(new Point3D(new Coordinate(1),new Coordinate(3), new Coordinate(5))).crossProduct
				(new Vector(new Point3D(new Coordinate(-3),new Coordinate(-2), new Coordinate(-1)))).normalize();
		System.out.println(expected.toString());
		assertEquals(expected, actual);
	}
	
	@Test
	public void intersectionPointsTest()
	{

		// creating the expected values
		ArrayList<Point3D> answerList = new ArrayList<Point3D>();		
		Point3D answerPoint = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-200));		
		answerList.add(answerPoint);
		
		// building the triangle
		
		Point3D p1 = new Point3D(new Coordinate(0), new Coordinate(100), new Coordinate(-200));
		Point3D p2 = new Point3D(new Coordinate(100), new Coordinate(-100), new Coordinate(-200));
		Point3D p3 = new Point3D(new Coordinate(-100), new Coordinate(-100), new Coordinate(-200));
		
		Triangle t1 = new Triangle(Color.white, p1, p2, p3);
		Triangle t2 = new Triangle(t1);			
		
		// building the ray that will intersect the triangle
		
		Point3D centerPoint = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0));		
		Vector vector = new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-5)));
		Ray ray = new Ray(centerPoint, vector);
	
		// testing the findIntersection function
		
		ArrayList<Point3D> list = new ArrayList<Point3D>();
		list = t2.findIntersections(ray);
		assertEquals(answerList, list);	
	}
	
	@Test
	public void testFindIntersectionEdgeCase()//Check when the intersection is out of plane
	{
		Triangle tri=new Triangle(new Point3D(new Coordinate(1),new Coordinate(1), new Coordinate(0)),
				new Point3D(new Coordinate(1),new Coordinate(5), new Coordinate(0)),
				new Point3D(new Coordinate(5),new Coordinate(1), new Coordinate(0)));
		ArrayList<Point3D> actual=tri.findIntersections(new Ray(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)),
				new Vector(new Point3D(new Coordinate(-1),new Coordinate(-1), new Coordinate(0)))));
		ArrayList<Point3D> expected=new ArrayList<Point3D>();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindIntersectionEdgeCase2()//Check when the intersection is the point of camera 
	{
		Triangle tri=new Triangle(new Point3D(new Coordinate(1),new Coordinate(1), new Coordinate(0)),
				new Point3D(new Coordinate(1),new Coordinate(5), new Coordinate(0)),
				new Point3D(new Coordinate(5),new Coordinate(1), new Coordinate(0)));
		ArrayList<Point3D> actual=tri.findIntersections(new Ray(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)),
				new Vector(new Point3D(new Coordinate(-1),new Coordinate(4), new Coordinate(-6)))));
		ArrayList<Point3D> expected=new ArrayList<Point3D>();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindIntersection()
	{
		Triangle tri=new Triangle(new Point3D(new Coordinate(1),new Coordinate(0), new Coordinate(0)),
				new Point3D(new Coordinate(0),new Coordinate(1), new Coordinate(0)),
				new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(1)));
		ArrayList<Point3D> actual=tri.findIntersections(new Ray(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)),
				new Vector(new Point3D(new Coordinate(1),new Coordinate(1), new Coordinate(1)))));
		ArrayList<Point3D> expected=new ArrayList<Point3D>();
		expected.add(new Point3D(new Coordinate(1.0/3),new Coordinate(1.0/3), new Coordinate(1.0/3)));
		assertEquals(expected, actual);
	}
}
