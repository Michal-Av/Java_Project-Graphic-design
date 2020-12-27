package Geometries;

import java.awt.Color;

import Primitives.Material;

public abstract class RadialGeometry extends Geometry {
	protected double _radius;

	//************************Constructors*************************//
	
	public RadialGeometry() {
		super();
		this._radius = 0;
	}
	
	public RadialGeometry(double _radius) {
		super();
		this._radius = _radius;
	}
	
	public RadialGeometry(Color c , double _radius) {
		super(c);
		this._radius = _radius;
	}
	
	public RadialGeometry(Color c , Material m, double _radius) {
		super(c, m);
		this._radius = _radius;
	}


	//************************Getters/Setters*************************//
	
	public double get_radius() {
		return _radius;
	}

	public void set_radius(double _radius) {
		this._radius = _radius;
	}
	
	//************************Administration*************************//
	
	//************************Operations*************************//	

}
