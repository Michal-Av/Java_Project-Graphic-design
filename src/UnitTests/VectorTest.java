package UnitTests;
import Primitives.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VectorTest {

	@Test
	public void testAdd() {
		Vector vec1=new Vector(new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)));
		Vector vec2=new Vector(new Point3D(new Coordinate(0),new Coordinate(-2.5), new Coordinate(10)));
		vec1.add(vec2);
		Vector actual=vec1;
		Vector expected=new Vector(new Point3D(new Coordinate(3),new Coordinate(-0.5), new Coordinate(11)));
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testSub() {
		Vector vec1=new Vector(new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)));
		Vector vec2=new Vector(new Point3D(new Coordinate(0),new Coordinate(-2.5), new Coordinate(10)));
		vec1.substract(vec2);
		Vector actual=vec1;
		Vector expected=new Vector(new Point3D(new Coordinate(3),new Coordinate(4.5), new Coordinate(-9)));
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testDotProduct() {
		Vector vec1=new Vector(new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)));
		Vector vec2=new Vector(new Point3D(new Coordinate(0),new Coordinate(-2.5), new Coordinate(10)));
		double actual=vec1.dotProduct(vec2);
		double expected=5;
		assertEquals(expected, actual,0);		
	}
	
	@Test
	public void testScalarMultiplication() {
		Vector vec=new Vector(new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)));
		vec.scale(-3.5);
		Vector actual=vec;
		Vector expected=new Vector(new Point3D(new Coordinate(-10.5),new Coordinate(-7), new Coordinate(-3.5)));
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testLength() {
		Vector vec=new Vector(new Point3D(new Coordinate(-4),new Coordinate(3), new Coordinate(0)));
		double actual=vec.length();
		double expected=5;
		assertEquals(expected, actual,0);		
	}
	
	@Test
	public void testNormalize() {
		Vector vec=new Vector(new Point3D(new Coordinate(-4),new Coordinate(3), new Coordinate(0)));
		Vector actual=vec.normalize();
		Vector expected=new Vector(new Point3D(new Coordinate(-0.8),new Coordinate(0.6), new Coordinate(0)));
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testCrossProduct() {
		Vector vec1=new Vector(new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)));
		Vector vec2=new Vector(new Point3D(new Coordinate(0),new Coordinate(-2.5), new Coordinate(10)));
		Vector actual=vec1.crossProduct(vec2);
		Vector expected=new Vector(new Point3D(new Coordinate(22.5),new Coordinate(-30), new Coordinate(-7.5)));
		assertEquals(expected, actual);		
	}
}
