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

	private double height = 0.0;
	private double edgeLength = 0.0;
	
	public SquarePrism(double height, double edgeLength) {
		
		this.height = height;
		this.edgeLength = edgeLength;
		
		this.Calculate();
	}
	
	protected void Calculate() {
		double A = Math.pow(this.edgeLength, 2);
		double V = A * this.height;
		
		this.setValues(A, V, this.height);
	}
	
	
}
