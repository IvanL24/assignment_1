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
			
			System.out.println(arg1);
			System.out.println(arg2);
			System.out.println(arg3);

			if(arg1.substring(0, 1).equals("-") || arg2.substring(0, 1).equals("-") || arg3.substring(0, 1).equals("-")) {
				
				if(arg1.substring(1, 2).equalsIgnoreCase("f")){
					if(arg2.substring(1, 2).equalsIgnoreCase("t")) {
						if(arg3.substring(1, 2).equalsIgnoreCase("s")) {
							TestImporter(arg1.substring(2), arg2.charAt(2));
							arraySort(shapelist, Character.toLowerCase(arg2.charAt(2)), Character.toLowerCase(arg3.charAt(2)));
						}
					}else if(arg3.substring(1, 2).equalsIgnoreCase("t")) {
						if(arg2.substring(1, 2).equalsIgnoreCase("s")) {
							TestImporter(arg1.substring(2), arg3.charAt(2));
							arraySort(shapelist, Character.toLowerCase(arg3.charAt(2)), Character.toLowerCase(arg2.charAt(2)));
						}
					}else {
						System.out.println("Invalid inputs");
					}
				} else if(arg2.substring(1, 2).equalsIgnoreCase("f")) {
					if(arg1.substring(1, 2).equalsIgnoreCase("t")) {
						if(arg3.substring(1, 2).equalsIgnoreCase("s")) {
							TestImporter(arg2.substring(2), arg1.charAt(2));
							arraySort(shapelist, Character.toLowerCase(arg1.charAt(2)), Character.toLowerCase(arg3.charAt(2)));
						}
					}else if(arg3.substring(1, 2).equalsIgnoreCase("t")) {
						if(arg1.substring(1, 2).equalsIgnoreCase("s")) {
							TestImporter(arg2.substring(2), arg3.charAt(2));
							arraySort(shapelist, Character.toLowerCase(arg3.charAt(2)), Character.toLowerCase(arg1.charAt(2)));
						}
					}else {
						System.out.println("Invalid inputs");
					}
				} else if(arg3.substring(1, 2).equalsIgnoreCase("f")) {
					if(arg2.substring(1, 2).equalsIgnoreCase("t")) {
						if(arg1.substring(1, 2).equalsIgnoreCase("s")) {
							TestImporter(arg3.substring(2), arg2.charAt(2));
							arraySort(shapelist, Character.toLowerCase(arg2.charAt(2)), Character.toLowerCase(arg1.charAt(2)));
						}
					}else if(arg1.substring(1, 2).equalsIgnoreCase("t")) {
						if(arg2.substring(1, 2).equalsIgnoreCase("s")) {
							TestImporter(arg3.substring(2), arg3.charAt(2));
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

	public static void TestCylinder() {
		
		Shape shape;
		//shape = new Rectangle("Blue", 10, 20);
		shape = new Cone(4, 6, 8);
		
		shape = new Cylinder(4, 6);
	
		
		//Cone cone = (Cone) shape;
		
		Cylinder cylinder = (Cylinder) shape;
		//double parameter = square.getParameter();
		
		double cylinderArea = cylinder.area();
		double cylinderVolume = cylinder.volume();
		
		//double coneArea = cone.area();
		//double coneVolume = cone.volume();
		
//		System.out.println("Volume: " + coneVolume);
//		System.out.println("Area: " + coneArea);
//		
		System.out.println("Volume: " + cylinderVolume);
		System.out.println("Area: " + cylinderArea);
		
	}
	
	public static void TestEquilatrialBase() {
		
		TriangularPrism tPrism = new TriangularPrism(5.0, 4.3);
		System.out.println("Volume: " + tPrism.area());
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void TestImporter(String filename, char compareType) throws FileNotFoundException{
		
		try {
		// ask system which file to handle 
			File file = new File ("res/" + filename);
			Scanner scan = new Scanner(file);
			String shapeCount = scan.nextLine();
			
			shapelist = new ArrayList<Shape>(Integer.parseInt(shapeCount));
			System.out.println("Reading...");
			
			boolean processedOneObj;
			while(scan.hasNext()) {
				processedOneObj = false;
				while(!processedOneObj) {
					String shapeType = scan.next();
					double height = Double.parseDouble(scan.next());
					double length_radius = Double.parseDouble(scan.next());
					
					String className = "shapes." + shapeType;
					Class cls = Class.forName(className);
					Class paramTypes[] = new Class[3];
						paramTypes[0] = Double.TYPE;
						paramTypes[1] = Double.TYPE;
						paramTypes[2] = Character.TYPE;
					Constructor classConstructor = cls.getConstructor(paramTypes);
					
					Object argList[] = new Object[3];
					argList[0] =  (double) height;
					argList[1] = (double)length_radius;
					argList[2] = (double) compareType;
					
					Object obj = classConstructor.newInstance(argList);
					shapelist.add((Shape)obj);
					processedOneObj = true;
				}
			}
			
			scan.close();
			System.out.println("FILE READ.\n");
			
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
		
		Importer importer = new Importer("./res/" + filename);
		try {
			importer.ImportShapes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	private static void arraySort(ArrayList<Shape> shapes, char compareType, char sortType) {
		new Sort(shapes, compareType, sortType);
	}

}
