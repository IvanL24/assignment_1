/**
 * 
 */
package utility;

import java.text.DecimalFormat;
import java.util.*;

import shapesDomain.Prism;
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
	private void userInput (char compare, char sort) {
		String compareType = "";
		String sortingType = "";
		
		switch(compare) {
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
		
		switch(sort) {
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
		case 'c':
			sortingType = "Counting sort (custom)";
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
				
			case 'q':
				startTime = System.currentTimeMillis();
				quickSort(shapelist, 0, shapelist.size()-1, compareType);
				endTime = System.currentTimeMillis();
				break;
				
			case 'i':
				startTime = System.currentTimeMillis();
				insertion(shapelist, compareType);
				endTime = System.currentTimeMillis();
				break;
				
			case 'm':
				startTime = System.currentTimeMillis();
				sort(shapelist, compareType);
				endTime = System.currentTimeMillis();
				break;
			case 'c':
				startTime = System.currentTimeMillis();
				countingSort(shapelist, compareType);
				endTime = System.currentTimeMillis();
				break;
		}
		printSortedArray(shapelist);
	}
	
	//method to display the sorted arraylist
	private void printSortedArray(ArrayList<Shape> shapelist) {
		
		System.out.printf("%7d   %-20s%,12.2f%,25.2f%,25.2f%n",
				0,shapelist.get(0).getShapeName(),shapelist.get(0).getheight(),shapelist.get(0).getarea(),shapelist.get(0).getvolume());
		
		for(int i=1; i<shapelist.size(); i++) {
			if(i % 1000 == 0) {
				System.out.printf("%7d   %-20s%,12.2f%,25.2f%,25.2f%n",
									i,shapelist.get(i).getShapeName(),shapelist.get(i).getheight(),shapelist.get(i).getarea(),shapelist.get(i).getvolume());
			}
		}
		System.out.printf("%7d   %-20s%,12.2f%,25.2f%,25.2f%n",shapelist.size(),shapelist.get(shapelist.size()-1).getShapeName(),shapelist.get(shapelist.size()-1).getheight(),shapelist.get(shapelist.size()-1).getarea(),shapelist.get(shapelist.size()-1).getvolume());
		System.out.println("Time: " + (endTime - startTime) + "ms");
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
		            if(height.compare(shapelist.get(j), shapelist.get(smallestNumber)) == -1){
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
		            if(volume.compare(shapelist.get(j), shapelist.get(smallestNumber)) == -1){
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
		            if(area.compare(shapelist.get(j), shapelist.get(smallestNumber)) == -1){
		                smallestNumber = j;
		            }    
		        }

		        Shape temp = shapelist.get(smallestNumber);
		        shapelist.set(smallestNumber, shapelist.get(i));
		        shapelist.set(i, temp);
		        }

			break;
		}
		
		Collections.reverse(shapelist);
		
	}
	
	// method for quick sort
	private void quickSort (ArrayList<Shape> shapelist,int start, int end, char compareType) {
			
        int partitionIndex = partition(shapelist, start, end, compareType);
        
        if( start < partitionIndex -1) {
            quickSort(shapelist, start, partitionIndex - 1, compareType);
        }
        if(partitionIndex < end) {
            quickSort(shapelist, partitionIndex, end, compareType);
        }
        endTime = System.currentTimeMillis();

	}
	
    public int partition(ArrayList<Shape> shapelist,int start, int end, char compareType){

    	Shape pivot = shapelist.get((end + start)/ 2);
 
        for(int i=start; i<shapelist.size(); i++){
        	
        	switch(compareType) {
        	
        	
        	case 'h':
        			while(start <= end){
                     while (height.compare(shapelist.get(start), pivot) > 0) {
                    	 start++;
                     }
                     while (height.compare(shapelist.get(end), pivot) < 0) {
                         end--;
                     }
                     if(start <= end) {
                         Shape temp = shapelist.get(start);
                         shapelist.set(start, shapelist.get(end));
                         shapelist.set(end, temp);
                         start++;
                         end--;
                     }
                 }
    			break;
    			
        	case 'v':
    			while(start <= end){
                 while (volume.compare(shapelist.get(start), pivot) > 0) {
                	 start++;
                 }
                 while (volume.compare(shapelist.get(end), pivot) < 0) {
                     end--;
                 }
                 if(start <= end) {
                     Shape temp = shapelist.get(start);
                     shapelist.set(start, shapelist.get(end));
                     shapelist.set(end, temp);
                     start++;
                     end--;
                 }
             }
			break;
			
        	case 'a':
    			while(start <= end){
                 while (area.compare(shapelist.get(start), pivot) > 0) {
                 start++;
                 }
                 while (area.compare(shapelist.get(end), pivot) < 0) {
                     end--;
                 }
                 if(start <= end) {
                     Shape temp = shapelist.get(start);
                     shapelist.set(start, shapelist.get(end));
                     shapelist.set(end, temp);
                     start++;
                     end--;
                 }
             }
			break;

        	}
    	}
        return start;
    }
    
    //Insertion method
	private void insertion (ArrayList<Shape> shapelist, char compareType) {
		
		switch(compareType) {
    	
    	
    	case 'h':
            for (int i = 0; i < shapelist.size(); i++) {
                Shape index  = shapelist.get(i);
                int j = i -1;
                while (j > 0 && height.compare(shapelist.get(i), index)  > 0) {
                    shapelist.set(i + 1, shapelist.get(i));
                    j--;
                }
            }
			break;
    	case 'v':
            for (int i = 0; i < shapelist.size(); i++) {
                Shape index  = shapelist.get(i);
                int j = i -1;
                while (j > 0 && volume.compare(shapelist.get(i), index) > 0) {
                    shapelist.set(i + 1, shapelist.get(i));
                    j--;
                }
            }
			break;
    	case 'a':
            for (int i = 0; i < shapelist.size(); i++) {
                Shape index  = shapelist.get(i);
                int j = i -1;
                while (j > 0 && area.compare(shapelist.get(i), index)  > 0) {
                    shapelist.set(i + 1, shapelist.get(i));
                    j--;
                }
            }
			break;
		}

	}
    
	/**
	 * method for merge sort
	 * @return
	 */
    private ArrayList<Shape> sort(ArrayList<Shape> shapelist, char compareType){
    	ArrayList<Shape> left = new ArrayList<Shape>();
    	ArrayList<Shape> right = new ArrayList<Shape>();
        int middle;
        
        
    	if (shapelist.size() == 1) {
    		return shapelist;
    	} else {
    		
            middle =shapelist.size() / 2;
            
            for(int i = 0; i < middle; i++) {
            	left.add(shapelist.get(i));
            }
            
            for(int i = middle; i < shapelist.size(); i++) {
            	right.add(shapelist.get(i));
            }
            
            left = sort(left, compareType);
            right = sort(right, compareType);

            merge(left, right, shapelist, compareType);
          
        }
    	return shapelist;
    }
    
    

    public void countingSort(ArrayList<Shape> arr, char compareType)
    {

    	
    	/**
    	* Counting Sort
    	*
    	* first part of the code:
    	* setup an output
    	* first for loop:
    	* find the largest number in the array (int max)
    	*
    	* second for loop:
    	* initialize array values to zero
    	* create a new array to store counts
    	* third for loop:
    	* count array++
    	*
    	* fourth for loop:
    	* store counts from each array into a new array

    	* fifth for loop:
    	* look for the index of the original array and store it to an array (output array)
    	*
    	* sixth for loop:
    	* copy the sorted elements from each array into the original array
    	*
    	* Complexity Test
    	* Best O(n+k)
    	* Worst O(n+k)
    	* Average O(n+k)
    	*
    	* Space O(max)
    	*/
    	
    	class indexTracker {
    		public int index = 0;
    		public int value = 0;
    	}
    	
    
    	//int[] input = new int[arr.size() + 1];
    	indexTracker[] input = new indexTracker[arr.size() + 1];
    	
    	for (int x = 0; x < arr.size(); x++) {
    		input[x] = new indexTracker();
    	}
    	
    	System.out.println("array size: " + arr.size());
    
    	
    	switch(compareType) {
        case 'h': // height
        	for (int x = 0; x < arr.size(); x++) {
        		input[x].index = x;
        		input[x].value = (int)arr.get(x).getheight();
        	}
        	break;
        case 'v': // volume
        	for (int x = 0; x < arr.size(); x++) {
        		input[x].index = x;
        		input[x].value = (int)arr.get(x).getvolume();
        	}
        	break;
        case 'a': // area
        	for (int x = 0; x < arr.size(); x++) {
        		input[x].index = x;
        		input[x].value = (int)arr.get(x).getarea();
        	}
        	break;
		}
    	
    	    	
        int[] output = new int[arr.size() + 1];
        
        int max = input[0].value;
        
        System.out.println(input[0].value);
        for (int i = 1; i < arr.size(); i++) {
          if (input[i].value > max)
            max = input[i].value;
        }
        
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i) {
          count[i] = 0;
        }

        for (int i = 0; i < arr.size(); i++) {
          count[input[i].value]++;
        }

        for (int i = 1; i <= max; i++) {
          count[i] += count[i - 1];
        }

        for (int i = arr.size() - 1; i >= 0; i--) {
          output[count[input[i].value] - 1] = input[i].value;
          count[input[i].value]--;
        }
    
        for (int i = 0; i < arr.size(); i++) {
          input[i].value = output[i];
          System.out.println(input[i].value);
        }
        
      }
    
    
    
    private void merge(ArrayList<Shape> left, ArrayList<Shape> right, ArrayList<Shape> shapelist, char compareType) {

        int indexleft = 0;
        int indexshapelist = 0;
        int indexright = 0;
        
        switch(compareType) {
        case 'h':
        	while (indexshapelist < left.size() + right.size()) {
        		if(indexleft == left.size() ){
        			shapelist.set(indexshapelist, right.get(indexright));
        			indexright++;
        		} else if(indexright == right.size()){
        			shapelist.set(indexshapelist, left.get(indexleft));
        			indexleft++;
        		}	
        		  else if(height.compare(left.get(indexleft), right.get(indexright)) > 0) {
        			shapelist.set(indexshapelist, left.get(indexleft));
        			indexleft++;	
        		} else{
        			shapelist.set(indexshapelist, right.get(indexright));
        			indexright++;
        		} 		
        		
        		indexshapelist++;
        	}
        	break;
        case 'v':
        	while (indexshapelist < left.size() + right.size()) {
        		if(indexleft == left.size() ){
        			shapelist.set(indexshapelist, right.get(indexright));
        			indexright++;
        		} else if(indexright == right.size()){
        			shapelist.set(indexshapelist, left.get(indexleft));
        			indexleft++;
        		}	
        		  else if(volume.compare(left.get(indexleft), right.get(indexright)) > 0) {
        			shapelist.set(indexshapelist, left.get(indexleft));
        			indexleft++;	
        		} else{
        			shapelist.set(indexshapelist, right.get(indexright));
        			indexright++;
        		} 		
        		
        		indexshapelist++;
        	}
        	break;
        case 'a':
        	while (indexshapelist < left.size() + right.size()) {
        		if(indexleft == left.size() ){
        			shapelist.set(indexshapelist, right.get(indexright));
        			indexright++;
        		} else if(indexright == right.size()){
        			shapelist.set(indexshapelist, left.get(indexleft));
        			indexleft++;
        		}	
        		  else if(area.compare(left.get(indexleft), right.get(indexright)) > 0) {
        			shapelist.set(indexshapelist, left.get(indexleft));
        			indexleft++;	
        		} else{
        			shapelist.set(indexshapelist, right.get(indexright));
        			indexright++;
        		} 		
        		
        		indexshapelist++;
        	}
        	break;
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
