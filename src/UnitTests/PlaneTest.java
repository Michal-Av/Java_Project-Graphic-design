package UnitTests;
import Primitives.*;
import Geometries.Plane;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

public class PlaneTest {

	@Test
	public void testGetNormal() {
		
		Plane p=new Plane(new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)),
				new Vector(new Point3D(new Coordinate(4),new Coordinate(5), new Coordinate(6))));
		Vector actual=p.getNormal(new Point3D(new Coordinate(0),new Coordinate(5), new Coordinate(10)));
		Vector expected=new Vector(new Point3D(new Coordinate(4),new Coordinate(5), new Coordinate(6))).normalize();
		assertEquals(expected, actual);
	}
	
	@Test
	public void intersectionPointsTest()
	{
	// creating the expected values
		
		ArrayList<Point3D> answerList = new ArrayList<Point3D>();		
		Point3D answerPoint = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-200));		
		answerList.add(answerPoint);
		
		// building the plane
		
		Point3D directionPoint = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-1));
		Point3D planePoint = new Point3D(new Coordinate(0), new Coordinate(100), new Coordinate(-200));
				
		Vector direction = new Vector(directionPoint);
		
		Plane plane = new Plane(Color.white, planePoint, direction);
			
		// building the ray that will intersect the plane
		
		Point3D centerPoint = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0));
		Vector vector = new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-5)));
		Ray ray = new Ray(centerPoint, vector);
	
		// testing the findIntersection function
		
		ArrayList<Point3D> list = new ArrayList<Point3D>();
		list = plane.findIntersections(ray);
		assertEquals(answerList, list);
	}
	
	@Test
	public void testFindfIntersectionEdgeCase()
	{
		Plane p=new Plane(new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)),
				new Vector(new Point3D(new Coordinate(1),new Coordinate(0), new Coordinate(0))));
		ArrayList<Point3D> actual=p.findIntersections(new Ray(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)),
				new Vector(new Point3D(new Coordinate(0),new Coordinate(1), new Coordinate(0)))));
		ArrayList<Point3D> expected=new ArrayList<Point3D>();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindfIntersection()
	{
		Plane p=new Plane(new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)),
				new Vector(new Point3D(new Coordinate(1),new Coordinate(0), new Coordinate(0))));
		ArrayList<Point3D> actual=p.findIntersections(new Ray(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)),
				new Vector(new Point3D(new Coordinate(1),new Coordinate(2), new Coordinate(-2)))));
		ArrayList<Point3D> expected=new ArrayList<Point3D>();
		expected.add(new Point3D(new Coordinate(3),new Coordinate(6), new Coordinate(-6)));
		assertEquals(expected, actual);
	}

}

