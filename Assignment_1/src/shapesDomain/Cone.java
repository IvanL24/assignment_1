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
	  this.Calculate();
	 }
	 
	protected void Calculate() {
		double area = pi * radius * side;
		double volume =pi*radius*radius*(height/3);
		this.setValues(area, volume, this.height);
	}
	
}
