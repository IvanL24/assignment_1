package application;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import shapesDomain.*;
import utility.Sort;

public class AppDriver {
	
	private static ArrayList<Shape> shapelist;
	
public static void main(String[] args) throws FileNotFoundException{
		
	//arg1: -f + file name = used to choose which file to open
	//-t: options to choose how to compare 
		// v = compare via volume
		// h = compare via height
		// a = compare via area
	//-s: options to choose how to sort
		// s = selection sort
		// b = bubble sort
		// i = insertion sort
		// q = quick sort
		// m = merge sort
		// z = your choice of sorting
	
		try {
			String arg1 = args[0];
			String arg2 = args[1];
			String arg3 = args[2];
			

			if(arg1.substring(0, 1).equals("-") || arg2.substring(0, 1).equals("-") || arg3.substring(0, 1).equals("-")) {
				
				if(arg1.substring(1, 2).equalsIgnoreCase("f")){
					if(arg2.substring(1, 2).equalsIgnoreCase("t")) {
						if(arg3.substring(1, 2).equalsIgnoreCase("s")) {
							ArrayList<Shape> shapelist = TestImporter(arg1.substring(2), arg2.charAt(2));
							arraySort(shapelist, Character.toLowerCase(arg2.charAt(2)), Character.toLowerCase(arg3.charAt(2)));
						}
					}else if(arg3.substring(1, 2).equalsIgnoreCase("t")) {
						if(arg2.substring(1, 2).equalsIgnoreCase("s")) {
							ArrayList<Shape> shapelist = TestImporter(arg1.substring(2), arg3.charAt(2));
							arraySort(shapelist, Character.toLowerCase(arg3.charAt(2)), Character.toLowerCase(arg2.charAt(2)));
						}
					}else {
						System.out.println("Invalid inputs");
					}
				} else if(arg2.substring(1, 2).equalsIgnoreCase("f")) {
					if(arg1.substring(1, 2).equalsIgnoreCase("t")) {
						if(arg3.substring(1, 2).equalsIgnoreCase("s")) {
							ArrayList<Shape> shapelist = TestImporter(arg2.substring(2), arg1.charAt(2));
							arraySort(shapelist, Character.toLowerCase(arg1.charAt(2)), Character.toLowerCase(arg3.charAt(2)));
						}
					}else if(arg3.substring(1, 2).equalsIgnoreCase("t")) {
						if(arg1.substring(1, 2).equalsIgnoreCase("s")) {
							ArrayList<Shape> shapelist = TestImporter(arg2.substring(2), arg3.charAt(2));
							arraySort(shapelist, Character.toLowerCase(arg3.charAt(2)), Character.toLowerCase(arg1.charAt(2)));
						}
					}else {
						System.out.println("Invalid inputs");
					}
				} else if(arg3.substring(1, 2).equalsIgnoreCase("f")) {
					if(arg2.substring(1, 2).equalsIgnoreCase("t")) {
						if(arg1.substring(1, 2).equalsIgnoreCase("s")) {
							ArrayList<Shape> shapelist = TestImporter(arg3.substring(2), arg2.charAt(2));
							arraySort(shapelist, Character.toLowerCase(arg2.charAt(2)), Character.toLowerCase(arg1.charAt(2)));
						}
					}else if(arg1.substring(1, 2).equalsIgnoreCase("t")) {
						if(arg2.substring(1, 2).equalsIgnoreCase("s")) {

							System.out.println("arg1:" + arg1);
							System.out.println("arg2:" + arg2);
							System.out.println("arg3:" + arg3);
							ArrayList<Shape> shapelist = TestImporter(arg3.substring(2), arg3.charAt(2));
							//System.out.println(shapelist);
							arraySort(shapelist, Character.toLowerCase(arg1.charAt(2)), Character.toLowerCase(arg2.charAt(2)));
						}
					}else {
						System.out.println("Invalid inputs");
					}
				}
				
			} else {
				System.out.println("Parameter error.");
			}
		} catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
	
	}


	/**
	 * Get the content of the file into the arraylist
	 * @param filename: name of target file
	 * @param compareType: compare type (i.e., compare by height)
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList<Shape> TestImporter(String filename, char compareType){

		// read file based on the filename given during input
		try {

			File file = new File ("res/" + filename);
			Scanner scan = new Scanner(file);
			
			// shape count in the text file (the very first number)
			String shapeCount = scan.next();
			
			// convert shapeCount to int with parseInt
			shapelist = new ArrayList<Shape>(Integer.parseInt(shapeCount));
			
			//indicator if file was accessed or not
			System.out.println("Reading...");
			
			while(scan.hasNext()) {

					String shapeType = scan.next();
					double height = Double.parseDouble(scan.next());
					double length_radius = Double.parseDouble(scan.next());
					
					// Get Classpath to access the class for each shape
					String className = "shapesDomain." + shapeType;
					
					// get the parameter type after reading the input from txt file
					Class cls = Class.forName(className);
					Class paramTypes[] = new Class[3];
						paramTypes[0] = Double.TYPE;
						paramTypes[1] = Double.TYPE;
						paramTypes[2] = Character.TYPE;
					Constructor classConstructor = cls.getConstructor(paramTypes);
					
					// get the value for height, length/radius, and compare type which is to be pass to the main method
					Object argList[] = new Object[3];
					argList[0] =  (double) height;
					argList[1] = (double)length_radius;
					argList[2] = (Character) compareType;
					
					Object obj = classConstructor.newInstance(argList);
					shapelist.add((Shape)obj);
			}
			
			scan.close();
			System.out.println("FILE READ.\n");
			
			
	} catch (FileNotFoundException e) {
		System.out.println("File not found :: "+e.getMessage());
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		e.printStackTrace();
	} catch (SecurityException e) {
		e.printStackTrace();
	} catch (InstantiationException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	}

	return shapelist;	
	
		
	}
	
	
	/**
	 * method to sort array
	 * @param add shape arraylist to sort
	 * @param compareType: compare type (i.e., compare by height)
	 * @return sortType: sorting type (insertion, bubble, quick sort )
	 */
	
	private static void arraySort(ArrayList<Shape> shapes, char compareType, char sortType) {
		//System.out.println(shapes);
		new Sort(shapes, compareType, sortType);
	}

}
