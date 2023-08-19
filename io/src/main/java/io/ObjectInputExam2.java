package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectInputExam2 {

	public static void main(String[] args) throws Exception{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:/tmp/user.dat"));
		ArrayList<User> list = (ArrayList)in.readObject(); // ArrayList로 형변환
		in.close();
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
