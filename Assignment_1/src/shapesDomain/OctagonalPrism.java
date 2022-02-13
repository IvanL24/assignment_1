/**
 * 
 */
package shapesDomain;

/**
 * @author ivanl
 *
 */
public class OctagonalPrism extends Prism {

	public OctagonalPrism(double height, double edgeLength, char compareType) {
		super(height, edgeLength, compareType);
		

	}
	


	@Override
	public double getarea() {

		return (2 * (1 + Math.sqrt(2)) * Math.pow(getLength(), 2));
	}

	@Override
	public double getvolume() {

		return getarea() * getLength();
	}

	@Override
	public Object getShapeName() {

		return "Octagonal Prism";
	}
	
	
	
}
