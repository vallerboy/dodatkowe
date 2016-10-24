package oskarpolak.lombok;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

import lombok.Cleanup;

public class FilesOperation {

	private File myFile;

	public FilesOperation(boolean override) {

		// dowolny format
		myFile = new File("D:\\oskar.akademiakodu");

		
		try {
			if (override) {
				myFile.createNewFile();

			} else {
				if (!myFile.exists())
					myFile.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void writeToFileJSON() {

		JSONObject obj = new JSONObject();

		obj.put("name", "foo");
		obj.put("num", new Integer(100));
		obj.put("balance", new Double(1000.21));


		// Zapisujemy i konwertujemy JSON do ciągu znaków.
		StringWriter writer = new StringWriter();
		obj.write(writer);
		
		FileOutputStream IS = null;
		try {
			// Zamyka samoczynnie IS, lub można też użyć finally w catch.
			//@Cleanup
			IS = new FileOutputStream(myFile);
			IS.write(writer.toString().getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				IS.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	
	// Rzadko używana
	public void readFromFile() {
		try {
			@Cleanup
			FileInputStream IN = new FileInputStream(myFile);

			int content = 0;
			while ((content = IN.read()) != -1) {
				System.out.print((char) content);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeToFileJavaSimple(){
		try {
			Files.write(Paths.get(myFile.getAbsolutePath()), "nowa linia\n".getBytes(), StandardOpenOption.APPEND);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFromFileSimple(){
		try {
		 List<String> listOfLines = Files.readAllLines(Paths.get(myFile.getAbsolutePath()));
		
		  for(String s : listOfLines){ 
			  System.out.println(s);
		  }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void writeToFileByWriter(){

	
		try {
			@Cleanup
			FileWriter fw = new FileWriter(myFile,true);
			
		    fw.write("\nnowa linia");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //the true will append the new data
	
	}
	
	
	public void readFromFileByReader(){

	
		try {
			@Cleanup
			BufferedReader br = new BufferedReader(new FileReader(myFile));
			  for(String line; (line = br.readLine()) != null; ) {
			        System.out.println(line);
			    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	}
	
	public void readFromFileWithCharset() { 
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader (new FileInputStream(myFile), "UTF-8"));
			  
		      for(String line; (line = in.readLine()) != null;) { 
		    	  System.out.println(line);
		      }
			 
		} catch (UnsupportedEncodingException e) {
		
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readFromFileWithScanner(){ 
		 Scanner scanner = null;
		try {
			scanner = new Scanner(myFile);
			  while(scanner.hasNextLine()){
				  String line = scanner.nextLine();
				  System.out.println(line);
			  }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			scanner.close();
		}
		   
		
	}

}
