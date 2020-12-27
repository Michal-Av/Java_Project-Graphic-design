package Geometries;
import Primitives.*;
import java.awt.Color;
import java.util.ArrayList;

public abstract class Geometry {
	
	Color _emmision;
	Material _material;
	//************************Constructors*************************//
	public Geometry() {
		super();
		this._emmision = new Color(0,0,0);
		_material=new Material();
	}
	
	public Geometry(Color _color) {
		super();
		this._emmision = new Color(_color.getRGB());
		_material=new Material();
	}
	
	public Geometry(Geometry _geometry) {
		super();
		this._emmision = new Color(_geometry._emmision.getRGB());
		_material=new Material(_geometry._material);
	}
	
	
	public Geometry(Color _emmission, Material _material) {
		super();
		this._emmision = new Color(_emmission.getRGB());
		this._material = new Material(_material);
	}

	//************************Getters/Setters*************************//

	public Color get_emmission() {
		return new Color(_emmision.getRGB());
	}

	public void set_emmission(Color _color) {
		this._emmision = new Color(_color.getRGB());
	}
	
	public Material get_material() {
		return new Material(_material);
	}

	public void set_material(Material _material) {
		this._material = new Material(_material);
	}
	

	
	//************************Administration*************************//

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Geometry other = (Geometry) obj;
		if (_emmision == null) {
			if (other._emmision != null)
				return false;
		} else if (!_emmision.equals(other._emmision))
			return false;
		if (_material == null) {
			if (other._material != null)
				return false;
		} else if (!_material.equals(other._material))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Geometry [_emmision=" + _emmision + ", _material=" + _material + "]";
	}

	
	//************************Operations*************************//
	

	public abstract Vector getNormal(Point3D my_point);
	
	public abstract ArrayList<Point3D> findIntersections(Ray _ray);
	

}