/**
 * 
 */
package shapesDomain;

/**
 * @author ivanl
 *
 */
public abstract class Prism extends Shape{

	private double length;
	
	public Prism(double side, double length, char compareType) {
		super(side, compareType);
		this.setLength(length);
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	@Override
	public abstract double getarea();

	@Override
	public abstract double getvolume();
	
	@Override
	public String toString() {
		return "Prism [getarea()=" + getarea() + ", getvolume()=" + getvolume() + ", getheight()=" + getheight()
				+ "]";
	}

}
