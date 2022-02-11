package shapesDomain;

public class PentagonalPrism extends Prism{

	
	public PentagonalPrism(double height, double edgeLength) {
		
		this.height = height;
		this.edgeLength = edgeLength;
		
		this.Calculate();
	}
	
	protected void Calculate() {
		
		double A =  (5 * Math.pow(this.edgeLength, 2) * Math.tan(54)) / 4;
		double V = A * this.height;
		
		this.setValues(A, V, this.height);
	}
	

}
