/**
 * 
 */
package shapesDomain;


/**
 * @author ivanl
 *
 */

public abstract class Shape implements Comparable<Shape>  {

	public final double pi = 3.14f;

	// Internal variables for abstract class
	private double compareType;
	private double height;
	
	public abstract double getarea();
	
	public abstract double getvolume();
	

	// Public methods defined here to remove code redundancy on subclasses.
	public Shape(double height, char compareType) {
		super();
		this.height = height;
		this.compareType = compareType;
	}

	//getters
	public double getheight() {
		return height;
	}

	public double getCompareType() {
		return compareType;
	}
	
	// setters
	public double setheight(double height) {
		return this.height;
	}
	public double setCompareType(char compareType) {
		return this.height;
	}
	
	@Override
	public int compareTo(Shape o) {
		if(o.getCompareType() == 'h') {
			if(this.getheight() > o.getheight()) return 1;
			if(this.getheight() < o.getheight()) return -1;
			return 0;
		}else if(o.getCompareType() == 'v') {
			if(this.getvolume() > o.getvolume()) return 1;
			if(this.getvolume() < o.getvolume()) return -1;
			return 0;
		}else if(o.getCompareType() == 'a') {
			if(this.getarea() > o.getarea()) return 1;
			if(this.getarea() < o.getarea()) return -1;
			return 0;
		}else {
			return 0;
		}
	}
	
	public abstract Object getShapeName();
	
}
