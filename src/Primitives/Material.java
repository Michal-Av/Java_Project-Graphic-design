package Primitives;

public class Material {
	private double _Kd, _Ks, _Kr, _Kt;
	private int _nShininess;
	
	//************************Constructors*************************//
	
	public Material() {
		super();
		this._Kd = 0.75;
		this._Ks = 1;
		this._Kr = 0;
		this._Kt = 0;
		this._nShininess = 1;
	}
	
	public Material(double _Kd, double _Ks, int _nShininess,double _Kr,double _Kt) {
		super();
		this._Kd = _Kd;
		this._Ks = _Ks;
		this._Kr = _Kr;
		this._Kt = _Kt;
		this._nShininess = _nShininess;
	}
	
	public Material(Material _material) {
		super();
		this._Kd = _material._Kd;
		this._Ks = _material._Ks;
		this._Kr = _material._Kr;
		this._Kt = _material._Kt;
		this._nShininess = _material._nShininess;
	}
	
	//************************Getters/Setters*************************//

	public double get_Kd() {
		return _Kd;
	}

	public void set_Kd(double _Kd) {
		this._Kd = _Kd;
	}

	public double get_Kr() {
		return _Kr;
	}

	public void set_Kr(double _Kr) {
		this._Kr = _Kr;
	}
	
	public double get_Kt() {
		return _Kt;
	}

	public void set_Kt(double _Kt) {
		this._Kt = _Kt;
	}
	
	public double get_Ks() {
		return _Ks;
	}

	public void set_Ks(double _Ks) {
		this._Ks = _Ks;
	}

	public int get_nShininess() {
		return _nShininess;
	}

	public void set_nShininess(int _nShininess) {
		this._nShininess = _nShininess;
	}

	
	//************************Administration*************************//


	@Override
	public String toString() {
		return "Material [_Kd=" + _Kd + ", _Ks=" + _Ks + ", _Kr=" + _Kr + ", _Kt=" + _Kt + ", _nShininess="
				+ _nShininess + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (Double.doubleToLongBits(_Kd) != Double.doubleToLongBits(other._Kd))
			return false;
		if (Double.doubleToLongBits(_Kr) != Double.doubleToLongBits(other._Kr))
			return false;
		if (Double.doubleToLongBits(_Ks) != Double.doubleToLongBits(other._Ks))
			return false;
		if (Double.doubleToLongBits(_Kt) != Double.doubleToLongBits(other._Kt))
			return false;
		if (_nShininess != other._nShininess)
			return false;
		return true;
	}
	
	
	
	

	
	
}
