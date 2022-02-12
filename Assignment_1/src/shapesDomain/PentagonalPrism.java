package shapesDomain;

public class PentagonalPrism extends Prism{

	
	public PentagonalPrism(double height, double edgeLength, char compareType) {
		super(height, edgeLength, compareType);
	}


	@Override
	public double getarea() {
		// TODO Auto-generated method stub
		return (5 * Math.pow(this.getLength(), 2) * Math.tan(54)) / 4;
	}

	@Override
	public double getvolume() {
		// TODO Auto-generated method stub
		return getarea() * getheight();
	}

	@Override
	public Object getShapeName() {
		// TODO Auto-generated method stub
		return "Pentagonal Prism";
	}
	
	@Override
	public String toString() {
		return "PentagonalPrism [getarea()=" + getarea() + ", getvolume()=" + getvolume() + ", getheight()="
				+ getheight() + "]";
	}
	

}