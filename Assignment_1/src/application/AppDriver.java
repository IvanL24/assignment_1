package application;


import shapesDomain.*;

public class AppDriver {

	public static void main(String[] args) {
		
		Shape shape;
		//shape = new Rectangle("Blue", 10, 20);
		shape = new Cone(4, 6, 8);
		
		shape = new Cylinder(4, 6);
	
		
		//Cone cone = (Cone) shape;
		
		Cylinder cylinder = (Cylinder) shape;
		//double parameter = square.getParameter();
		
		double cylinderArea = cylinder.area();
		double cylinderVolume = cylinder.volume();
		
		//double coneArea = cone.area();
		//double coneVolume = cone.volume();
		
//		System.out.println("Volume: " + coneVolume);
//		System.out.println("Area: " + coneArea);
//		
		System.out.println("Volume: " + cylinderVolume);
		System.out.println("Area: " + cylinderArea);
	
		

	}

}
