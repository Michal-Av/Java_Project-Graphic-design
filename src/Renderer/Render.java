package Renderer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Elements.*;
import Geometries.*;
import Primitives.*;
import Scene.Scene;

public class Render 
{
	private Scene _scene;
	private ImageWriter _imageWriter;
	public static int RECURSION_LEVEL = 4;
	
	//************************Constructors*************************//
	
	public Render(Scene _scene, ImageWriter _imageWriter) {
		super();
		this._scene = new Scene(_scene);
		this._imageWriter = _imageWriter;
	}
	
	//************************Getters/Setters*************************//

	public Scene get_scene() {
		return new Scene(_scene);
	}

	public void set_scene(Scene _scene) {
		this._scene = new Scene(_scene);
	}

	public ImageWriter get_imageWriter() {
		return _imageWriter;
	}

	public void set_imageWriter(ImageWriter _imageWriter) {
		this._imageWriter = new ImageWriter(_imageWriter);
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
		Render other = (Render) obj;
		if (_imageWriter == null) {
			if (other._imageWriter != null)
				return false;
		} else if (!_imageWriter.equals(other._imageWriter))
			return false;
		if (_scene == null) {
			if (other._scene != null)
				return false;
		} else if (!_scene.equals(other._scene))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Render [scene=" + _scene + ", imageWriter=" + _imageWriter + "]";
	}
	
	//************************Operations*************************//
	
	
	public void printGrid(int interval)
	{
		for(int i=0; i<_imageWriter.getHeight(); i++)
		{
			for(int j=0; j<_imageWriter.getWidth(); j++)
			{
				if(i % interval == 0 || j % interval == 0)
					_imageWriter.writePixel(j, i, 255, 255, 255);
			}
		}	
	}

////the old function
//	public void renderImage()
//	{
//		for(int i=0; i<this._imageWriter.getNy(); i++)
//		{
//			for(int j=0; j<this._imageWriter.getNx(); j++)
//			{
//				Ray ray= _scene.get_camera().constructRayThroughPixel
//						(_imageWriter.getNx(), _imageWriter.getNy(), j, i, _scene.get_screenDistance(),
//								_imageWriter.getWidth(), _imageWriter.getHeight());
//				Map<Geometry,ArrayList<Point3D>> intersectionPoints= getSceneRayIntersections(ray);
//				if(intersectionPoints.isEmpty())
//					_imageWriter.writePixel(j, i, _scene.get_background());
//				else
//				{
//					Map<Geometry,Point3D> closestPoint= getClosestPoint(intersectionPoints);
//					for(Entry<Geometry,Point3D> e: closestPoint.entrySet())
//						_imageWriter.writePixel(j, i, calcColor(e.getKey(), e.getValue(), ray));
//				}
//			}
//		}
//	}
	
	public void renderImage()
	{
		for(int i=0; i<this._imageWriter.getNy(); i++)
		{
			for(int j=0; j<this._imageWriter.getNx(); j++)
			{
				ArrayList<Color> colors = new ArrayList<Color>();
				ArrayList<Ray> rays= _scene.get_camera().constructRaysThroughPixel
						(_imageWriter.getNx(), _imageWriter.getNy(), j, i, _scene.get_screenDistance(),
								_imageWriter.getWidth(), _imageWriter.getHeight());
				for(Ray ray: rays)
				{
					Map<Geometry,ArrayList<Point3D>> intersectionPoints= getSceneRayIntersections(ray);
					if(intersectionPoints.isEmpty())
						colors.add( _scene.get_background());
					else
					{
						Map<Geometry,Point3D> closestPoint= getClosestPoint(intersectionPoints);
						for(Entry<Geometry,Point3D> e: closestPoint.entrySet())
							colors.add(calcColor(e.getKey(), e.getValue(), ray));
					}
				}
				int red = 0, green = 0, blue = 0;
				for(Color color : colors)
				{
					red += color.getRed();
					green += color.getGreen();
					blue += color.getBlue();
				}
				red /= colors.size();
				blue /= colors.size();
				green /= colors.size();
				if(red>255) red=255;
				if(green>255) green=255;
				if(blue>255) blue=255;
				_imageWriter.writePixel(j, i, new Color (red, green, blue));
			}
				
		}
	}
	

