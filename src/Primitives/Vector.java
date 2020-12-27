package Primitives;

public class Vector {

	Point3D _head;
	//*************** Constractor ****************//

	public Vector() {
		super();
		this._head = new Point3D();
	}
	
	public Vector(Point3D _head) {
		super();
		this._head = new Point3D(_head);
		
	}
	
	public Vector(Vector v) {
		super();
		this._head = new Point3D(v._head);
	}
	
	public Vector(Point3D p1, Point3D p2)
	{
		super();
		this._head = p1.substract(p2);
	}
	
	//*************** Getters/Setters ****************//
	public Point3D get_head() {
		return _head;
	}

	public void set_head(Point3D _head) {
		this._head = _head;
	}
	
	//*************** Administration ****************//
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (_head == null) {
			if (other._head != null)
				return false;
		} else if (!_head.equals(other._head))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return _head.toString();
	}
	//*************** Operations ****************//
	public void add(Vector v){
		this._head.add(v);
	}
	
	public Vector addV(Vector v){
		Point3D p = new Point3D(this._head);
		p.add(v);
		return new Vector(new Point3D(p));
	}
	
	public Vector substractV(Vector v){
		Point3D p = new Point3D(this._head);
		p.substract(v);
		return new Vector(new Point3D(p));
	}
	
	public void substract(Vector v){
		this._head.substract(v);
	}
	
	public void scale(double scalingFactor){
		this._head.set_x(new Coordinate(this._head.get_x().get_coordinate()*scalingFactor));
		this._head.set_y(new Coordinate(this._head.get_y().get_coordinate()*scalingFactor));
		this._head.set_z(new Coordinate(this._head.get_z().get_coordinate()*scalingFactor));
	}
	
	public Vector scaling(double scalingFactor){
		Point3D p = new Point3D(this._head);
		p._x.set_coordinate(p.get_x().get_coordinate()*scalingFactor);
		p._y.set_coordinate(p.get_y().get_coordinate()*scalingFactor);
		p._z.set_coordinate(p.get_z().get_coordinate()*scalingFactor);
		return new Vector(p);
	}
	
	public double dotProduct(Vector v)
	{
		return this._head.get_x().get_coordinate()*v._head.get_x().get_coordinate()+
				this._head.get_y().get_coordinate()*v._head.get_y().get_coordinate()+
				this._head.get_z().get_coordinate()*v._head.get_z().get_coordinate();				
	}
	
	public Vector crossProduct(Vector v)
	{
		Vector tmp = new Vector();
		tmp._head._x.set_coordinate(this._head._y._coordinate*v._head._z._coordinate- this._head._z._coordinate*v._head._y._coordinate);
		tmp._head._y.set_coordinate((-1)*(this._head._x._coordinate*v._head._z._coordinate- this._head._z._coordinate*v._head._x._coordinate));
		tmp._head._z.set_coordinate(this._head._x._coordinate*v._head._y._coordinate- this._head._y._coordinate*v._head._x._coordinate);
		if (tmp._head._x._coordinate==(-0)) tmp._head._x._coordinate=0;
		if (tmp._head._y._coordinate==(-0)) tmp._head._y._coordinate=0;
		if (tmp._head._z._coordinate==(-0)) tmp._head._z._coordinate=0;
		return tmp;
	}
		
	public double length()
	{
		return Math.sqrt(Math.pow(this._head.get_x().get_coordinate(), 2)+
				Math.pow(this._head.get_y().get_coordinate(), 2)+
				Math.pow(this._head.get_z().get_coordinate(), 2));
	}
	
	public Vector normalize(){
		double length=this.length();
		return new Vector(new Point3D(new Coordinate(this._head.get_x().get_coordinate()/length),
				new Coordinate(this._head.get_y().get_coordinate()/length),
				new Coordinate(this._head.get_z().get_coordinate()/length)));
	}
	
}
