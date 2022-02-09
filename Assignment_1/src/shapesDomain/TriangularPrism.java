package shapesDomain;

public class TriangularPrism extends Prism {

	private double height = 0.0;
	private double edgeLength = 0.0;
	
	public TriangularPrism(double height, double edgeLength) {
		
		this.height = height;
		this.edgeLength = edgeLength;
		
		this.Calculate();
	}
	
	protected void Calculate() {
		double A = (5 * (Math.pow(this.edgeLength, 2) * (Math.sqrt(3))))/4;
		double V = A * this.height;
		this.setValues(A, V, this.height);
	}
	
}
