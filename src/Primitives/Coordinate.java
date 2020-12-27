package Primitives;

public class Coordinate {

	double _coordinate;
	
	//*************** Constractor ****************//
	public Coordinate() {
		super();
		this._coordinate =0;
	}
		
	public Coordinate(double _coordinate) {
		super();
		this._coordinate = _coordinate;
	}
	
	public Coordinate (Coordinate c) {
		super();
		this._coordinate = c._coordinate;
	}

	//*************** Getters/Setters ****************//
	public double get_coordinate() {
		return _coordinate;
	}

	public void set_coordinate(double _coordinate) {
		this._coordinate = _coordinate;
	}
	
	//*************** Administration ****************//
	public boolean equals(Coordinate c) {
		// TODO Auto-generated method stub
		return (this._coordinate==c._coordinate);
	}
	
	@Override
	public String toString() {
		return Double.toString(_coordinate);
	}
	
	//*************** Operations ****************//
	public void add (Coordinate c)
	{
		this._coordinate+=c._coordinate;
	}
	
	public void substract (Coordinate c)
	{
		this._coordinate-=c._coordinate;
	}
}
