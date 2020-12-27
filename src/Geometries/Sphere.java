package Geometries;
import java.awt.Color;
import java.util.ArrayList;

import Primitives.*;

public class Sphere extends RadialGeometry{
	private Point3D _center;
	
	//************************Constructors*************************//
	
	public Sphere() {
		super();
		this._center = new Point3D();
	}
	
	public Sphere(double _radius, Point3D _center) {
		super(_radius);
		this._center = new Point3D(_center);
	}
	
	public Sphere(Color c, double _radius, Point3D _center)
	{
		super(new Color(c.getRGB()),_radius);
		this._center = new Point3D(_center);
	}
	
	public Sphere(Color c, Material m, double _radius, Point3D _center)
	{
		super(new Color(c.getRGB()), new Material(m), _radius);
		this._center = new Point3D(_center);
	}
	
	public Sphere(Sphere s)
	{
		super(new Color(s._emmision.getRGB()),new Material(s._material), s._radius);
		this._center = new Point3D(s._center);
	}

	//************************Getters/Setters*************************//
	
	public Point3D get_center() {
		return _center;
	}

	public void set_center(Point3D _center) {
		this._center = _center;
	}

	//************************Administration*************************//
	
	//************************Operations*************************//
	
	public Vector getNormal(Point3D p) {
		Vector v=new Vector(p.substract(_center));
		return v.normalize();
	}

	@Override
	public ArrayList<Point3D> findIntersections(Ray _ray) {
		ArrayList<Point3D> intersections = new ArrayList<Point3D>();
		Point3D p0 = new Point3D(_ray.get_POO());
		Vector v = new Vector(_ray.get_direction().normalize());
		
		Vector l = new Vector(this._center.substract(p0));
		double tm = v.dotProduct(l);
		double d = Math.pow(Math.pow(l.length(), 2)- Math.pow(tm, 2),0.5);
		
		if (d<this._radius)
		{
			double th = Math.pow(Math.pow(this._radius, 2)- Math.pow(d, 2),0.5);
			double t1 = tm-th;
			double t2 = tm+th;
			
			Vector v1 = new Vector(v);
			v1.scale(t1);
			Vector v2 = new Vector(v);
			v2.scale(t2);
			
			Point3D p1 = new Point3D(p0.add(v1,0));
			Point3D p2 = new Point3D(p0.add(v2,0));
			if (t1>0)
				intersections.add(p1);
			if(t2>0)
				intersections.add(p2);
		}
		return intersections;
	}

}
