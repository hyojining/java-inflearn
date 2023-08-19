package io;

import java.io.FileWriter;
import java.io.Writer;

public class HelloIO03 {

	public static void main(String[] args) throws Exception{
		Writer out = new FileWriter("C:/tmp/hello.txt");
		out.write((int)'가');
		out.write((int)'나');
		out.write((int)'다');
		out.close();
	}

}
