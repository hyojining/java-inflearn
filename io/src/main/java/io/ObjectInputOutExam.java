package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectInputOutExam {

	public static void main(String[] args) throws Exception{
		User user1 = new User("hong@example.com", "홍길동", 1992);
		User user2 = new User("go@example.com", "고길동", 1995);
		User user3 = new User("d@example.com", "둘리", 1991);
		
		// ArrayList 직렬화 가능
		ArrayList<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		ArrayList<User> list2 = copy(list);
		
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
	}

	private static ArrayList<User> copy(ArrayList<User> list) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bout);
		out.writeObject(list);
		out.close();
		bout.close();
		
		byte[] array = bout.toByteArray();
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(array));
		ArrayList<User> list2 = (ArrayList)in.readObject();
		in.close();
		return list2;
	}

}
