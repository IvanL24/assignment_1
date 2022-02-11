/**
 * 
 */
package shapesDomain;



public class Cylinder extends Shape {
	
	private double radius; 
	
	 public Cylinder(double height, double radius, char compareType){
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
	 public double getvolume() {
		 return  pi * radius * radius * getheight();
	 }
	 
	 @Override
	 public double getarea() {
		 return 2 * pi * radius * getheight() + 2 * pi* radius *radius;
	 }
	 
	 @Override
	 public String toString() {
			return "Cylinder [radius=" + radius + ", getheight()=" + getheight() + "]";
	 }
	 
	 @Override
	 public String getShapeName() {
		 return "Cylinder";
	 }


}
