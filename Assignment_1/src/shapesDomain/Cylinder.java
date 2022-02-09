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
	  this.Calculate();
	 }
	 
	 protected void Calculate() {
		 double area =2 * pi * radius * height + 2 * pi* radius *radius;
		 double volume = pi * radius * radius * height;
		 this.setValues(area, volume, this.height);
	 }

}
