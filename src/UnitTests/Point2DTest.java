package UnitTests;
import Primitives.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class Point2DTest {

	@Test
	public void getTest() {
		
		Coordinate c1=new Coordinate(1);
		Coordinate c2=new Coordinate(3);
		Point2D x1=new Point2D(c1, c2);
		assertEquals(x1.get_x(),c1);
		assertEquals(x1.get_y(),c2);
	}

	@Test
	public void setTest() {
		
		Coordinate c1=new Coordinate(1);
		Coordinate c2=new Coordinate(3);
		Point2D x1=new Point2D(c1, c2);
		Coordinate c3=new Coordinate(6);
		x1.set_x(c3);
		assertEquals(x1.get_x().toString(),(new Coordinate(6)).toString());
	}
	
	@Test
	public void equalsTest() {
		Coordinate c1=new Coordinate(1);
		Coordinate c2=new Coordinate(3);
		Coordinate c3=new Coordinate(1);
		Point2D x1=new Point2D(c1, c2);
		Point2D x2=new Point2D(c3, c2);
		assertTrue(x1.equals(x2));
	}
	//Point2D
		
	@Test
	public void toStringTest() {
		Coordinate c1=new Coordinate(1);
		Coordinate c2=new Coordinate(3);
		Point2D x1=new Point2D(c1, c2);	
		assertNotNull(x1.toString());
		System.out.println(x1);

	}
}

