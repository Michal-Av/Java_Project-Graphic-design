package Primitives;
import Geometries.*;

public class main {

	public static void main(String[] args) {
		Vector vec1=new Vector(new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)));
		Vector vec2=new Vector(new Point3D(new Coordinate(0),new Coordinate(5), new Coordinate(10)));
		vec1.add(vec2);
		System.out.println(vec1);
		vec1.substract(vec2);
		System.out.println(vec1);
		System.out.println(vec1.dotProduct(vec2));
		vec1.scale(3.5);
		System.out.println(vec1);
		System.out.println(vec1.length());
		System.out.println(vec1.normalize());
		System.out.println(vec1.crossProduct(vec2));
		
//		
		Triangle tri=new Triangle(new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)),
				new Point3D(new Coordinate(4),new Coordinate(5), new Coordinate(6)),
				new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)));
		
		Plane plane=new Plane(new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)),
				new Vector(new Point3D(new Coordinate(4),new Coordinate(5), new Coordinate(6))));
		
		Sphere sphere=new Sphere(4.2, new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1)));
		
		Cylinder cyli=new Cylinder(7.1,new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)),
				new Vector(new Point3D(new Coordinate(3),new Coordinate(2), new Coordinate(1))));
		
		System.out.println(tri.getNormal(new Point3D(new Coordinate(0),new Coordinate(5), new Coordinate(10))));
		System.out.println(sphere.getNormal(new Point3D(new Coordinate(0),new Coordinate(5), new Coordinate(10))));
		System.out.println(plane.getNormal(new Point3D(new Coordinate(0),new Coordinate(5), new Coordinate(10))));
		System.out.println(cyli.getNormal(new Point3D(new Coordinate(0),new Coordinate(5), new Coordinate(10))));
		

	}

}
