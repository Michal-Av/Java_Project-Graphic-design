package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public class PointLight extends Light
{
	Point3D _position;
	double kc, kl, kq;
	
	//************************Constructors*************************//
	
	public PointLight() 
	{
		super();
		this._position = new Point3D();
		this.kc = 0.01;
		this.kl = 0.01;
		this.kq = 0.01;
	}

	public PointLight(Color _color, Point3D _position, double _Kc, double _Kl, double _Kq) {
		super(_color);
		this._position = new Point3D(_position);
		this.kc = _Kc;
		this.kl = _Kl;
		this.kq = _Kq;
	}

	public PointLight(int _r, int _g, int _b, Point3D _position, double _Kc, double _Kl, double _Kq) {
		super(_r, _g, _b);
		this._position = new Point3D(_position);
		this.kc = _Kc;
		this.kl = _Kl;
		this.kq = _Kq;
	}
	
	public PointLight(PointLight _pointLight) {
		super(_pointLight.get_color());
		this._position = new Point3D(_pointLight._position);
		this.kc = _pointLight.kc;
		this.kl = _pointLight.kl;
		this.kq = _pointLight.kq;
	}
	
	//************************Getters/Setters*************************//
	
	public Point3D get_position() {
		return new Point3D(_position);
	}

	public void set_position(Point3D _position) {
		this._position = new Point3D(_position);
	}

	public double get_Kc() {
		return kc;
	}

	public void set_Kc(double _Kc) {
		this.kc = _Kc;
	}

	public double get_Kl() {
		return kl;
	}

	public void set_Kl(double _Kl) {
		this.kl = _Kl;
	}

	public double get_Kq() {
		return kq;
	}

	public void set_Kq(double _Kq) {
		this.kq = _Kq;
	}
	
	//************************Administration*************************//
	
	@Override
	public String toString() {
		return "PointLight [_position=" + _position + ", kc=" + kc + ", kl=" + kl + ", kq=" + kq + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointLight other = (PointLight) obj;
		if (_position == null) {
			if (other._position != null)
				return false;
		} else if (!_position.equals(other._position))
			return false;
		if (Double.doubleToLongBits(kc) != Double.doubleToLongBits(other.kc))
			return false;
		if (Double.doubleToLongBits(kl) != Double.doubleToLongBits(other.kl))
			return false;
		if (Double.doubleToLongBits(kq) != Double.doubleToLongBits(other.kq))
			return false;
		return true;
	}
	
	//************************Operations*****************************//


	@Override
	public Color getIntensity(Point3D point) 
	{
		//Il = I0/(kc+kl*d+kq*d^2)
		double d = point.distance(_position);
		double k = this.kc + this.kl*d + this.kq*Math.pow(d, 2);
		if (k<=1) k=1;
		int red = (int)(get_color().getRed()/k);
		int green=(int)(get_color().getGreen()/k);
		int blue=(int)(get_color().getBlue()/k);
		if(red>255) red=255;
		if(green>255) green=255;
		if(blue>255) blue=255;

		Color c = new Color(red, green, blue);
		return c;
	}

	@Override
	public Vector getL(Point3D point) 
	{
		return (new Vector(this._position,point)).normalize();
	}
	

}
