package utility;

import java.util.*;

import shapesDomain.Shape;

public class ComparatorHeight implements Comparator<Shape> {

	@Override
	public int compare(Shape o1, Shape o2) {
		// TODO Auto-generated method stub
		if(o1.getheight() > o2.getheight()) return 1;
		if(o1.getheight() < o2.getheight()) return -1;
		return 0;
	}

	

}
