package Assessment;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {

	 public static void main(String[] args) {
		
		 Path filepath = Paths.get("example.txt");
		 try {
			 String lines = Files.readString(filepath);
			 System.out.println();
		 }catch() {
			 
		 }
	}
}
