package Elements;

import java.awt.Color;

import Primitives.*;

public class DirectionalLight extends Light 
{
	protected Vector _direction;

	//************************Constructors*************************//

	public DirectionalLight() {
		super();
		this._direction=new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(1)));
	}
	
	public DirectionalLight(Color _color, Vector _direction) {
		super(_color);
		this._direction = new Vector(_direction);
	}

	public DirectionalLight(int _r, int _g, int _b, Vector _direction) {
		super(_r, _g, _b);
		this._direction = new Vector(_direction);
	}
	
	public DirectionalLight(DirectionalLight _directionalLight){
		super(_directionalLight.get_color());
		this._direction=new Vector(_directionalLight._direction);
	}		
		
	//************************Getters/Setters*************************//
	
	
	public Vector get_direction() {
		return new Vector(_direction);
	}

	public void set_direction(Vector _direction) {
		this._direction = new Vector(_direction);
	}

	//************************Administration*************************//
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectionalLight other = (DirectionalLight) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DirectionalLight [_direction=" + _direction + "]";
	}

	//************************Operations*****************************//
		
	@Override
	public Color getIntensity(Point3D point) 
	{
		return new Color(this.get_color().getRGB());
	}

	@Override
	public Vector getL(Point3D point) 
	{
		return new Vector(this._direction).normalize();

	}
		
		
}
