package Primitives;
import java.lang.Math;

public class Point3D extends Point2D {
	
	Coordinate _z;
	
	//*************** Constractor ****************//
	public Point3D() {
		super();
		this._z =new Coordinate();
	}
	
	public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
		super(_x, _y);
		this._z = new Coordinate(_z);
	}
	
	public Point3D(int x, int y, int z)
	{
		super(new Coordinate(x),new Coordinate(y));
		this._z = new Coordinate(z);
	}
	
	public Point3D(double x, double y, double z)
	{
		super(new Coordinate(x),new Coordinate(y));
		this._z = new Coordinate(z);
	}
	
	public Point3D(Point3D p) {
		this._x = new Coordinate(p._x);
		this._y = new Coordinate(p._y);
		this._z = new Coordinate(p._z);
	}
	
	//*************** Getters/Setters ****************//

	public Coordinate get_z() {
		return _z;
	}

	public void set_z(Coordinate _z) {
		this._z = _z;
	}

	//*************** Administration ****************//
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (_z == null) {
			if (other._z != null)
				return false;
		} else if (!_z.equals(other._z))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" +get_x()+", "+get_y() +", "+ _z + ")";
	}
	//*************** Operations ****************//
	public void add(Vector v) {
		this._x.add(new Coordinate(v.get_head().get_x()));
		this._y.add(new Coordinate(v.get_head().get_y()));
		this._z.add(new Coordinate(v.get_head().get_z()));
	}
	
	public void add(Point3D p) {
		this._x.add(new Coordinate(p.get_x()));
		this._y.add(new Coordinate(p.get_y()));
		this._z.add(new Coordinate(p.get_z()));
	}

	public void substract(Vector v) {	
		this._x.substract(new Coordinate(v.get_head().get_x()));
		this._y.substract(new Coordinate(v.get_head().get_y()));
		this._z.substract(new Coordinate(v.get_head().get_z()));
	}
	
	public Point3D add(Vector v, int r) {
		Point3D tmp = new Point3D(this);
		tmp._x.add(new Coordinate(v.get_head().get_x()));
		tmp._y.add(new Coordinate(v.get_head().get_y()));
		tmp._z.add(new Coordinate(v.get_head().get_z()));
		return tmp;	
	}
	
	public Point3D substract(Point3D p) {
		Point3D tmp = new Point3D(this);
		tmp._x.substract(p._x);
		tmp._y.substract(p._y);
		tmp._z.substract(p._z);
		return tmp;	
	}
	/**
	 * 
	 * @param p
	 * @return
	 */
	public double distance (Point3D p)
	{
		Point3D tmp = new Point3D(this);
		tmp._x.substract(p._x);
		tmp._y.substract(p._y);
		tmp._z.substract(p._z);
		return Math.sqrt(Math.pow(tmp._x.get_coordinate(),2.0)+
				   Math.pow(tmp._y.get_coordinate(),2)+
				   Math.pow(tmp._z.get_coordinate(),2));
	}
}
