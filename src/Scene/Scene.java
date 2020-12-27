package Scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import Geometries.*;
import Elements.*;

public class Scene 
{
	private String _sceneName;
	private Color _background;
	private AmbientLight _ambientLight;
	private ArrayList<Geometry> _geometries;
	private ArrayList<Light> _lights;
	private Camera _camera;
	private double _screenDistance;
	
	
	//************************Constructors*************************//
	
	public Scene() {
		super();
		this._sceneName = new String();
		this._background = new Color(0,0,0);
		this._ambientLight=new AmbientLight();
		this._camera = new Camera();
		this._screenDistance = 150;
		this._geometries = new ArrayList<Geometry>();
		this._lights = new ArrayList<Light>();
	}
	
	public Scene(String _sceneName, Color _background , AmbientLight _ambientLight, Camera _camera,
			double _screenDistance) {
		super();
		this._sceneName = new String(_sceneName);
		this._background = _background;
		this._ambientLight = new AmbientLight(_ambientLight);
		this._camera = new Camera(_camera);
		this._screenDistance = _screenDistance;
		this._geometries = new ArrayList<Geometry>();
		this._lights = new ArrayList<Light>();
	}
	
	public Scene(Scene _scene) {
		super();
		this._sceneName = new String(_scene._sceneName);
		this._background =_scene._background;
		this._ambientLight = new AmbientLight(_scene._ambientLight);
		this._camera = new Camera(_scene._camera);
		this._screenDistance = _scene._screenDistance;
		this._geometries = new ArrayList<Geometry>(_scene._geometries);
		this._lights = new ArrayList<Light>(_scene._lights);
	}
	
	//************************Getters/Setters*************************//

	public String get_sceneName() {
		return new String(_sceneName);
	}

	public void set_sceneName(String _sceneName) {
		this._sceneName = new String(_sceneName);
	}

	public Color get_background() {
		return _background;
	}

	public void set_background(Color _background) {
		this._background = _background;
	}
	
	public AmbientLight get_ambientLight() {
		return new AmbientLight(_ambientLight);
	}

	public void set_ambientLight(AmbientLight _ambientLight) {
		this._ambientLight = new AmbientLight(_ambientLight);
	}

	public ArrayList<Geometry> get_geometries() {
		return new ArrayList<Geometry>(_geometries);
	}

	public void set_geometries(ArrayList<Geometry> _geometries) {
		this._geometries = new ArrayList<Geometry>(_geometries);
	}

	public Camera get_camera() {
		return new Camera(_camera);
	}

	public void set_camera(Camera _camera) {
		this._camera = new Camera(_camera);
	}

	public double get_screenDistance() {
		return _screenDistance;
	}

	public void set_screenDistance(double _screenDistance) {
		this._screenDistance = _screenDistance;
	}
	
	public ArrayList<Light> get_lights() {
		return new ArrayList<Light>(this._lights);
	}

	public void set_lights(ArrayList<Light> _lights) {
		this._lights = new ArrayList<Light>(_lights);
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
		Scene other = (Scene) obj;
		if (_ambientLight == null) {
			if (other._ambientLight != null)
				return false;
		} else if (!_ambientLight.equals(other._ambientLight))
			return false;
		if (_background == null) {
			if (other._background != null)
				return false;
		} else if (!_background.equals(other._background))
			return false;
		if (_camera == null) {
			if (other._camera != null)
				return false;
		} else if (!_camera.equals(other._camera))
			return false;
		if (_geometries == null) {
			if (other._geometries != null)
				return false;
		} else if (!_geometries.equals(other._geometries))
			return false;
		if (_lights == null) {
			if (other._lights != null)
				return false;
		} else if (!_lights.equals(other._lights))
			return false;
		if (_sceneName == null) {
			if (other._sceneName != null)
				return false;
		} else if (!_sceneName.equals(other._sceneName))
			return false;
		if (Double.doubleToLongBits(_screenDistance) != Double.doubleToLongBits(other._screenDistance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Scene [_sceneName=" + _sceneName + ", _background=" + _background + ", _ambientLight=" + _ambientLight
				+ ", _geometries=" + _geometries + ", _lights=" + _lights + ", _camera=" + _camera
				+ ", _screenDistance=" + _screenDistance + "]";
	}

	//************************Operations*************************//
	
	public void addGeometry(Geometry _geometry)
	{
		_geometries.add(_geometry);
	}

	public Iterator<Geometry> getGeometriesIterator()
	{
		return _geometries.iterator();
	}
	
	public void addLight(Light l)
	{
		_lights.add(l);
	}
	
	public Iterator<Light> getLightsIterator()
	{
		return _lights.iterator();
	}

}
