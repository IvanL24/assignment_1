package utility;

import java.util.Comparator;

import shapesDomain.Shape;

public class ComparatorVolume implements Comparator<Shape> {

	@Override
	public int compare(Shape o1, Shape o2) {
		// TODO Auto-generated method stub
		if(o1.area() > o2.area()) return 1;
		if(o1.area() < o2.area()) return -1;
		return 0;
	}

}
