package pub2504.io;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataTest {

	public static void main(String[] args) {

		File file = new File("C:\\pub2504\\files\\data.dat");

		DataOutputStream dos = null;

		try {

			dos = new DataOutputStream(new FileOutputStream(file));
			dos.writeInt(20); // 4byte 정수
			dos.writeBoolean(false); // 1byte 불리언
			dos.writeFloat(3.14f); // 4byte 실수
			dos.writeUTF("홍길동");
			dos.flush();

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				dos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		DataInputStream dis = null;

		try {

			dis = new DataInputStream(new FileInputStream(file));
			System.out.println(dis.readInt()); // 들어오는 데이터에 맞는 byte 대로 읽어야함
			System.out.println(dis.readBoolean()); // 들어오는 데이터에 맞는 byte 대로 읽어야함
			System.out.println(dis.readFloat()); // 들어오는 데이터에 맞는 byte 대로 읽어야함
			System.out.println(dis.readUTF()); // 들어오는 데이터에 맞는 byte 대로 읽어야함

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				dis.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main
} // class
