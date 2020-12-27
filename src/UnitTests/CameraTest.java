package UnitTests;
import Primitives.*;
import Elements.Camera;

import static org.junit.Assert.*;

import org.junit.Test;

public class CameraTest {

	@Test
	public void testConstructRayThroughPixel() {
		Camera c=new Camera();
		c.set_P0(new Point3D());
		c.set_vTo(new Vector(new Point3D(new Coordinate(1), new Coordinate(0), new Coordinate(0))));
		c.set_vUp(new Vector(new Point3D(new Coordinate(0), new Coordinate(1), new Coordinate(0))));
		Ray actual=c.constructRayThroughPixel(5, 5, 2, 3, 4.5, 50, 50);
		Ray expected=new Ray(new Point3D(), new Vector(new Point3D(new Coordinate(4.5), new Coordinate(-10), new Coordinate(0))));
		System.out.println(expected.toString());
		System.out.println(actual.toString());
		assertEquals(expected, actual);
	}

}