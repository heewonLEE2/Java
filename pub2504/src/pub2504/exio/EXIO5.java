package pub2504.exio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class EXIO5 {

	public static void main(String[] args) {

		Reader read = null;
		BufferedReader bufferReader = null;
		String line = "";
		
		List<List<String>> csvList = new ArrayList<List<String>>();
		File file = new File("C:\\pub2504\\archive\\Enter_korea_by_age.csv");

		try {
			read = new FileReader(file);
			bufferReader = new BufferedReader(read);
			
			while((line = bufferReader.readLine()) != null) {
				
				List<String> aLine = new ArrayList<String>();
				String[] strArr = line.split(",");
				aLine = Arrays.asList(strArr);
				
				csvList.add(aLine);
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				read.close();
				bufferReader.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		csvList.stream().forEach(e->System.out.println(e));

		Map<String, Integer> nationVisitor =
				csvList.stream()
				.skip(1)
				.collect(Collectors.toMap(e->e.get(1), e->Integer.parseInt(e.get(2)), Integer::sum
						));

		
		System.out.println(nationVisitor.entrySet());
		
	} // main
} // class











