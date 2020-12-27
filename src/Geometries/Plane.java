package Geometries;
import java.awt.Color;
import java.util.ArrayList;

import Primitives.*;

public class Plane extends Geometry implements FlatGeometry{
	private Point3D _Q;
	private Vector _N;

	//************************Constructors*************************//
	
	public Plane() {
		super();
		this._Q = new Point3D();
		this._N = new Vector();
	}

	public Plane(Point3D _Q, Vector _N) {
		super();
		this._Q = new Point3D(_Q);
		this._N = new Vector(_N);
	}
	
	public Plane(Color c, Point3D _Q, Vector _N) {
		super();
		this._Q = new Point3D(_Q);
		this._N = new Vector(_N);
		_emmision = new Color(c.getRGB());
	}
	
	public Plane(Color c, Material m, Point3D _Q, Vector _N) 
	{
		super(new Color(c.getRGB()), new Material(m));
		this._Q = new Point3D(_Q);
		this._N = new Vector(_N);
	}
	
	public Plane(Plane p) {
		super(new Color(p._emmision.getRGB()), new Material(p._material));
		this._Q = new Point3D(p._Q);
		this._N = new Vector(p._N);
		_emmision = new Color(p._emmision.getRGB());
	}


	//************************Getters/Setters*************************//
	
	public Point3D get_Q() {
		return new Point3D(this._Q);
	}

	public void set_Q(Point3D _Q) {
		this._Q = new Point3D(this._Q);
	}

	public Vector get_N() {
		return new Vector(_N);
	}

	public void set_N(Vector _N) {
		this._N = new Vector(_N);
	}
	
	//************************Administration*************************//
	
	//************************Operations*************************//
 
	public Vector getNormal(Point3D p) {
		return _N.normalize();
	}

	@Override
	public ArrayList<Point3D> findIntersections(Ray _ray) 
	{
		ArrayList<Point3D> intersections = new ArrayList<Point3D>();
		Point3D p0 = new Point3D(_ray.get_POO());
		Vector v = new Vector(_ray.get_direction().normalize());
		Vector n = new Vector(this._N);
		
		n.scale(-1);
		if (this._N.dotProduct(v)==0) //divide by 0
			return intersections;
		
		double t = n.dotProduct(new Vector(p0.substract(this._Q)))/(this._N.dotProduct(v));
		if(t>0)
		{
			Vector v1 = new Vector(v);
			v1.scale(t);
			Point3D p = new Point3D(p0.add(v1, 0));
			intersections.add(p);
		}
		return intersections;
	}

}
