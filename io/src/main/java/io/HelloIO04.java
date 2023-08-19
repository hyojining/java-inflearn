package io;

import java.io.FileReader;
import java.io.Reader;

public class HelloIO04 {

	public static void main(String[] args) throws Exception{
		Reader in = new FileReader("C:/tmp/hello.txt");
//		int ch1 = in.read();
//		System.out.println((char)ch1); // 가
//		int ch2 = in.read();
//		System.out.println((char)ch2); // 나
//		int ch3 = in.read();
//		System.out.println((char)ch3); // 다
//		int ch4 = in.read();
//		System.out.println(ch4); // -1
		int ch = -1;
		while((ch = in.read()) != -1) {
			System.out.println((char)ch);
		}
		in.close();
	}

}
