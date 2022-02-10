/**
 * 
 */
package utility;

import java.util.*;

import shapesDomain.Shape;

/**
 * @author ivanl
 *
 */
public class Sort {

	private ArrayList<Shape> shapes;
	private ComparatorArea area;
	private ComparatorHeight height;
	private ComparatorVolume volume;
	private char compareType;
	private char sortType;
	private double startTime;
	private double endTime;

	public Sort(ArrayList<Shape> shapes, char compareType, char sortType) {
		area = new ComparatorArea();
		height = new ComparatorHeight();
		volume = new ComparatorVolume();
		setShapes(shapes);
		setCompareType(Character.toLowerCase(compareType));
		setSortType(Character.toLowerCase(sortType));
		
		userInput(compareType, sortType);
		sortArray(shapes, compareType, sortType);
	}
	
	
	private void userInput (char c, char s) {
		String compareType = "";
		String sortingType = "";
		
		switch(c) {
		case 'h':
			compareType = "By Height";
			break;
		case 'v':
			compareType = "By Volume";
			break;
		case 'a':
			compareType = "By Area";
			break;
		}
		
		switch(s) {
		case 'b':
			sortingType = "Bubble sort";
			break;
		case 's':
			sortingType = "Selection sort";
			break;
		case 'i':
			sortingType = "Insertion sort";
			break;
		case 'q':
			sortingType = "Quick sort";
			break;
		case 'm':
			sortingType = "Merge sort";
			break;
		}
		
		System.out.println("Compare type:"+ compareType);
		System.out.println("Sorting type:"+ sortingType);
	}
	
//	private void sortArray(ArrayList<Shape> shapelist, char compareType, char sortType) {
//		
//		
//	}
	
	private void sortArray(ArrayList<Shape> shapelist, char compareType, char sortType) {
		switch(sortType) {
			case 'b':
				startTime = System.currentTimeMillis();
				bubblesort(shapelist, compareType);
				endTime = System.currentTimeMillis();
				break;
				
		}
	}
	
	
	private void bubblesort(ArrayList<Shape> shapelist, char compareType) {
		switch(compareType) {
		case 'h':
			for(int i=0; i<shapelist.size() - 1; i++) {
				for(int j=0; j<shapelist.size() - i - 1; j++) {
					if(height.compare(shapelist.get(j), shapelist.get(j+1)) >= 0){
						Shape temp = shapelist.get(j);
						shapelist.set(j, shapelist.get(j+1));
						shapelist.set(j+1, temp);
					}
				}
			}
			break;
		case 'v':
			for(int i=0; i<shapelist.size() - 1; i++) {
				for(int j=0; j<shapelist.size() - i - 1; j++) {
					if(volume.compare(shapelist.get(j), shapelist.get(j+1)) >= 0){
						Shape temp = shapelist.get(j);
						shapelist.set(j, shapelist.get(j+1));
						shapelist.set(j+1, temp);
					}
				}
			}
			break;
		case 'a':
			for(int i=0; i<shapelist.size() - 1; i++) {
				for(int j=0; j<shapelist.size() - i - 1; j++) {
					if(area.compare(shapelist.get(j), shapelist.get(j+1)) >= 0){
						Shape temp = shapelist.get(j);
						shapelist.set(j, shapelist.get(j+1));
						shapelist.set(j+1, temp);
					}
				}
			}
			break;
		}
	}
	
	// getter methods
		private char getCompareType() {
			return compareType;
			
		}

		private char getSortType() {
			return sortType;
			
		}

		private ArrayList<Shape> getShapes() {
			return shapes;
			
		}
		
		
		//setter methods
		private void setCompareType(char compareType) {
			this.compareType = compareType;
			
		}

		private void setSortType(char sortType) {
			this.sortType = sortType;
			
		}

		private void setShapes(ArrayList<Shape> shapes) {
			this.shapes = shapes;
			
		}


}
