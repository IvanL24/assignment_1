/**
 * 
 */
package shapesDomain;

import java.util.*;


/**
 * @author ivanl
 *
 */

public abstract class Shape implements Comparator<Shape>, Comparable<Shape>  {

	public final double pi = 3.14f;

	// Internal variables for abstract class
	private double area = 0.0;
	private double volume = 0.0;
	private double height = 0.0;
	
	// Protected methods, exclusively for implementation/access to subclasses.
	protected abstract void Calculate();
	protected void setValues(double area, double volume, double height) {
		this.area = area;
		this.volume = volume;
		this.height = height;
	}

	// Public methods defined here to remove code redundancy on subclasses.
	public Shape() {
		
	}

	public double area() {
		return this.area;
	}
	
	public double volume() {
		return this.volume;
	}
	
	public double height() {
		return this.height;
	}
	
	public int compare(Shape o1, Shape o2) {	
		boolean isMatch = (
			o1.volume() == o2.volume() &&
			o1.area() == o2.area()
		);
		
		return isMatch ? 0 : -1;
	}

	public int compareTo(Shape o) {
		return (int)(this.height - o.height());
	}
	
}
