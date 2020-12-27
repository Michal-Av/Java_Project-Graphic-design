package Elements;

import java.awt.Color;

import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;

public class SpotLight extends PointLight 
{

	private Vector _direction;
	
	//************************Constructors*************************//

	public SpotLight() {
		super();
		this._direction = new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(1)));
	}
	
	public SpotLight(Color _color, Point3D _position, double _Kc, double _Kl, double _Kq, Vector _direction) {
		super(_color, _position, _Kc, _Kl, _Kq);
		this._direction = new Vector(_direction);
	}

	public SpotLight(int _r, int _g, int _b, Point3D _position, double _Kc, double _Kl, double _Kq, Vector _direction) {
		super(_r, _g, _b, _position, _Kc, _Kl, _Kq);
		this._direction = new Vector(_direction);
	}

	public SpotLight(SpotLight _spotLight) {
		super(_spotLight.get_color(), _spotLight.get_position(),_spotLight.get_Kc(),_spotLight.get_Kl(),_spotLight.get_Kq());
		this._direction = new Vector(_spotLight._direction);
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
		SpotLight other = (SpotLight) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SpotLight [_direction=" + _direction + "]" + super.toString();
	}
	
	//************************Operations*****************************//
	
	@Override
	public Color getIntensity(Point3D point) 
	{
		//Il = I0(D*L)/(kc+kl*d+kq*d^2) --> (D*L) is cross product
		Vector l = this.getL(point);
		Vector D = (new Vector(this._direction)).normalize();
		double d = point.distance(_position);
		double k = this.kc + this.kl*d + this.kq*Math.pow(d, 2);
		if (k<1) k=1;
		double k1 = Math.abs(D.dotProduct(l));
		if(k1>1) k1=1;
		k= k1/k;
		int red = (int)(get_color().getRed()*k);
		int green=(int)(get_color().getGreen()*k);
		int blue=(int)(get_color().getBlue()*k);
		if(red>255) red=255;
		if(green>255) green=255;
		if(blue>255) blue=255;

		Color c = new Color(red, green, blue);
		return c;
	}

	

}
