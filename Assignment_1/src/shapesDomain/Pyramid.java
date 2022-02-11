/**
 * 
 */
package shapesDomain;

/**
 * @author ivanl
 *
 */
public class Pyramid extends Shape{
	
	private double edgeLength;
	
	public Pyramid(double height, double edgeLength, char compareType) {
		
		super(height, compareType);
		this.edgeLength = edgeLength;
		
	}

	public double getEdgeLength() {
		return edgeLength;
	}
	
	public void setEdgeLength(double edgeLength) {
		this.edgeLength = edgeLength;
	}

	@Override
	public double getarea() {
		return Math.pow(getheight(), 2);
	}

	@Override
	public double getvolume() {
		return (Math.pow(getheight(), 2) * getEdgeLength()) / 3;
	}

	@Override
	public Object getShapeName() {
		return "Pyramid";
	}

	@Override
	public String toString() {
		return "Pyramid [length=" + edgeLength + ", getarea()=" + getarea() + ", getvolume()=" + getvolume()
				+ ", getHeight()=" + getheight() + "]";
	}

	
}
