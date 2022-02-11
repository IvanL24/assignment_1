/**
 * 
 */
package utility;

import java.util.*;

import shapesDomain.Shape;



public class Sort {

	private ArrayList<Shape> shapes;
	private ComparatorArea area;
	private ComparatorHeight height;
	private ComparatorVolume volume;
	private char compareType;
	private char sortType;
	
	// will be used for calculating time
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
	
	
	//display user inputs
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
		
		System.out.println("Compare Type: " + compareType);
		System.out.println("Sort Type: " + sortingType);
		System.out.printf("%8s   %-20s%12s%25s%25s%n", "NO.", "SHAPE", "HEIGHT", "BASE AREA", "VOLUME");

	}
	
	
	private void sortArray(ArrayList<Shape> shapelist, char compareType, char sortType) {
		switch(sortType) {
			case 'b':
				startTime = System.currentTimeMillis();
				bubblesort(shapelist, compareType);
				endTime = System.currentTimeMillis();
				break;
				
			case 's':
				startTime = System.currentTimeMillis();
				selection(shapelist, compareType);
				endTime = System.currentTimeMillis();
				break;
				
		}
		printSortedArray(shapelist);
	}
	
	//method to display the sorted arraylist
	private void printSortedArray(ArrayList<Shape> shapelist) {
		System.out.printf("%7d   %-20s%,12.2f%,25.2f%,25.2f%n",1,shapelist.get(0).getShapeName(),shapelist.get(0).getheight(),shapelist.get(0).getarea(),shapelist.get(0).getvolume());
		for(int i=1; i<shapelist.size(); i++) {
			if(i % 1000 == 0) {
				System.out.printf("%7d   %-20s%,12.2f%,25.2f%,25.2f%n",
									i,shapelist.get(i).getShapeName(),shapelist.get(i).getheight(),shapelist.get(i).getarea(),shapelist.get(i).getvolume());
			}
		}
		System.out.printf("%7d   %-20s%,12.2f%,25.2f%,25.2f%n",shapelist.size(),shapelist.get(shapelist.size()-1).getShapeName(),shapelist.get(shapelist.size()-1).getheight(),shapelist.get(shapelist.size()-1).getarea(),shapelist.get(shapelist.size()-1).getvolume());
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
	
	// method for selection sort
	private void selection(ArrayList<Shape> shapelist, char compareType) {
		switch(compareType) {
		case 'h':
			
			for (int i = 0; i < shapelist.size(); i++){

		        int smallestNumber = i;
		        for(int j = i + 1; j < shapelist.size(); j++){
		            if(height.compare(shapelist.get(j), shapelist.get(smallestNumber)) == 1){
		                smallestNumber = j;
		            }    
		        }

		        Shape temp = shapelist.get(smallestNumber);
		        shapelist.set(smallestNumber, shapelist.get(i));
		        shapelist.set(i, temp);
		        }
		        
			
			break;
		case 'v':
			for (int i = 0; i < shapelist.size(); i++){

		        int smallestNumber = i;
		        for(int j = i + 1; j < shapelist.size(); j++){
		            if(volume.compare(shapelist.get(j), shapelist.get(smallestNumber)) == 1){
		                smallestNumber = j;
		            }    
		        }

		        Shape temp = shapelist.get(smallestNumber);
		        shapelist.set(smallestNumber, shapelist.get(i));
		        shapelist.set(i, temp);
		        }
			break;
		case 'a':
			for (int i = 0; i < shapelist.size(); i++){

		        int smallestNumber = i;
		        for(int j = i + 1; j < shapelist.size(); j++){
		            if(area.compare(shapelist.get(j), shapelist.get(smallestNumber)) == 1){
		                smallestNumber = j;
		            }    
		        }

		        Shape temp = shapelist.get(smallestNumber);
		        shapelist.set(smallestNumber, shapelist.get(i));
		        shapelist.set(i, temp);
		        }

			break;
		}
	}
	
		// method to return compare type
		public char getCompareType() {
			return compareType;
			
		}
		
		//method to return type of sorting
		public char getSortType() {
			return sortType;
			
		}

		// method to get shapes
		public ArrayList<Shape> getShapes() {
			return shapes;
			
		}
		
		
		//method to set compare type
		public void setCompareType(char compareType) {
			this.compareType = compareType;
			
		}

		// method to set type of sorting
		public void setSortType(char sortType) {
			this.sortType = sortType;
			
		}

		// method to set arraylist
		 void setShapes(ArrayList<Shape> shapes) {
			this.shapes = shapes;
			
		}


}
