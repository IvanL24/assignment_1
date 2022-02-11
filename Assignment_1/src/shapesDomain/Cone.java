/**
 * 
 */
package shapesDomain;



public class Cone extends Shape{
	
	private double radius;

	 public Cone(double height, double radius, char compareType){
	  super(height, compareType);
	  this.radius = radius;
	 }

	 public double getRadius() {
			return radius;
	}
		
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getarea() {
		// TODO Auto-generated method stub
		return pi * (radius * radius);
	}

	@Override
	public double getvolume() {
		// TODO Auto-generated method stub
		return (pi*(radius*radius)*(getheight())) /3;
	}
	
	@Override
	 public String toString() {
			return "Cone [radius=" + radius + ", getheight()=" + getheight() + "]";
	 }

	@Override
	public Object getShapeName() {
		// TODO Auto-generated method stub
		return "Cone";
	}
	
}
