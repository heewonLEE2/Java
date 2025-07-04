package pub2504.exthread2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LogThread extends Thread{

	String str = null;
	
	public LogThread() {
	}
	public LogThread(String str) {
		this.str = str;
	}
	
	@Override
	public void run() {
		
		
		File file = new File("C:\\pub2504\\files\\inputstring.log");
		BufferedWriter bw = null;
		try {
			
			bw = new BufferedWriter(new FileWriter(file));
			bw.write("["+LocalDateTime.now()+ "]" +  str);
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // run()
} // class
