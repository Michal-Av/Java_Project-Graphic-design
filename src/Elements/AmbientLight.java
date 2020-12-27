package Elements;
import java.awt.Color;
import Primitives.Point3D;

public class AmbientLight {

	Color _color;
	private double _ka;
	

	//************************Constructors*************************//
	
	public AmbientLight() { //default ctor
		super();
		this._ka = 0.1;
		this._color = Color.WHITE;
	}
	
	public AmbientLight(Color _c, double ka) {
		super();
		this._ka = ka;
		this._color = new Color(_c.getRGB());
	}
	
	public AmbientLight(int _r, int _g, int _b) {
		super();
		this._color = new Color(_r, _g, _b);
		this._ka = 1.0;
	}
	
	public AmbientLight(AmbientLight _ambientLight) {
		super();
		this._ka = _ambientLight._ka;
		this._color= new Color(_ambientLight._color.getRGB());
	}


	//************************Getters/Setters*************************//

	public double get_ka() {
		return _ka;
	}

	public void set_ka(double _ka) {
		this._ka = _ka;
	}

	public Color get_color() {
		return new Color(_color.getRGB());
	}

	public void set_color(Color _color) {
		this._color = new Color(_color.getRGB());
	}
	
	//************************Administration*************************//
	

	@Override
	public String toString() {
		return "AmbientLight [_color=" + _color + ", _ka=" + _ka + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmbientLight other = (AmbientLight) obj;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		if (Double.doubleToLongBits(_ka) != Double.doubleToLongBits(other._ka))
			return false;
		return true;
	}


	//************************Operations*****************************//
	
	public Color getIntensity(Point3D p)
	{
		int tmpR=(int) (get_color().getRed()*_ka);
		int tmpG=(int) (get_color().getGreen()*_ka);
		int tmpB=(int) (get_color().getBlue()*_ka);
		return new Color(tmpR,tmpG,tmpB);
	}



}
