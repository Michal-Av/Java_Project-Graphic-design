package Primitives;


public class Point2D {

	Coordinate _x;
	Coordinate _y;
	
	//*************** Constractor ****************//
	public Point2D() {
		super();
		this._x = new Coordinate();
		this._y = new Coordinate();
	}
	
	public Point2D(Coordinate _x, Coordinate _y) {
		super();
		this._x = new Coordinate(_x);
		this._y = new Coordinate(_y);
	}
	
	public Point2D(Point2D p) {
		super();
		this._x = new Coordinate(p._x);
		this._y = new Coordinate(p._y);
	}

	
	//*************** Getters/Setters ****************//
	public Coordinate get_x() {
		return _x;
	}

	public Coordinate get_y() {
		return _y;
	}

	public void set_x(Coordinate _x) {
		this._x = _x;
	}

	public void set_y(Coordinate _y) {
		this._y = _y;
	}

	//*************** Administration ****************//
	@Override
	public String toString() {
		return "("+ _x + ", " + _y + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (_x == null) {
			if (other._x != null)
				return false;
		} else if (!_x.equals(other._x))
			return false;
		if (_y == null) {
			if (other._y != null)
				return false;
		} else if (!_y.equals(other._y))
			return false;
		return true;
	}
	
	
	
	
}
