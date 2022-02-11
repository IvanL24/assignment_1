/**
 * 
 */
package shapesDomain;



public abstract class Shape implements Comparable<Shape>  {

	public final double pi = 3.14f;

	private double compareType;
	private double height;
	
	// method to contain the calculations for area
	public abstract double getarea();
	
	// method to contain the calculations for volume
	public abstract double getvolume();
	

	// new shape object with specified values
	public Shape(double height, char compareType) {
		super();
		this.height = height;
		this.compareType = compareType;
	}

	//method to return height
	public double getheight() {
		return height;
	}

	// method to return type
	public double getCompareType() {
		return compareType;
	}
	
	// method to set the height
	public double setheight(double height) {
		return this.height;
	}
	
	//method use to set the type
	public double setCompareType(char compareType) {
		return this.compareType;
	}
	
	// method use to return the name of the shape
	public abstract Object getShapeName();
	
	/**
	 * base class to compare the height, volume and area
	 */
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

	
}
