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
		
		
		
//		System.out.println("Main method executing tests");
//		
//		TestImporter(filename, compareType);
		
		
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
							System.out.println(shapelist);
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

//	public static void TestCylinder() {
//		
//		Shape shape;
//		shape = new Cone(4, 6, 8);		
//		shape = new Cylinder(4, 6);
//		
//		Cylinder cylinder = (Cylinder) shape;
//		
//		double cylinderArea = cylinder.area();
//		double cylinderVolume = cylinder.volume();
//		
//	
//		System.out.println("Volume: " + cylinderVolume);
//		System.out.println("Area: " + cylinderArea);
//		
//	}
	
//	public static void TestEquilatrialBase() {
//		
//		TriangularPrism tPrism = new TriangularPrism(5.0, 4.3);
//		System.out.println("Volume: " + tPrism.area());
//		
//	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList<Shape> TestImporter(String filename, char compareType){
		
		
//		Importer importer = new Importer("./res/polyfor1.txt");
//		try {
//			importer.ImportShapes();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
		// ask system which file to handle 
//			"-fpolyfor1.txt"
//			String myFilename = filename.replace("-f", "");
//			System.out.println(filename);
			File file = new File ("res/polyfor1.txt");
			Scanner scan = new Scanner(file);
			String shapeCount = scan.next();
			
			shapelist = new ArrayList<Shape>(Integer.parseInt(shapeCount));
			System.out.println("Reading...");
			
			while(scan.hasNext()) {

					String shapeType = scan.next();
					double height = Double.parseDouble(scan.next());
					double length_radius = Double.parseDouble(scan.next());
					String className = "shapesDomain." + shapeType;
					Class cls = Class.forName(className);
					Class paramTypes[] = new Class[3];
						paramTypes[0] = Double.TYPE;
						paramTypes[1] = Double.TYPE;
						paramTypes[2] = Character.TYPE;
					Constructor classConstructor = cls.getConstructor(paramTypes);
					
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

//		
		
	}
	
	
	
	private static void arraySort(ArrayList<Shape> shapes, char compareType, char sortType) {
		System.out.println(shapes);
		new Sort(shapes, compareType, sortType);
	}

}
