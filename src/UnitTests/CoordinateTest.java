package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Primitives.Coordinate;

public class CoordinateTest {

	@Test
	public void testGet() {
		Coordinate c1=new Coordinate(2);
		System.out.println(c1.get_coordinate());
		System.out.println(new Coordinate(2));
		assertEquals(c1.toString(), (new Coordinate(2)).toString());
	}

	@Test
	public void testSet() {
		Coordinate c1=new Coordinate(2);
		Coordinate c3=new Coordinate(4);
		c1.set_coordinate(4);
		assertEquals(c1.toString(), c3.toString());
	}
	
	@Test
	public void testEquals() {
		Coordinate c1=new Coordinate(2);
		Coordinate c3=new Coordinate(2);
		assertTrue(c1.equals(c3));
	}
	
	@Test
	public void testToString() {
		Coordinate c1=new Coordinate(2);
		assertNotNull(c1.toString());
		System.out.println(c1);
	}		
}
