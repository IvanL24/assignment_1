/**
 * 
 */
package shapesDomain;

/**
 * @author ivanl
 *
 */

 // test comment
 
public class SquarePrism extends Prism {

	
	public SquarePrism(double height, double edgeLength, char compareType) {
		super(height, edgeLength, compareType);
		
	}

	@Override
	public double getarea() {

		return Math.pow(getLength(), 2);
	}

	@Override
	public double getvolume() {
	
		return getarea() * getheight();
	}

	@Override
	public Object getShapeName() {
		// TODO Auto-generated method stub
		return "Square Prism";
	}
	@Override
	public String toString() {
		return "SquarePrism [getarea()=" + getarea() + ", getvolume()=" + getvolume() + ", getheight()="
				+ getheight() + "]";
	}
	
}
