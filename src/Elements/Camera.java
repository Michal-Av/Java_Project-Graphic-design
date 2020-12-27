package Elements;
import java.util.ArrayList;

import Primitives.*;

public class Camera {

	Point3D _P0;
	Vector _vUp ,_vTo, _vRight;

	//************************Constructors*************************//
	
	public Camera() {
		super();
		this._P0 = new Point3D();
		this._vUp = new Vector(new Point3D(new Coordinate(0), new Coordinate(1),new Coordinate(0)));
		this._vTo = new Vector(new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(-1)));
		this._vRight = new Vector(new Point3D(new Coordinate(1), new Coordinate(0),new Coordinate(0)));
	}
	
	public Camera(Point3D _P0, Vector _vUp, Vector _vTo) {
		super();
		this._P0 = new Point3D(_P0);
		this._vUp = new Vector(_vUp);
		this._vTo = new Vector(_vTo);
		
	}
	
	public Camera(Camera my_camera) {
		super();
		this._P0 = new Point3D(my_camera._P0);
		this._vUp = new Vector(my_camera._vUp);
		this._vTo = new Vector(my_camera._vTo);
		this._vRight = new Vector(my_camera._vRight);
	}
	
	//************************Getters/Setters*************************//
	
	public Point3D get_P0() {
		return new Point3D(_P0);
	}

	public void set_P0(Point3D _P0) {
		this._P0 = new Point3D(_P0);
	}

	public Vector get_vUp() {
		return new Vector(_vUp);
	}

	public void set_vUp(Vector _vUp) {
		this._vUp = new Vector(_vUp);
	}

	public Vector get_vTo() {
		return new Vector(_vTo);
	}

	public void set_vTo(Vector _vTo) {
		this._vTo = new Vector(_vTo);
	}

	public Vector get_vRight() {
		return new Vector(_vRight);
	}
	
	//************************Administration*************************//
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	//************************Operations*****************************//
	 
	public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y,
            double screenDist, double screenWidth, double screenHeight)
	{
		
		Vector tmpVup = new Vector(this._vUp);
		//pc=p0+d*vto
		Vector tmpVto = new Vector(this._vTo);
		tmpVto.scale(screenDist);
		Vector pc = new Vector(this._P0);
		pc.add(tmpVto);
		
		//Vright = vto X vup
		this._vRight = this._vTo.crossProduct(this._vUp);
		Vector tmpVright = new Vector(this._vRight);
		
		//ratio
		double Rx = screenWidth/Nx;
		double Ry = screenHeight/Ny;
		
		//p=pc+[[(x-Nx/2)*Rx + Rx/2]*vright - [(y-Ny/2)*Ry + Ry/2]*vup]
		tmpVright.scale((x-(Nx/2.0))*Rx+(Rx/2.0));
		tmpVup.scale((y-Ny/2.0)*Ry+Ry/2.0);
		Vector p = pc;
		p.add(new Vector(tmpVright.get_head().substract(tmpVup.get_head())));
		
		return new Ray(this._P0, p);
		
	}
	
	public ArrayList<Ray> constructRaysThroughPixel (int Nx, int Ny, double x, double y,
            double screenDist, double screenWidth, double screenHeight)
	{
		
		Vector tmpVup = new Vector(this._vUp);
		//pc=p0+d*vto
		Vector tmpVto = new Vector(this._vTo);
		tmpVto.scale(screenDist);
		Vector pc = new Vector(this._P0);
		pc.add(tmpVto);
		
		//Vright = vto X vup
		this._vRight = this._vTo.crossProduct(this._vUp);
		Vector tmpVright = new Vector(this._vRight);
		
		//ratio
		double Rx = screenWidth/Nx;
		double Ry = screenHeight/Ny;
		
		//p=pc+[[(x-Nx/2)*Rx + Rx/2]*vright - [(y-Ny/2)*Ry + Ry/2]*vup]
		tmpVright.scale((x-(Nx/2.0))*Rx+(Rx/2.0));
		tmpVup.scale((y-Ny/2.0)*Ry+Ry/2.0);
		Vector p = new Vector(pc);
		p.add(new Vector(tmpVright.get_head().substract(tmpVup.get_head())));
		Ray ray = new Ray();
		ray.set_POO(new Point3D(_P0));
		ray.set_direction(new Vector(p));
		
		//Jagged edges -> super sampling
		//creating more rays
		ArrayList<Ray> list = new ArrayList<Ray>();
		list.add(ray);

		list.add(new Ray(new Point3D(_P0),new Vector(pc.addV((new Vector(_vRight).scaling((x-Nx/2.0)*Rx)).substractV
				((new Vector(_vUp)).scaling((y-Ny/2.0)*Ry))))));
		list.add(new Ray(new Point3D(_P0),new Vector(pc.addV(((new Vector(_vRight)).scaling((x-Nx/2.0)*Rx+Rx)).substractV
				((new Vector(_vUp)).scaling((y-Ny/2.0)*Ry))))));
		list.add(new Ray(new Point3D(_P0),new Vector(pc.addV(((new Vector(_vRight)).scaling((x-Nx/2.0)*Rx)).substractV
				((new Vector(_vUp)).scaling((y-Ny/2.0)*Ry+Ry))))));
		list.add(new Ray(new Point3D(_P0),new Vector(pc.addV(((new Vector(_vRight)).scaling((x-Nx/2.0)*Rx+Rx)).substractV
				((new Vector(_vUp)).scaling((y-Ny/2.0)*Ry+Ry))))));
		
		return list;
		
	}
}
