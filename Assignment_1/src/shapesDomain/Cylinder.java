/**
 * 
 */
package shapesDomain;

/**
 * @author ivanl
 *
 */
public class Cylinder extends Shape {
	
	int radius; 
	int height;
	
	 public Cylinder(int r,int h)
	 {
	  radius=r;
	  height=h;
	 }

	@Override
	public double area() {
		
		double area =2 * pi * radius * height + 2 * pi* radius *radius;
		
		return area;
	}

	@Override
	public double volume() {
		
		double volume = pi * radius * radius * height;
		
		return volume;
	}


}
