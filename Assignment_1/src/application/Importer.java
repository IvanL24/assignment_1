package application;

import java.io.*;
import java.util.*;

public class Importer {

	private String filePath = "";
	
	public Importer(String filePath) {
		this.filePath = filePath;
	}
	
	public int ImportShapes() throws Exception {
		
		System.out.println("Importing shapes from: " + this.filePath);
		
		File file = new File(this.filePath);
		
		Scanner scanner = new Scanner(file);
		
		int numShapes = scanner.nextInt();
		
		System.out.println("Number of shapes in this file: " + numShapes);
		
		for (int x = 0; x < numShapes; x++) {
			String shapeType = scanner.next();
			double param1 = scanner.nextDouble();
			double param2 = scanner.nextDouble();
			
			
			//System.out.println(shapeType + " " + param1 + " " + param2);
		}
		
		
		
		
		System.out.println("Finished importing shapes");
		
		return 1;
	}
	
}
