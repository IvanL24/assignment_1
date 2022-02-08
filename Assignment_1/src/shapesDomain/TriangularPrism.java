package shapesDomain;

public class TriangularPrism {

	private double height = 0.0;
	private double edgeLength = 0.0;
	
	private double area = 0.0;
	private double volume = 0.0;
	
	public TriangularPrism(double height, double edgeLength) {
		
		this.height = height;
		this.edgeLength = edgeLength;
		
		this.Calculate();
	}
	
	private void Calculate() {
		double A = (5 * (Math.pow(this.edgeLength, 2) * (Math.sqrt(3))))/4;
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