	private Color calcColor(Geometry geometry, Point3D point, Ray inRay)
	{
		return calcColor(geometry, point, inRay, 0);
	}
	
	private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level)
	{
		if(level==RECURSION_LEVEL) return new Color(0,0,0);
		
		Color ambientLight = _scene.get_ambientLight().getIntensity(point);
		Color emissionLight =geometry.get_emmission();
		Color diffuseLight = new Color(0,0,0);
		Color specularLight = new Color(0,0,0);
		Iterator<Light> lights = this._scene.getLightsIterator();
		
		while(lights.hasNext())
		{
			Light light = lights.next();
			if (!occluded(light,point,geometry) && light.getL(point).dotProduct(geometry.getNormal(point))>0)// if no shadow
			{
				//diffuse light
				Color temp= calcDiffuseComp(geometry.get_material().get_Kd(), geometry.getNormal(point),
						                              light.getL(point), light.getIntensity(point));
				int red = (int)temp.getRed()+diffuseLight.getRed();
				int green = (int)temp.getGreen()+diffuseLight.getGreen();
				int blue = (int)temp.getBlue()+diffuseLight.getBlue();
				if(red>255) red=255;
				if(green>255) green=255;
				if(blue>255) blue=255;
				diffuseLight =  new Color (red, green, blue);
				
				//specular light
				temp = calcSpecularComp(geometry.get_material().get_Ks(),new Vector(point.substract(this._scene.get_camera().get_P0())),
						geometry.getNormal(point), light.getL(point),geometry.get_material().get_nShininess(), light.getIntensity(point));
				red = (int)temp.getRed()+specularLight.getRed();
				green = (int)temp.getGreen()+specularLight.getGreen();
				blue = (int)temp.getBlue()+specularLight.getBlue();
				if(red>255) red=255;
				if(green>255) green=255;
				if(blue>255) blue=255;
				specularLight =  new Color (red, green, blue);
			}
		}
		// Recursive call for a reflected ray
		Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);
		Entry<Geometry,Point3D> reflectedEntry = findClosestIntersection(reflectedRay);
		Color reflectedColor = new Color(0,0,0);
		if(reflectedEntry!=null)
			reflectedColor = calcColor(reflectedEntry.getKey(),reflectedEntry.getValue(),reflectedRay,level+1);
		double Kr = geometry.get_material().get_Kr();
		Color reflectedLight = new Color((int)(Kr*reflectedColor.getRed()),(int)(Kr*reflectedColor.getGreen()),(int)(Kr*reflectedColor.getBlue()));
	
		//recursive call for a refracted ray
		Ray refractedRay = constructRefractedRay(geometry, point, inRay);
		Entry<Geometry,Point3D> refractedEntry = findClosestIntersection(refractedRay);
		Color refractedColor = new Color(0,0,0);
		if(refractedEntry!=null)
			refractedColor = calcColor(refractedEntry.getKey(),refractedEntry.getValue(),refractedRay,level+1);
		double Kt=geometry.get_material().get_Kt();
		Color refractedLight = new Color((int)(Kt*refractedColor.getRed()),(int)(Kt*refractedColor.getGreen()),(int)(Kt*refractedColor.getBlue()));
				
		int red  = ambientLight.getRed()+ emissionLight.getRed()+diffuseLight.getRed()+specularLight.getRed()+reflectedLight.getRed()+refractedLight.getRed();
		int green = ambientLight.getGreen()+ emissionLight.getGreen()+diffuseLight.getGreen()+specularLight.getGreen()+reflectedLight.getGreen()+refractedLight.getGreen();
		int blue = ambientLight.getBlue()+ emissionLight.getBlue()+diffuseLight.getBlue()+specularLight.getBlue()+reflectedLight.getBlue()+refractedLight.getBlue();
		if(red>255) red=255;
		if(green>255) green=255;
		if(blue>255) blue=255;
		return new Color (red, green, blue);
	}
	
	//mirror
	private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay) //R=D-2(D*N)N
	{
		Vector l = new Vector(inRay.get_direction()).normalize();
		double tmp = (l.dotProduct(normal))*(-2);
		normal.scale(tmp);
		l.add(normal);
		Vector r = new Vector(l).normalize();
		point.add(r.get_head());
		Ray reflectedRay = new Ray(point,r);
		return reflectedRay;
	}
	
	private Ray constructRefractedRay(Geometry geometry, Point3D point, Ray inRay) 
	{	
			Vector normal = geometry.getNormal(point);
			normal.normalize();
			normal.scale(-2);
			point.add(inRay.get_direction());

			Ray reflectedRay = new Ray(point,new Vector(inRay.get_direction()));		
			return reflectedRay;
	}
	
	private Entry<Geometry, Point3D> findClosestIntersection(Ray ray)
	{
		Map<Geometry,ArrayList<Point3D>> mapPointsList= getSceneRayIntersections(ray);//list of points
		Map<Geometry,Point3D> mapClosestPoint= getClosestPoint(mapPointsList);//closest point
		Entry<Geometry, Point3D> entry = null;
		for(Entry<Geometry,Point3D> e : mapClosestPoint.entrySet())//set: geometry, closestPoint
			entry = e;
		return entry;
		
	}

	private boolean occluded(Light light, Point3D point, Geometry geometry) 
	{
		Vector lightDirection = light.getL(point);
		//lightDirection.scale(-1);
		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point));
		epsVector.scale(2);
		
		geometryPoint.add(epsVector.get_head());
		Ray lightRay = new Ray(geometryPoint, lightDirection);
		Map<Geometry,ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
		
		//flat geometry cannot self intersect
		if(geometry instanceof FlatGeometry)
		{
			intersectionPoints.remove(geometry);
		}
		
		for (Entry<Geometry, ArrayList<Point3D>> entry : intersectionPoints.entrySet())
			if (entry.getKey().get_material().get_Kt()==0)
				return true;
			return false;
	}

	private Map<Geometry,Point3D> getClosestPoint(Map<Geometry,ArrayList<Point3D>> intersectionPoints) 
	{
		double distance = Double.MAX_VALUE;
		Point3D p0 = _scene.get_camera().get_P0();
		Map<Geometry,Point3D> minDistancePoint = new HashMap<Geometry,Point3D>();
		for(Entry<Geometry, ArrayList<Point3D>> entry: intersectionPoints.entrySet())
		{
			for(Point3D point : entry.getValue())
			{
				if(p0.distance(point)<distance)
				{
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance=p0.distance(point);
				}
			}
		}
		return minDistancePoint;
	}
	
	private Map<Geometry,ArrayList<Point3D>> getSceneRayIntersections(Ray ray) 
	{
		Iterator<Geometry> geometries=_scene.getGeometriesIterator();
		Map<Geometry,ArrayList<Point3D>> intersectionPoints=new HashMap<Geometry,ArrayList<Point3D>>();
		
		while(geometries.hasNext())
		{
			Geometry geometry = geometries.next();
			ArrayList<Point3D> geometryIntersectionPoints=geometry.findIntersections(ray);
			if(!geometryIntersectionPoints.isEmpty())
				intersectionPoints.put(geometry, geometryIntersectionPoints);
		}
		
		return intersectionPoints;	
	}
	
	private Color calcSpecularComp(double ks, Vector v, Vector normal, Vector l, int shininess, Color intensity) 
	{
		
		Vector d = new Vector(l);
		normal.normalize();
		double dotPro = (d.dotProduct(normal))*2; //2(d*n)
		Vector n = new Vector(normal);
		(n).scale(dotPro); //2(d*n)*n
		d.substract(n); //d- 2(d*n)*n = r
		Vector r = new Vector(d);
		r.normalize();
		double k = Math.abs(Math.pow((v.normalize()).dotProduct(r), shininess)*ks) ;
		int red = (int)(intensity.getRed()*k);
		int green = (int)(intensity.getGreen()*k);
		int blue = (int)(intensity.getBlue()*k);
		if(red>255) red=255;
		if(green>255) green=255;
		if(blue>255) blue=255;
		return new Color (red, green, blue);
	}
	
	
	private Color calcDiffuseComp(double kd, Vector normal, Vector l, Color lightIntensity)
	 {
		normal.normalize();
		l.normalize();
		double k = Math.abs(kd*(normal.dotProduct(l)));
		int red=(int)(lightIntensity.getRed()*k);
		int green=(int)(lightIntensity.getGreen()*k);
		int blue=(int)(lightIntensity.getBlue()*k);
		if(red>255) red=255;
		if(green>255) green=255;
		if(blue>255) blue=255;
		return new Color(red, green, blue);
	}


}
