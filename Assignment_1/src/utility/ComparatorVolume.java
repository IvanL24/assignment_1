package utility;

import java.util.Comparator;

import shapesDomain.Shape;

public class ComparatorVolume implements Comparator<Shape> {

	@Override
	public int compare(Shape o1, Shape o2) {
		// TODO Auto-generated method stub
		if(o1.getarea() > o2.getarea()) return 1;
		if(o1.getarea() < o2.getarea()) return -1;
		return 0;
	}

}
