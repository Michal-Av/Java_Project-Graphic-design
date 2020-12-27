package Geometries;
import java.awt.Color;
import java.util.ArrayList;

import Primitives.*;

public class Triangle  extends Geometry implements FlatGeometry{
	private Point3D _p1,_p2,_p3;

	//************************Constructors*************************//
	
	public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) {
		super();
		this._p1 = new Point3D(_p1);
		this._p2 = new Point3D(_p2);
		this._p3 = new Point3D(_p3);
	}
	
	public Triangle() {
		super();
		this._p1 = new Point3D();
		this._p2 = new Point3D();
		this._p3 = new Point3D();
	}
	
	public Triangle(Color c, Point3D _p1, Point3D _p2, Point3D _p3) {
		super(new Color(c.getRGB()));
		this._p1 = new Point3D(_p1);
		this._p2 = new Point3D(_p2);
		this._p3 = new Point3D(_p3);
	}
	
	public Triangle(Color c, Material m, Point3D _p1, Point3D _p2, Point3D _p3) {
		super(new Color(c.getRGB()), new Material(m));
		this._p1 = new Point3D(_p1);
		this._p2 = new Point3D(_p2);
		this._p3 = new Point3D(_p3);
	}
	
	public Triangle (Triangle t)
	{
		super(new Color(t._emmision.getRGB()), new Material(t._material));
		this._p1 = new Point3D(t._p1);
		this._p2 = new Point3D(t._p2);
		this._p3 = new Point3D(t._p3);
		
	}

	//************************Getters/Setters*************************//

	public Point3D get_p1() {
		return new Point3D(_p1);
	}

	public void set_p1(Point3D _p1) {
		this._p1 = new Point3D(_p1);
	}

	public Point3D get_p2() {
		return new Point3D(_p2);
	}

	public void set_p2(Point3D _p2) {
		this._p2 = new Point3D(_p2);
	}

	public Point3D get_p3() {
		return new Point3D(_p3);
	}

	public void set_p3(Point3D _p3) {
		this._p3 = new Point3D(_p3);
	}
	
	//************************Administration*************************//
	
	//************************Operations*************************//

	public Vector getNormal(Point3D p) {
		Vector v1=new Vector(this._p2.substract(this._p1));
		Vector v2=new Vector(this._p3.substract(this._p1));
		return (v1.crossProduct(v2)).normalize();	

	}

	@Override
	public ArrayList<Point3D> findIntersections(Ray _ray) 
	{
		ArrayList<Point3D> intersections = new ArrayList<Point3D>();
		//Create plane of the triangle//
		Plane plane = new Plane(_p1,new Vector(_p1.substract(_p2)).crossProduct(new Vector(_p1.substract(_p3))));
		ArrayList<Point3D> tmpIntersections = plane.findIntersections(_ray);
		if (tmpIntersections.isEmpty())
			return intersections;
		
		Point3D p = tmpIntersections.get(0);
		Point3D p0 = _ray.get_POO();
		//side 1 of triangle
		Vector v1 = new Vector(_p1.substract(p0));
		Vector v2 = new Vector(_p2.substract(p0));
		Vector n1 = new Vector(v2.crossProduct(v1).normalize());
		//side 2 of triangle
		v1 = new Vector(_p3.substract(p0));
		v2 = new Vector(_p1.substract(p0));
		Vector n2 = new Vector(v2.crossProduct(v1).normalize());
		//side 3 of triangle
		v1 = new Vector(_p2.substract(p0));
		v2 = new Vector(_p3.substract(p0));
		Vector n3 = new Vector(v2.crossProduct(v1).normalize());
		
		//Check if the intersection point inside the triangle//
		if(Math.signum(new Vector(p.substract(p0)).dotProduct(n1))==
				Math.signum(new Vector(p.substract(p0)).dotProduct(n2))
				&&
				Math.signum(new Vector(p.substract(p0)).dotProduct(n3))==
				Math.signum(new Vector(p.substract(p0)).dotProduct(n2))
				&&
				Math.signum(new Vector(p.substract(p0)).dotProduct(n2))!=0)
		{
			intersections.add(p);
		}
		return intersections;
		
	}
	
}
