package UnitTests;
import Primitives.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class Point3DTest {

	@Test
	public void addTest() {
		Coordinate c1=new Coordinate(2);
		Coordinate c2=new Coordinate(3);
		Coordinate c3=new Coordinate(4);
		Point3D p1= new Point3D(c1,c2,c3);
		Coordinate b1=new Coordinate(1);
		Coordinate b2=new Coordinate(3);
		Coordinate b3=new Coordinate(4);
		Vector v=new Vector(new Point3D(b1,b2,b3));
		p1.add(v);
		assertEquals(p1, new Point3D (new Coordinate(3), new Coordinate(6),new Coordinate(8)));
	}
	
	@Test
	public void subTest() {
		Coordinate b1=new Coordinate(1);
		Coordinate b2=new Coordinate(3);
		Coordinate b3=new Coordinate(4);
		Vector v=new Vector(new Point3D(b1,b2,b3));
		Coordinate r1=new Coordinate(-0.0);
		Coordinate r2=new Coordinate(-8);
		Coordinate r3=new Coordinate(6);
        Point3D p1 = new Point3D(r1,r2,r3);
		p1.substract(v);
		assertEquals(p1,new Point3D(new Coordinate(-1),new Coordinate(-11),new Coordinate(2)));
	}

}
