package Geometries;
import java.util.ArrayList;

import Primitives.*;

public class Cylinder extends RadialGeometry{
	private Point3D _axisPoint;
	private Vector _axisDirection;
	
	//************************Constructors*************************//
	
	public Cylinder() {
		super();
		this._axisPoint = new Point3D();
		this._axisDirection = new Vector();
	}
	
	public Cylinder(double _radius, Point3D _axisPoint, Vector _axisDirection) {
		super(_radius);
		this._axisPoint = _axisPoint;
		this._axisDirection = _axisDirection;
	}
	

	
	//************************Getters/Setters*************************//

	public Point3D get_axisPoint() {
		return _axisPoint;
	}

	public void set_axisPoint(Point3D _axisPoint) {
		this._axisPoint = _axisPoint;
	}

	public Vector get_axisDirection() {
		return _axisDirection;
	}

	public void set_axisDirection(Vector _axisDirection) {
		this._axisDirection = _axisDirection;
	}
	
	//************************Administration*************************//
	
	//************************Operations*************************//

	
	public Vector getNormal(Point3D p) {
		return null;
	}

	@Override
	public ArrayList<Point3D> findIntersections(Ray _ray) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}