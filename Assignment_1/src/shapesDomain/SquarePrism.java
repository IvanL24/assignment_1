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
	
	private double area = 0.0;
	private double volume = 0.0;
	
	public SquarePrism(double height, double edgeLength) {
		
		this.height = height;
		this.edgeLength = edgeLength;
		
		this.Calculate();
	}
	
	private void Calculate() {
		double A = Math.pow(this.edgeLength, 2);
		double V = A * this.height;
		
		this.area = A;
		this.volume = V;
	}
	
	public double area() {
		return this.area;
	}
	
	public double volume() {
		return this.volume;
	}
	
}
