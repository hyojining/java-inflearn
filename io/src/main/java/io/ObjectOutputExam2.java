package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectOutputExam2 {

	public static void main(String[] args) throws Exception{
		User user1 = new User("hong@example.com", "홍길동", 1992);
		User user2 = new User("go@example.com", "고길동", 1995);
		User user3 = new User("d@example.com", "둘리", 1991);
		
		// ArrayList 직렬화 가능
		ArrayList<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);

		// 객체를 저장한다.
		// /tmp/user.dat
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:/tmp/user.dat"));
		out.writeObject(list);
		out.close();

	}

}
