/**
 * 
 */
package shapesDomain;

/**
 * @author ivanl
 *
 */
public class OctagonalPrism extends Prism {

	private double height = 0.0;
	private double edgeLength = 0.0;

	public OctagonalPrism(double height, double edgeLength) {
		this.height = height;
		this.edgeLength = edgeLength;
		this.Calculate();
	}
	
	protected void Calculate() {
		double A =  2 * (1 + Math.sqrt(2)) * Math.pow(this.edgeLength, 2);
		double V = A * this.height;
		
		this.setValues(A, V, this.height);
	}
	
}
