/**
 * 
 */
package shapesDomain;

/**
 * @author ivanl
 *
 */
public class Cone extends Shape{
	
	int radius;
	int side;
	int height;
	 public Cone(int r,int s,int h)
	 {
	  radius=r;
	  side=s;
	  height= h;
	 
	 }

	@Override
	public double area() {
		
		double area = pi * radius * side;
		
		return area;
	}

	@Override
	public double volume() {
		
		 double volume =pi*radius*radius*(height/3);
		 
		return volume;
	}

	//add public getter
	
	//add public setter
	
}
