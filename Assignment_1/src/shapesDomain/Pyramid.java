/**
 * 
 */
package shapesDomain;

/**
 * @author ivanl
 *
 */
public class Pyramid extends Shape{

	private double height = 0.0;
	private double edgeLength = 0.0;
		
	public Pyramid(double height, double edgeLength) {
		
		this.height = height;
		this.edgeLength = edgeLength;

		this.Calculate();
		
	}
	
	protected void Calculate() {
		
		double A =  Math.pow(this.edgeLength, 2);
		double V = 1/3 * A * this.height;
	
		this.setValues(A, V, this.height);
	}
	
}
