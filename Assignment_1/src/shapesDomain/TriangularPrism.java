package shapesDomain;

public class TriangularPrism extends Prism {
	
	public TriangularPrism(double height, double edgeLength, char compareType) {
		super(height, edgeLength, compareType);
		
	}
	

	@Override
	public double getarea() {
		return (Math.pow(getheight(), 2) * Math.pow(3, 0.5)) / 4;
	}

	@Override
	public double getvolume() {
		return getarea() * getLength();
	}

	@Override
	public Object getShapeName() {
		// TODO Auto-generated method stub
		return "Traingular Prism";
	}

	@Override
	public String toString() {
		return "TriangularPrism [getarea()=" + getarea() + ", getvolume()=" + getvolume() + ", getheight()="
				+ getheight() + "]";
	}
	
}
