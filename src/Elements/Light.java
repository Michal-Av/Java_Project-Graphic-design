package Elements;
import java.awt.Color;

import Primitives.*;

public abstract class Light {
	private Color _color;
	
	//************************Constructors*************************//
	
	public Light() {
		super();
		this._color = new Color(255, 255, 255);
	}
	
	public Light(int _r, int _g, int _b) {
		this._color = new Color(_r, _g, _b);
	}
	
	public Light(Color _color) {
		super();
		this._color = new Color(_color.getRGB());
	}
	
	public Light(Light _Light) {
		super();
		this._color = new Color(_Light._color.getRGB());
	}

	
	//************************Getters/Setters*************************//
	
	public Color get_color() {
		return new Color(_color.getRGB());
	}

	public void set_color(Color _color) {
		this._color = new Color(_color.getRGB());
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
		Light other = (Light) obj;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[color=" + _color + "]";
	}
	
	//************************Operations*****************************//

	abstract public Color getIntensity(Point3D point);
	abstract public Vector getL(Point3D point);
		
		
		
}
