package pub2504.gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ExObject1 {

	public static void main(String[] args) {
		
			BufferedReader br = null;
			BufferedWriter bw = null;
			
			File file = new File("C:\\pub2504\\files\\exObect1.dat");
			
			
		try {
			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			
			ArrayList<Person> personList = new ArrayList<Person>();
			personList.add(new Person("홍길동", 30));
			personList.add(new Person("강감찬", 20));
			personList.add(new Person("이순신", 10));
			
			
			
			
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		
	} // main
} // class













